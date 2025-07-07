package com.cafemetrix.cafelab.iam.domain.services;

import com.cafemetrix.cafelab.iam.domain.model.aggregates.User;
import com.cafemetrix.cafelab.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> handle(GetUserByUsernameQuery query);
}
