-- Active: 1688044672103@@127.0.0.1@3306@space

CREATE DATABASE IF NOT EXISTS `space`;

CREATE USER
    If not EXISTS 'admin' @'localhost' IDENTIFIED
WITH
    mysql_native_password BY '';

GRANT ALL PRIVILEGES ON space.* TO 'admin'@'localhost';

FLUSH PRIVILEGES;

Use `space`;

show TABLES;

SELECT * FROM player;

show TABLES;

SELECT * FROM clan;

SELECT * FROM building;

SELECT * FROM ressource;

describe clan;

-- drop DATABASE `space`;

-- DELETE FROM `ressource` WHERE `id` = '13';