package com.cafemetrix.cafelab.coffeeproduction.domain.services;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.RoastProfile;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface RoastProfileQueryService {
    List<RoastProfile> getAllRoastProfiles(GetAllRoastProfilesQuery query);
    Optional<RoastProfile> getRoastProfileByName(GetRoastProfileByNameQuery query);
    Optional<RoastProfile> getRoastProfileById(GetRoastProfileByIdQuery query);
    List<RoastProfile> getRoastProfilesByLot(GetRoastProfilesByLotQuery query);
    List<RoastProfile> getFavoriteRoastProfiles(GetFavoriteRoastProfilesQuery query);
    List<RoastProfile> getRoastProfilesSorted(GetRoastProfilesSortedQuery query);
} 