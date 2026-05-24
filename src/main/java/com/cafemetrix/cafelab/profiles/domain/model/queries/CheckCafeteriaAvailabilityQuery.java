package com.cafemetrix.cafelab.profiles.domain.model.queries;

public record CheckCafeteriaAvailabilityQuery(String cafeteriaName, Long excludeUserId) {
}
