package com.cafemetrix.cafelab.profiles.application.internal.queryservices;

import com.cafemetrix.cafelab.profiles.domain.model.aggregates.Profile;
import com.cafemetrix.cafelab.profiles.domain.model.queries.GetAllProfilesQuery;
import com.cafemetrix.cafelab.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.cafemetrix.cafelab.profiles.domain.model.queries.GetProfileByIdQuery;
import com.cafemetrix.cafelab.profiles.domain.services.ProfileQueryService;
import com.cafemetrix.cafelab.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Profile Query Service Implementation
 */
@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final ProfileRepository profileRepository;

    /**
     * Constructor
     *
     * @param profileRepository The {@link ProfileRepository} instance
     */
    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // inherited javadoc
    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.profileId());
    }

    // inherited javadoc
    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmailAddress(query.emailAddress());
    }

    // inherited javadoc
    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }
}
