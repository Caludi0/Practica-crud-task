# Configuracion "application.properties"
spring.datasource.url=jdbc:postgresql://localhost:port/nameBd
spring.datasource.username=usuarioPostgre
spring.datasource.password=contraseñaPostgre
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Creacion de tablas en BD
-- Crear tablas para la lista de tareas
CREATE TABLE users (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(150) UNIQUE NOT NULL
);

CREATE TABLE categories (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL
);
CREATE TABLE tasks (
id SERIAL PRIMARY KEY,
title VARCHAR(200) NOT NULL,
description TEXT,
due_date DATE,
status VARCHAR(50) DEFAULT 'pending',
user_id INT REFERENCES users(id),
category_id INT REFERENCES categories(id)
);

-- Datos de prueba
INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com');
INSERT INTO categories (name) VALUES ('Personal'), ('Work'), ('Hobby');
INSERT INTO tasks (title, description, due_date, status, user_id, category_id)
VALUES
('Task 1', 'First task description', '2024-12-31', 'pending', 1, 1),
('Task 2', 'Second task description', '2025-01-15', 'completed', 1, 2);

