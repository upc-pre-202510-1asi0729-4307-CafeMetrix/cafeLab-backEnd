package com.cafemetrix.cafelab.coffeeproduction.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "roast_profiles")
public class RoastProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int duration;

    @Column(name = "temp_initial", nullable = false)
    private double tempInitial;

    @Column(name = "temp_final", nullable = false)
    private double tempFinal;

    @Column(name = "is_favorite", nullable = false)
    private boolean isFavorite;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "lot_id", nullable = false)
    private Long lot;

    @Column(name = "temp_start", nullable = false)
    private double tempStart;

    @Column(name = "temp_end", nullable = false)
    private double tempEnd;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public double getTempInitial() { return tempInitial; }
    public void setTempInitial(double tempInitial) { this.tempInitial = tempInitial; }
    public double getTempFinal() { return tempFinal; }
    public void setTempFinal(double tempFinal) { this.tempFinal = tempFinal; }
    public boolean isFavorite() { return isFavorite; }
    public void setFavorite(boolean favorite) { isFavorite = favorite; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public Long getLot() { return lot; }
    public void setLot(Long lot) { this.lot = lot; }
    public double getTempStart() { return tempStart; }
    public void setTempStart(double tempStart) { this.tempStart = tempStart; }
    public double getTempEnd() { return tempEnd; }
    public void setTempEnd(double tempEnd) { this.tempEnd = tempEnd; }
} 