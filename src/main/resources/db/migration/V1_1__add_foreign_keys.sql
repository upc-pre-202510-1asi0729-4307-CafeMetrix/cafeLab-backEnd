ALTER TABLE defects
    ADD CONSTRAINT FK_defects_coffee_id
        FOREIGN KEY (coffee_id)
        REFERENCES coffees (id);

ALTER TABLE profiles
    ADD COLUMN user_id BIGINT;

ALTER TABLE profiles
    ADD CONSTRAINT FK_profiles_user_id
        FOREIGN KEY (user_id)
            REFERENCES users (id);

CREATE TABLE IF NOT EXISTS suppliers (
                                         id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         user_id BIGINT NOT NULL,
                                         name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    location VARCHAR(500) NOT NULL,
    specialties VARCHAR(1000) NOT NULL,
    INDEX idx_user_id (user_id),
    INDEX idx_name (name)
    );

CREATE TABLE IF NOT EXISTS lots (
                                    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                    supplier_id BIGINT NOT NULL,
                                    user_id BIGINT NOT NULL,
                                    lot_name VARCHAR(255) NOT NULL,
    coffee_type VARCHAR(100) NOT NULL,
    processing_method VARCHAR(100) NOT NULL,
    altitude VARCHAR(50) NOT NULL,
    weight VARCHAR(50) NOT NULL,
    certifications VARCHAR(500) NOT NULL,
    origin VARCHAR(255) NOT NULL,
    INDEX idx_user_id (user_id),
    INDEX idx_supplier_id (supplier_id),
    INDEX idx_lot_name (lot_name),
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS roast_profiles (
                                              id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                              lot_id BIGINT NOT NULL,
                                              user_id BIGINT NOT NULL,
                                              name VARCHAR(255) NOT NULL,
    type VARCHAR(100) NOT NULL,
    duration INT NOT NULL,
    temp_initial INT NOT NULL,
    temp_final INT NOT NULL,
    temp_start INT NOT NULL,
    temp_end INT NOT NULL,
    is_favorite BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_user_id (user_id),
    INDEX idx_lot_id (lot_id),
    INDEX idx_name (name),
    INDEX idx_is_favorite (is_favorite),
    INDEX idx_created_at (created_at),
    FOREIGN KEY (lot_id) REFERENCES lots(id) ON DELETE CASCADE
    );