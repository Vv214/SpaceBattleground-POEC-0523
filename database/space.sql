-- Active: 1688044672103@@127.0.0.1@3306@space

DROP DATABASE space;

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

SELECT * FROM ressource;

SELECT * FROM clan;

SELECT * FROM building;

SELECT * FROM technologie;

SELECT * FROM planet;

DESCRIBE building;

SELECT * FROM planet;