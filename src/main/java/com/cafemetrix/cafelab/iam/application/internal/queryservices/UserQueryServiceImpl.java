package com.cafemetrix.cafelab.iam.application.internal.queryservices;

import com.cafemetrix.cafelab.iam.domain.model.aggregates.User;
import com.cafemetrix.cafelab.iam.domain.model.queries.GetUserByUsernameQuery;
import com.cafemetrix.cafelab.iam.domain.services.UserQueryService;
import com.cafemetrix.cafelab.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByUsernameQuery query) {
        return userRepository.findByUsername(query.username());
    }
}