-- Active: 1690547072753@@127.0.0.1@3306@space

DROP DATABASE space;

CREATE DATABASE IF NOT EXISTS `space`;

CREATE USER
    If not EXISTS 'admin' @'localhost' IDENTIFIED
WITH
    mysql_native_password BY '';

GRANT ALL PRIVILEGES ON space.* TO 'admin'@'localhost';

FLUSH PRIVILEGES;

Use `space`;

SELECT * FROM player;

SELECT * FROM building;

SELECT * FROM planet;

SELECT * FROM clan;

SELECT * FROM ressource;