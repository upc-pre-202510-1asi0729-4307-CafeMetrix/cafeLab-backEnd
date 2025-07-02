package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.transformers;

import com.cafemetrix.cafelab.coffeemanagement.domain.model.aggregates.ProductionCost;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.commands.CreateProductionCostCommand;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.commands.UpdateProductionCostCommand;
import com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto.*;

public class ProductionCostTransformer {
    
    public static ProductionCostDto toDto(ProductionCost productionCost) {
        return new ProductionCostDto(
                productionCost.getId().value(),
                productionCost.getCoffeeLotId().value(),
                productionCost.getUserId().value(),
                toDirectCostsDto(productionCost.getDirectCosts()),
                toIndirectCostsDto(productionCost.getIndirectCosts()),
                toCostSummaryDto(productionCost.getCostSummary()),
                productionCost.getCreatedAt(),
                productionCost.getUpdatedAt()
        );
    }
    
    public static CreateProductionCostCommand toCreateCommand(CreateProductionCostRequest request, Long userId) {
        return new CreateProductionCostCommand(
                new LotId(request.coffeeLotId()),
                new UserId(userId),
                toDirectCosts(request.directCosts()),
                toIndirectCosts(request.indirectCosts())
        );
    }
    
    public static UpdateProductionCostCommand toUpdateCommand(UpdateProductionCostRequest request, Long id) {
        return new UpdateProductionCostCommand(
                new ProductionCostId(id),
                toDirectCosts(request.directCosts()),
                toIndirectCosts(request.indirectCosts())
        );
    }
    
    private static DirectCostsDto toDirectCostsDto(DirectCosts directCosts) {
        return new DirectCostsDto(
                toRawMaterialsCostDto(directCosts.getRawMaterialsCost()),
                toLaborCostDto(directCosts.getLaborCost()),
                directCosts.getTotalCost()
        );
    }
    
    private static IndirectCostsDto toIndirectCostsDto(IndirectCosts indirectCosts) {
        return new IndirectCostsDto(
                toTransportCostDto(indirectCosts.getTransportCost()),
                toStorageCostDto(indirectCosts.getStorageCost()),
                toProcessingCostDto(indirectCosts.getProcessingCost()),
                toOtherCostsDto(indirectCosts.getOtherCosts()),
                indirectCosts.getTotalCost()
        );
    }
    
    private static CostSummaryDto toCostSummaryDto(CostSummary costSummary) {
        return new CostSummaryDto(
                costSummary.getTotalCost().value(),
                costSummary.getCostPerKg().value(),
                costSummary.getSuggestedPrice().value(),
                costSummary.getPotentialMargin().value(),
                costSummary.getTotalDirectCost().value(),
                costSummary.getTotalIndirectCost().value()
        );
    }
    
    private static RawMaterialsCostDto toRawMaterialsCostDto(RawMaterialsCost rawMaterialsCost) {
        return new RawMaterialsCostDto(
                rawMaterialsCost.getCostPerKg().value(),
                rawMaterialsCost.getQuantity().value(),
                rawMaterialsCost.getTotalCost()
        );
    }
    
    private static LaborCostDto toLaborCostDto(LaborCost laborCost) {
        return new LaborCostDto(
                laborCost.getHoursWorked().value(),
                laborCost.getCostPerHour().value(),
                laborCost.getNumberOfWorkers().value(),
                laborCost.getTotalCost()
        );
    }
    
    private static TransportCostDto toTransportCostDto(TransportCost transportCost) {
        return new TransportCostDto(
                transportCost.getCostPerKg().value(),
                transportCost.getQuantity().value(),
                transportCost.getTotalCost()
        );
    }
    
    private static StorageCostDto toStorageCostDto(StorageCost storageCost) {
        return new StorageCostDto(
                storageCost.getDaysInStorage().value(),
                storageCost.getDailyCost().value(),
                storageCost.getTotalCost()
        );
    }
    
    private static ProcessingCostDto toProcessingCostDto(ProcessingCost processingCost) {
        return new ProcessingCostDto(
                processingCost.getElectricityCost().value(),
                processingCost.getMaintenanceCost().value(),
                processingCost.getSuppliesCost().value(),
                processingCost.getWaterCost().value(),
                processingCost.getDepreciationCost().value(),
                processingCost.getTotalCost()
        );
    }
    
    private static OtherCostsDto toOtherCostsDto(OtherCosts otherCosts) {
        return new OtherCostsDto(
                otherCosts.getQualityControlCost().value(),
                otherCosts.getCertificationsCost().value(),
                otherCosts.getInsuranceCost().value(),
                otherCosts.getAdministrativeCost().value(),
                otherCosts.getTotalCost()
        );
    }
    
    private static DirectCosts toDirectCosts(DirectCostsDto dto) {
        return new DirectCosts(
                toRawMaterialsCost(dto.rawMaterialsCost()),
                toLaborCost(dto.laborCost())
        );
    }
    
    private static IndirectCosts toIndirectCosts(IndirectCostsDto dto) {
        return new IndirectCosts(
                toTransportCost(dto.transportCost()),
                toStorageCost(dto.storageCost()),
                toProcessingCost(dto.processingCost()),
                toOtherCosts(dto.otherCosts())
        );
    }
    
    private static RawMaterialsCost toRawMaterialsCost(RawMaterialsCostDto dto) {
        return new RawMaterialsCost(
                new CostPerKg(dto.costPerKg()),
                new Quantity(dto.quantity())
        );
    }
    
    private static LaborCost toLaborCost(LaborCostDto dto) {
        return new LaborCost(
                new HoursWorked(dto.hoursWorked()),
                new CostPerHour(dto.costPerHour()),
                new NumberOfWorkers(dto.numberOfWorkers())
        );
    }
    
    private static TransportCost toTransportCost(TransportCostDto dto) {
        return new TransportCost(
                new CostPerKg(dto.costPerKg()),
                new Quantity(dto.quantity())
        );
    }
    
    private static StorageCost toStorageCost(StorageCostDto dto) {
        return new StorageCost(
                new DaysInStorage(dto.daysInStorage()),
                new DailyCost(dto.dailyCost())
        );
    }
    
    private static ProcessingCost toProcessingCost(ProcessingCostDto dto) {
        return new ProcessingCost(
                new ElectricityCost(dto.electricity()),
                new MaintenanceCost(dto.maintenance()),
                new SuppliesCost(dto.supplies()),
                new WaterCost(dto.water()),
                new DepreciationCost(dto.depreciation())
        );
    }
    
    private static OtherCosts toOtherCosts(OtherCostsDto dto) {
        return new OtherCosts(
                new QualityControlCost(dto.qualityControl()),
                new CertificationsCost(dto.certifications()),
                new InsuranceCost(dto.insurance()),
                new AdministrativeCost(dto.administrative())
        );
    }
} 