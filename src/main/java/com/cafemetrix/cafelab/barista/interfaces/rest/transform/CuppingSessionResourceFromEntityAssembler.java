package com.cafemetrix.cafelab.barista.interfaces.rest.transform;

import com.cafemetrix.cafelab.barista.domain.model.aggregates.CuppingSession;
import com.cafemetrix.cafelab.barista.interfaces.rest.resources.CuppingSessionResource;

public class CuppingSessionResourceFromEntityAssembler {

    public static CuppingSessionResource toResourceFromEntity(CuppingSession entity) {
        return new CuppingSessionResource(
                entity.getId(),
                entity.getName().name(),
                entity.getOrigin().value(),
                entity.getVariety().value(),
                entity.getProcessingMethod().value(),
                entity.isFavorite(),
                entity.getRoastProfile().value(),
                entity.getLotId().value(),
                entity.getUserId().value(),
                entity.getDate()
        );
    }
}