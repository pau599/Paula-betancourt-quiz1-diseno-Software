-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS motocicletas_db;
USE motocicletas_db;

-- Crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE motocicletas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    cilindraje INT NOT NULL,
    color VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

-- Verificar que la columna 'modelo' existe
DESCRIBE motocicletas;