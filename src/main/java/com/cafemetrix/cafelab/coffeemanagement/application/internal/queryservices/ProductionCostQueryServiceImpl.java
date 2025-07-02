package com.cafemetrix.cafelab.coffeemanagement.application.internal.queryservices;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.ProductionCost;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.queries.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.services.ProductionCostQueryService;
import com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.entities.ProductionCostEntity;
import com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.repositories.ProductionCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductionCostQueryServiceImpl implements ProductionCostQueryService {
    
    @Autowired
    private ProductionCostRepository productionCostRepository;

    @Override
    public List<ProductionCost> getAllProductionCosts(GetAllProductionCostsQuery query) {
        return productionCostRepository.findAllByUserId(query.userId().value())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductionCost> getProductionCostById(GetProductionCostByIdQuery query) {
        return productionCostRepository.findById(query.id().value())
                .map(this::toDomain);
    }

    @Override
    public List<ProductionCost> getProductionCostsByLot(GetProductionCostsByLotQuery query) {
        return productionCostRepository.findAllByCoffeeLotId(query.lotId().value())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private ProductionCost toDomain(ProductionCostEntity entity) {
        // Crear value objects para costos directos
        RawMaterialsCost rawMaterialsCost = new RawMaterialsCost(
            new CostPerKg(entity.getRawMaterialsCost()),
            new Quantity(entity.getRawMaterialsQuantity())
        );
        
        LaborCost laborCost = new LaborCost(
            new HoursWorked(entity.getLaborHours()),
            new CostPerHour(entity.getLaborCostPerHour()),
            new NumberOfWorkers(entity.getLaborWorkers())
        );
        
        DirectCosts directCosts = new DirectCosts(rawMaterialsCost, laborCost);
        
        // Crear value objects para costos indirectos
        TransportCost transportCost = new TransportCost(
            new CostPerKg(entity.getTransportCost()),
            new Quantity(entity.getTransportQuantity())
        );
        
        StorageCost storageCost = new StorageCost(
            new DaysInStorage(entity.getStorageDays()),
            new DailyCost(entity.getStorageDailyCost())
        );
        
        ProcessingCost processingCost = new ProcessingCost(
            new ElectricityCost(entity.getProcessingElectricity()),
            new MaintenanceCost(entity.getProcessingMaintenance()),
            new SuppliesCost(entity.getProcessingSupplies()),
            new WaterCost(entity.getProcessingWater()),
            new DepreciationCost(entity.getProcessingDepreciation())
        );
        
        OtherCosts otherCosts = new OtherCosts(
            new QualityControlCost(entity.getOtherQualityControl()),
            new CertificationsCost(entity.getOtherCertifications()),
            new InsuranceCost(entity.getOtherInsurance()),
            new AdministrativeCost(entity.getOtherAdministrative())
        );
        
        IndirectCosts indirectCosts = new IndirectCosts(transportCost, storageCost, processingCost, otherCosts);
        
        return new ProductionCost(
            new ProductionCostId(entity.getId()),
            new LotId(entity.getCoffeeLotId()),
            new UserId(entity.getUserId()),
            directCosts,
            indirectCosts
        );
    }
} 