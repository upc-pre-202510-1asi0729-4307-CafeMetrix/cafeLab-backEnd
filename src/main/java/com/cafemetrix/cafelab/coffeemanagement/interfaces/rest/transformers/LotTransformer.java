package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.transformers;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Lot;
import com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto.LotDto;

import java.util.Arrays;
import java.util.List;

public class LotTransformer {
    
    public static LotDto toDto(Lot lot) {
        return new LotDto(
                lot.getId().value(),
                lot.getLotName().value(),
                lot.getCoffeeType().value(),
                lot.getProcessingMethod().value(),
                lot.getAltitude().value(),
                lot.getWeight().value(),
                lot.getCertifications().values(),
                lot.getOrigin().value(),
                lot.getSupplierId().value(),
                lot.getUserId().value(),
                lot.getStatus()
        );
    }
} 