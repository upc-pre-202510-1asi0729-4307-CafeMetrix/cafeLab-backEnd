package com.cafemetrix.cafelab.coffeeproduction.application.internal;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.RoastProfile;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetAllRoastProfilesQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetRoastProfileByIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetRoastProfilesByCoffeeLotIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetRoastProfilesByUserIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.RoastProfileQueryService;
import com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.repositories.RoastProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoastProfileQueryServiceImpl implements RoastProfileQueryService {
    private final RoastProfileRepository roastProfileRepository;

    public RoastProfileQueryServiceImpl(RoastProfileRepository roastProfileRepository) {
        this.roastProfileRepository = roastProfileRepository;
    }

    @Override
    public List<RoastProfile> handle(GetAllRoastProfilesQuery query) {
        return roastProfileRepository.findAll();
    }

    @Override
    public Optional<RoastProfile> handle(GetRoastProfileByIdQuery query) {
        return roastProfileRepository.findById(query.roastProfileId());
    }

    @Override
    public List<RoastProfile> handle(GetRoastProfilesByUserIdQuery query) {
        return roastProfileRepository.findByUserId(query.userId());
    }

    @Override
    public List<RoastProfile> handle(GetRoastProfilesByCoffeeLotIdQuery query) {
        return roastProfileRepository.findByCoffeeLotId(query.coffeeLotId());
    }
} 