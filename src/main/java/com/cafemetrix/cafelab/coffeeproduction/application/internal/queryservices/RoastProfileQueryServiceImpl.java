package com.cafemetrix.cafelab.coffeeproduction.application.internal.queryservices;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.RoastProfile;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.RoastProfileQueryService;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.entities.RoastProfileEntity;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.repositories.RoastProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoastProfileQueryServiceImpl implements RoastProfileQueryService {
    
    @Autowired
    private RoastProfileRepository roastProfileRepository;

    @Override
    public List<RoastProfile> getAllRoastProfiles(GetAllRoastProfilesQuery query) {
        return roastProfileRepository.findAllByUserId(query.userId().value())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoastProfile> getRoastProfileByName(GetRoastProfileByNameQuery query) {
        return roastProfileRepository.findByName(query.name())
                .map(this::toDomain);
    }

    @Override
    public Optional<RoastProfile> getRoastProfileById(GetRoastProfileByIdQuery query) {
        return roastProfileRepository.findById(query.roastProfileId().value())
                .map(this::toDomain);
    }

    @Override
    public List<RoastProfile> getRoastProfilesByLot(GetRoastProfilesByLotQuery query) {
        return roastProfileRepository.findAllByLot(query.lotId().value())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoastProfile> getFavoriteRoastProfiles(GetFavoriteRoastProfilesQuery query) {
        return roastProfileRepository.findAllByUserIdAndIsFavoriteTrue(query.userId().value())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoastProfile> getRoastProfilesSorted(GetRoastProfilesSortedQuery query) {
        Sort sort = Sort.by(Sort.Direction.fromString(query.sortOrder().toUpperCase()), "createdAt");
        return roastProfileRepository.findAllByUserId(query.userId().value(), sort)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
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