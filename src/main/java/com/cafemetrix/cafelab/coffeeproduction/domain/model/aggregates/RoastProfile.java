package com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;

import java.time.LocalDateTime;

public class RoastProfile {
    private final RoastProfileId id;
    private final UserId userId;
    private ProfileName name;
    private RoastType type;
    private Duration duration;
    private Temperature tempInitial;
    private Temperature tempFinal;
    private boolean isFavorite;
    private LocalDateTime createdAt;
    private LotId lot;
    private Temperature tempStart;
    private Temperature tempEnd;

    public RoastProfile(RoastProfileId id, UserId userId, ProfileName name, RoastType type, Duration duration,
                       Temperature tempInitial, Temperature tempFinal, boolean isFavorite, LocalDateTime createdAt,
                       LotId lot, Temperature tempStart, Temperature tempEnd) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.tempInitial = tempInitial;
        this.tempFinal = tempFinal;
        this.isFavorite = isFavorite;
        this.createdAt = createdAt;
        this.lot = lot;
        this.tempStart = tempStart;
        this.tempEnd = tempEnd;
    }

    // Getters
    public RoastProfileId getId() { return id; }
    public UserId getUserId() { return userId; }
    public ProfileName getName() { return name; }
    public RoastType getType() { return type; }
    public Duration getDuration() { return duration; }
    public Temperature getTempInitial() { return tempInitial; }
    public Temperature getTempFinal() { return tempFinal; }
    public boolean isFavorite() { return isFavorite; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LotId getLot() { return lot; }
    public Temperature getTempStart() { return tempStart; }
    public Temperature getTempEnd() { return tempEnd; }

    // Setters
    public void setName(ProfileName name) { this.name = name; }
    public void setType(RoastType type) { this.type = type; }
    public void setDuration(Duration duration) { this.duration = duration; }
    public void setTempInitial(Temperature tempInitial) { this.tempInitial = tempInitial; }
    public void setTempFinal(Temperature tempFinal) { this.tempFinal = tempFinal; }
    public void setFavorite(boolean favorite) { isFavorite = favorite; }
    public void setLot(LotId lot) { this.lot = lot; }
    public void setTempStart(Temperature tempStart) { this.tempStart = tempStart; }
    public void setTempEnd(Temperature tempEnd) { this.tempEnd = tempEnd; }
} 