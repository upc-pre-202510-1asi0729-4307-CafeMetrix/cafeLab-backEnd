CREATE TABLE IF NOT EXISTS inventory_entries (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    coffee_lot_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    quantity_used DOUBLE NOT NULL,
    date_used TIMESTAMP NOT NULL,
    final_product VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_user_id (user_id),
    INDEX idx_coffee_lot_id (coffee_lot_id),
    INDEX idx_date_used (date_used),
    INDEX idx_created_at (created_at),
    FOREIGN KEY (coffee_lot_id) REFERENCES lots(id) ON DELETE CASCADE
); 