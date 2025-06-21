package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.transformers;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.Lot;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateLotCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.LotId;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.SupplierId;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.CreateLotRequest;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.LotDto;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.UpdateLotRequest;

public class LotTransformer {
    
    public static LotDto toDto(Lot lot) {
        return new LotDto(
                lot.getId().value(),
                lot.getSupplierId().value(),
                lot.getUserId().value(),
                lot.getLotName().value(),
                lot.getCoffeeType().value(),
                lot.getProcessingMethod().value(),
                lot.getAltitude().value(),
                lot.getWeight().value(),
                lot.getCertifications().values(),
                lot.getOrigin().value()
        );
    }
    
    public static CreateLotCommand toCreateCommand(CreateLotRequest request, Long userId) {
        return new CreateLotCommand(
                new SupplierId(request.supplierId()),
                new UserId(userId),
                request.lotName(),
                request.coffeeType(),
                request.processingMethod(),
                request.altitude(),
                request.weight(),
                request.certifications(),
                request.origin()
        );
    }
    
    public static UpdateLotCommand toUpdateCommand(UpdateLotRequest request, Long lotId) {
        return new UpdateLotCommand(
                new LotId(lotId),
                request.lotName(),
                request.coffeeType(),
                request.processingMethod(),
                request.altitude(),
                request.weight(),
                request.certifications(),
                request.origin()
        );
    }
} 