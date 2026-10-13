
CREATE DATABASE IF NOT EXISTS petcare_plus
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE petcare_plus;

CREATE TABLE IF NOT EXISTS pets (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    species VARCHAR(255) NOT NULL,
    breed VARCHAR(255),
    gender VARCHAR(255),
    birth_date DATE,
    weight_kg DOUBLE,
    photo_url VARCHAR(1000),
    allergies VARCHAR(255),
    notes VARCHAR(1000),
    created_at DATETIME(6)
);

CREATE TABLE IF NOT EXISTS care_records (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pet_id BIGINT NOT NULL,
    category VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    record_date DATE,
    next_due_date DATE,
    amount DOUBLE,
    unit VARCHAR(255),
    notes VARCHAR(1500),
    CONSTRAINT fk_care_record_pet
        FOREIGN KEY (pet_id) REFERENCES pets(id)
);

CREATE TABLE IF NOT EXISTS reminders (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pet_id BIGINT NOT NULL,
    type VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    due_date DATE NOT NULL,
    due_time TIME,
    completed BOOLEAN NOT NULL DEFAULT FALSE,
    notes VARCHAR(1000),
    CONSTRAINT fk_reminder_pet
        FOREIGN KEY (pet_id) REFERENCES pets(id)
);
