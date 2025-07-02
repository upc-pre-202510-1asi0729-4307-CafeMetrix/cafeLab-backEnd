package com.cafemetrix.cafelab.coffeemanagement.application.internal.queryservices;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Lot;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.queries.GetAllLotsQuery;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;
import com.cafemetrix.cafelab.coffeeproduction.domain.services.LotQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeLotQueryService {
    
    @Autowired
    private LotQueryService lotQueryService;
    
    public List<Lot> getLotsByUserId(Long userId) {
        GetAllLotsQuery query = new GetAllLotsQuery(new UserId(userId));
        return lotQueryService.getAllLots(query);
    }
} 