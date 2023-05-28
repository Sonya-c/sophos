CREATE DATABASE IF NOT EXISTS SOPHOS;

USE SOPHOS;

CREATE TABLE client (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    names VARCHAR(255),
    lastnames VARCHAR(255),
    email VARCHAR(255),
    cellphone VARCHAR(255),
    address VARCHAR(255),
    birthdate DATETIME(6)
);


CREATE TABLE director (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE producer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE platform (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE videogame_title (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    realise_date DATETIME(6),
    loan_price DOUBLE,
    protagonists VARCHAR(255),
    director_id INT,
    producer_id INT,
    platform_id INT,
    FOREIGN KEY (director_id) REFERENCES director(id),
    FOREIGN KEY (producer_id) REFERENCES producer(id),
    FOREIGN KEY (platform_id) REFERENCES platform(id)
);

CREATE TABLE videogame_unit (
    id INT PRIMARY KEY AUTO_INCREMENT,
    avaliable_status BOOLEAN,
    videogame_title_id INT,
    FOREIGN KEY (videogame_title_id) REFERENCES videogame_title(id)
);

CREATE TABLE loan (
    id INT PRIMARY KEY AUTO_INCREMENT,
    loan_date DATETIME(6),
    return_date DATETIME(6),
    status BOOLEAN,
    videogame_unit_id INT,
    client_id INT,
    FOREIGN KEY (videogame_unit_id) REFERENCES videogame_unit(id),
    FOREIGN KEY (client_id) REFERENCES client(id)
);
