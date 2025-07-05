package com.cafemetrix.cafelab.barista.domain.model.commands;
import com.cafemetrix.cafelab.barista.domain.model.valueobjects.CuppingSessionName;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates.RoastProfile;
import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffees.domain.model.valueobjects.CoffeeVariety;

import java.time.LocalDateTime;

public record CreateCuppingSessionCommand(
        CuppingSessionName cuppingSessionName,
        Origin origin,
        CoffeeVariety variety,
        ProcessingMethod processingMethod,
        Boolean favorite,
        RoastProfileId roastProfile,
        LotId lotId,
        UserId userId,
        LocalDateTime date
) {
}