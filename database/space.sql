-- Active: 1688044672103@@127.0.0.1@3306@space

CREATE DATABASE IF NOT EXISTS `space`;

GRANT ALL PRIVILEGES ON space.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;

Use `space`;

SELECT * FROM player;