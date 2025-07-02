package com.cafemetrix.cafelab.coffeemanagement.application.internal.commandservices;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.ProductionCost;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.commands.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeemanagement.domain.services.ProductionCostCommandService;
import com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.entities.ProductionCostEntity;
import com.cafemetrix.cafelab.coffeemanagement.infrastructure.persistence.jpa.repositories.ProductionCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductionCostCommandServiceImpl implements ProductionCostCommandService {
    
    @Autowired
    private ProductionCostRepository productionCostRepository;

    @Override
    public ProductionCost createProductionCost(CreateProductionCostCommand command) {
        ProductionCostEntity entity = new ProductionCostEntity();
        entity.setCoffeeLotId(command.coffeeLotId().value());
        entity.setUserId(command.userId().value());
        
        // Costos directos
        entity.setRawMaterialsCost(command.directCosts().getRawMaterialsCost().getCostPerKg().value());
        entity.setRawMaterialsQuantity(command.directCosts().getRawMaterialsCost().getQuantity().value());
        entity.setLaborHours(command.directCosts().getLaborCost().getHoursWorked().value());
        entity.setLaborCostPerHour(command.directCosts().getLaborCost().getCostPerHour().value());
        entity.setLaborWorkers(command.directCosts().getLaborCost().getNumberOfWorkers().value());
        
        // Costos indirectos
        entity.setTransportCost(command.indirectCosts().getTransportCost().getCostPerKg().value());
        entity.setTransportQuantity(command.indirectCosts().getTransportCost().getQuantity().value());
        entity.setStorageDays(command.indirectCosts().getStorageCost().getDaysInStorage().value());
        entity.setStorageDailyCost(command.indirectCosts().getStorageCost().getDailyCost().value());
        entity.setProcessingElectricity(command.indirectCosts().getProcessingCost().getElectricityCost().value());
        entity.setProcessingMaintenance(command.indirectCosts().getProcessingCost().getMaintenanceCost().value());
        entity.setProcessingSupplies(command.indirectCosts().getProcessingCost().getSuppliesCost().value());
        entity.setProcessingWater(command.indirectCosts().getProcessingCost().getWaterCost().value());
        entity.setProcessingDepreciation(command.indirectCosts().getProcessingCost().getDepreciationCost().value());
        entity.setOtherQualityControl(command.indirectCosts().getOtherCosts().getQualityControlCost().value());
        entity.setOtherCertifications(command.indirectCosts().getOtherCosts().getCertificationsCost().value());
        entity.setOtherInsurance(command.indirectCosts().getOtherCosts().getInsuranceCost().value());
        entity.setOtherAdministrative(command.indirectCosts().getOtherCosts().getAdministrativeCost().value());
        
        // Set timestamps
        LocalDateTime now = LocalDateTime.now();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
        
        ProductionCostEntity saved = productionCostRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public ProductionCost updateProductionCost(UpdateProductionCostCommand command) {
        ProductionCostEntity entity = productionCostRepository.findById(command.id().value())
                .orElseThrow(() -> new RuntimeException("Production cost not found"));
        
        // Actualizar costos directos
        entity.setRawMaterialsCost(command.directCosts().getRawMaterialsCost().getCostPerKg().value());
        entity.setRawMaterialsQuantity(command.directCosts().getRawMaterialsCost().getQuantity().value());
        entity.setLaborHours(command.directCosts().getLaborCost().getHoursWorked().value());
        entity.setLaborCostPerHour(command.directCosts().getLaborCost().getCostPerHour().value());
        entity.setLaborWorkers(command.directCosts().getLaborCost().getNumberOfWorkers().value());
        
        // Actualizar costos indirectos
        entity.setTransportCost(command.indirectCosts().getTransportCost().getCostPerKg().value());
        entity.setTransportQuantity(command.indirectCosts().getTransportCost().getQuantity().value());
        entity.setStorageDays(command.indirectCosts().getStorageCost().getDaysInStorage().value());
        entity.setStorageDailyCost(command.indirectCosts().getStorageCost().getDailyCost().value());
        entity.setProcessingElectricity(command.indirectCosts().getProcessingCost().getElectricityCost().value());
        entity.setProcessingMaintenance(command.indirectCosts().getProcessingCost().getMaintenanceCost().value());
        entity.setProcessingSupplies(command.indirectCosts().getProcessingCost().getSuppliesCost().value());
        entity.setProcessingWater(command.indirectCosts().getProcessingCost().getWaterCost().value());
        entity.setProcessingDepreciation(command.indirectCosts().getProcessingCost().getDepreciationCost().value());
        entity.setOtherQualityControl(command.indirectCosts().getOtherCosts().getQualityControlCost().value());
        entity.setOtherCertifications(command.indirectCosts().getOtherCosts().getCertificationsCost().value());
        entity.setOtherInsurance(command.indirectCosts().getOtherCosts().getInsuranceCost().value());
        entity.setOtherAdministrative(command.indirectCosts().getOtherCosts().getAdministrativeCost().value());
        
        // Update timestamp
        entity.setUpdatedAt(LocalDateTime.now());
        
        ProductionCostEntity saved = productionCostRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public boolean deleteProductionCost(DeleteProductionCostCommand command) {
        if (productionCostRepository.existsById(command.id().value())) {
            productionCostRepository.deleteById(command.id().value());
            return true;
        }
        return false;
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