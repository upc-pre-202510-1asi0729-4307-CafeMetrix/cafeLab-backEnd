package com.cafemetrix.cafelab.coffeeproduction.application.internal.commandservices;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.RoastProfile;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.RoastProfileCommandService;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.entities.RoastProfileEntity;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.repositories.RoastProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RoastProfileCommandServiceImpl implements RoastProfileCommandService {
    
    @Autowired
    private RoastProfileRepository roastProfileRepository;

    @Override
    public RoastProfile createRoastProfile(CreateRoastProfileCommand command) {
        RoastProfileEntity entity = new RoastProfileEntity();
        entity.setUserId(command.userId().value());
        entity.setName(command.name());
        entity.setType(command.type());
        entity.setDuration(command.duration());
        entity.setTempInitial(command.tempInitial());
        entity.setTempFinal(command.tempFinal());
        entity.setFavorite(command.isFavorite());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setLot(command.lot());
        entity.setTempStart(command.tempStart());
        entity.setTempEnd(command.tempEnd());
        
        RoastProfileEntity saved = roastProfileRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public RoastProfile updateRoastProfile(UpdateRoastProfileCommand command) {
        RoastProfileEntity entity = roastProfileRepository.findById(command.roastProfileId().value())
                .orElseThrow(() -> new RuntimeException("Roast profile not found"));
        
        entity.setName(command.name());
        entity.setType(command.type());
        entity.setDuration(command.duration());
        entity.setTempInitial(command.tempInitial());
        entity.setTempFinal(command.tempFinal());
        entity.setFavorite(command.isFavorite());
        entity.setLot(command.lot());
        entity.setTempStart(command.tempStart());
        entity.setTempEnd(command.tempEnd());
        
        RoastProfileEntity saved = roastProfileRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public boolean deleteRoastProfile(DeleteRoastProfileCommand command) {
        if (roastProfileRepository.existsById(command.roastProfileId().value())) {
            roastProfileRepository.deleteById(command.roastProfileId().value());
            return true;
        }
        return false;
    }

    @Override
    public RoastProfile toggleFavorite(ToggleFavoriteCommand command) {
        RoastProfileEntity entity = roastProfileRepository.findById(command.roastProfileId().value())
                .orElseThrow(() -> new RuntimeException("Roast profile not found"));
        
        entity.setFavorite(!entity.isFavorite());
        RoastProfileEntity saved = roastProfileRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public RoastProfile duplicateRoastProfile(DuplicateRoastProfileCommand command) {
        RoastProfileEntity original = roastProfileRepository.findById(command.roastProfileId().value())
                .orElseThrow(() -> new RuntimeException("Roast profile not found"));
        
        RoastProfileEntity duplicate = new RoastProfileEntity();
        duplicate.setUserId(original.getUserId());
        duplicate.setName(original.getName() + " (Copy)");
        duplicate.setType(original.getType());
        duplicate.setDuration(original.getDuration());
        duplicate.setTempInitial(original.getTempInitial());
        duplicate.setTempFinal(original.getTempFinal());
        duplicate.setFavorite(false); // New copy is not favorite by default
        duplicate.setCreatedAt(LocalDateTime.now());
        duplicate.setLot(original.getLot());
        duplicate.setTempStart(original.getTempStart());
        duplicate.setTempEnd(original.getTempEnd());
        
        RoastProfileEntity saved = roastProfileRepository.save(duplicate);
        return toDomain(saved);
    }

    private RoastProfile toDomain(RoastProfileEntity entity) {
        return new RoastProfile(
                new RoastProfileId(entity.getId()),
                new UserId(entity.getUserId()),
                new ProfileName(entity.getName()),
                new RoastType(entity.getType()),
                new Duration(entity.getDuration()),
                new Temperature(entity.getTempInitial()),
                new Temperature(entity.getTempFinal()),
                entity.isFavorite(),
                entity.getCreatedAt(),
                new LotId(entity.getLot()),
                new Temperature(entity.getTempStart()),
                new Temperature(entity.getTempEnd())
        );
    }
} 