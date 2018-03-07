DROP DATABASE pascal_handbook;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema pascal_handbook
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pascal_handbook
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pascal_handbook` DEFAULT CHARACTER SET utf8 ;
USE `pascal_handbook` ;

-- -----------------------------------------------------
-- Table `pascal_handbook`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pascal_handbook`.`article` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `body` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

