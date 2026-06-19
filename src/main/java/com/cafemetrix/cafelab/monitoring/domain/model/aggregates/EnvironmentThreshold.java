package com.cafemetrix.cafelab.monitoring.domain.model.aggregates;

import com.cafemetrix.cafelab.monitoring.domain.model.commands.CreateEnvironmentThresholdCommand;
import com.cafemetrix.cafelab.monitoring.domain.model.valueobjects.HumidityThreshold;
import com.cafemetrix.cafelab.monitoring.domain.model.valueobjects.TemperatureThreshold;
import com.cafemetrix.cafelab.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class EnvironmentThreshold extends AuditableAbstractAggregateRoot<EnvironmentThreshold> {
    @Column(nullable = false, unique = true)
    private Long coffeeLotId;

    @Embedded
    private TemperatureThreshold  temperatureThreshold;

    @Embedded
    private HumidityThreshold humidityThreshold;

    // Cadencia (segundos) con la que el edge re-baja los umbrales. Null = el edge
    // usa su propio valor por defecto.
    @Column
    private Integer syncIntervalSeconds;

    public EnvironmentThreshold(CreateEnvironmentThresholdCommand command) {
        this.coffeeLotId = command.coffeeLotId();
        this.temperatureThreshold = new TemperatureThreshold(command.minTemperature(), command.maxTemperature());
        this.humidityThreshold = new HumidityThreshold(command.minHumidity(), command.maxHumidity());
        this.syncIntervalSeconds = command.syncIntervalSeconds();
    }

    public void updateThresholds(Double minTemp, Double maxTemp, Double minHum, Double maxHum, Integer syncIntervalSeconds) {
        this.temperatureThreshold = new TemperatureThreshold(minTemp, maxTemp);
        this.humidityThreshold = new HumidityThreshold(minHum, maxHum);
        this.syncIntervalSeconds = syncIntervalSeconds;
    }
}
