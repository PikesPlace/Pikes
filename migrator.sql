DROP DATABASE IF EXISTS pikes_db;
CREATE DATABASE IF NOT EXISTS pikes_db;
DROP USER IF EXISTS 'pikesuser'@'localhost';
CREATE USER 'pikesuser'@'localhost' IDENTIFIED BY 'pikes';
GRANT ALL ON pikes_db.* TO 'pikesuser'@'localhost';
USE pikes_db;