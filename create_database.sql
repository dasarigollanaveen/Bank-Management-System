-- File: create_database.sql
CREATE DATABASE bank;

USE bank;

CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(255),
    account_type VARCHAR(50),
    balance DOUBLE
);
