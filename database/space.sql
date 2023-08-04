-- Active: 1688047437572@@127.0.0.1@3306@space

CREATE DATABASE IF NOT EXISTS `space`;

CREATE USER
    If not EXISTS 'admin' @'localhost' IDENTIFIED
WITH
    mysql_native_password BY '';

GRANT ALL PRIVILEGES ON space.* TO 'admin'@'localhost';

FLUSH PRIVILEGES;

Use `space`;



SELECT * FROM clan;

show TABLES;

 drop DATABASE `space`;