package com.cafemetrix.cafelab.profiles.application.internal.queryservices;

import com.cafemetrix.cafelab.profiles.domain.model.aggregates.Profile;
import com.cafemetrix.cafelab.profiles.domain.model.queries.CheckCafeteriaAvailabilityQuery;
import com.cafemetrix.cafelab.profiles.domain.model.queries.CheckEmailAvailabilityQuery;
import com.cafemetrix.cafelab.profiles.domain.model.queries.GetAllProfilesQuery;
import com.cafemetrix.cafelab.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.cafemetrix.cafelab.profiles.domain.model.queries.GetProfileByIamUserIdQuery;
import com.cafemetrix.cafelab.profiles.domain.model.queries.GetProfileByIdQuery;
import com.cafemetrix.cafelab.profiles.domain.services.ProfileQueryService;
import com.cafemetrix.cafelab.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

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

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.userId());
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        if (query.emailAddress() == null || query.emailAddress().address() == null) {
            return Optional.empty();
        }
        String raw = query.emailAddress().address().trim();
        if (raw.isEmpty()) {
            return Optional.empty();
        }
        String normalized = raw.toLowerCase(Locale.ROOT);
        return profileRepository.findByNormalizedEmail(normalized);
    }

    @Override
    public Optional<Profile> handle(GetProfileByIamUserIdQuery query) {
        if (query.iamUserId() == null) {
            return Optional.empty();
        }
        return profileRepository.findByIamUserId(query.iamUserId());
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }

    @Override
    public boolean handle(CheckEmailAvailabilityQuery query) {
        if (query.email() == null) {
            return true;
        }
        String raw = query.email().trim();
        if (raw.isEmpty()) {
            return true;
        }
        String normalized = raw.toLowerCase(Locale.ROOT);
        var existing = profileRepository.findByNormalizedEmail(normalized);
        if (existing.isEmpty()) {
            return true;
        }
        return query.excludeUserId() != null
                && existing.get().getId().equals(query.excludeUserId());
    }

    @Override
    public boolean handle(CheckCafeteriaAvailabilityQuery query) {
        if (query.cafeteriaName() == null) {
            return true;
        }
        String raw = query.cafeteriaName().trim();
        if (raw.isEmpty()) {
            return true;
        }
        String normalized = raw.toLowerCase(Locale.ROOT);
        var existing = profileRepository.findByNormalizedCafeteriaName(normalized);
        if (existing.isEmpty()) {
            return true;
        }
        return query.excludeUserId() != null
                && existing.get().getId().equals(query.excludeUserId());
    }
}
