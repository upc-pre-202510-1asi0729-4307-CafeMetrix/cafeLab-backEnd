package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.transformers;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.RoastProfile;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.CreateRoastProfileCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.commands.UpdateRoastProfileCommand;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.RoastProfileId;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.UserId;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.CreateRoastProfileRequest;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.RoastProfileDto;
import com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto.UpdateRoastProfileRequest;

public class RoastProfileTransformer {
    
    public static RoastProfileDto toDto(RoastProfile roastProfile) {
        return new RoastProfileDto(
                roastProfile.getId().value(),
                roastProfile.getUserId().value(),
                roastProfile.getName().value(),
                roastProfile.getType().value(),
                roastProfile.getDuration().value(),
                roastProfile.getTempInitial().value(),
                roastProfile.getTempFinal().value(),
                roastProfile.isFavorite(),
                roastProfile.getCreatedAt(),
                roastProfile.getLot().value(),
                roastProfile.getTempStart().value(),
                roastProfile.getTempEnd().value()
        );
    }
    
    public static CreateRoastProfileCommand toCreateCommand(CreateRoastProfileRequest request, Long userId) {
        return new CreateRoastProfileCommand(
                new UserId(userId),
                request.name(),
                request.type(),
                request.duration(),
                request.tempInitial(),
                request.tempFinal(),
                request.isFavorite(),
                request.lot(),
                request.tempStart(),
                request.tempEnd()
        );
    }
    
    public static UpdateRoastProfileCommand toUpdateCommand(UpdateRoastProfileRequest request, Long roastProfileId) {
        return new UpdateRoastProfileCommand(
                new RoastProfileId(roastProfileId),
                request.name(),
                request.type(),
                request.duration(),
                request.tempInitial(),
                request.tempFinal(),
                request.isFavorite(),
                request.lot(),
                request.tempStart(),
                request.tempEnd()
        );
    }
} 