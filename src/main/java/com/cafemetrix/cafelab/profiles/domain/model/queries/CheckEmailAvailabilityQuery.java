package com.cafemetrix.cafelab.profiles.domain.model.queries;

public record CheckEmailAvailabilityQuery(String email, Long excludeUserId) {
}
