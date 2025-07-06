package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.RoastProfile;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetAllRoastProfilesQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetRoastProfileByIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetRoastProfilesByCoffeeLotIdQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetRoastProfilesByUserIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * RoastProfile Query Service Interface
 */
public interface RoastProfileQueryService {
    List<RoastProfile> handle(GetAllRoastProfilesQuery query);
    Optional<RoastProfile> handle(GetRoastProfileByIdQuery query);
    List<RoastProfile> handle(GetRoastProfilesByUserIdQuery query);
    List<RoastProfile> handle(GetRoastProfilesByCoffeeLotIdQuery query);
} 