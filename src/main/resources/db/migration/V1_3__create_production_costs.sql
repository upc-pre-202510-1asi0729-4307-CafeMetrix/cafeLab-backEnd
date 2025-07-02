CREATE TABLE IF NOT EXISTS production_costs (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    coffee_lot_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    
    -- Costos directos
    raw_materials_cost DOUBLE NOT NULL,
    raw_materials_quantity DOUBLE NOT NULL,
    labor_hours DOUBLE NOT NULL,
    labor_cost_per_hour DOUBLE NOT NULL,
    labor_workers INT NOT NULL,
    
    -- Costos indirectos
    transport_cost DOUBLE NOT NULL,
    transport_quantity DOUBLE NOT NULL,
    storage_days INT NOT NULL,
    storage_daily_cost DOUBLE NOT NULL,
    processing_electricity DOUBLE NOT NULL,
    processing_maintenance DOUBLE NOT NULL,
    processing_supplies DOUBLE NOT NULL,
    processing_water DOUBLE NOT NULL,
    processing_depreciation DOUBLE NOT NULL,
    other_quality_control DOUBLE NOT NULL,
    other_certifications DOUBLE NOT NULL,
    other_insurance DOUBLE NOT NULL,
    other_administrative DOUBLE NOT NULL,
    
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    INDEX idx_user_id (user_id),
    INDEX idx_coffee_lot_id (coffee_lot_id),
    INDEX idx_created_at (created_at),
    FOREIGN KEY (coffee_lot_id) REFERENCES lots(id) ON DELETE CASCADE
); 