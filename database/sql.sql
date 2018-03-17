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
-- Table `pascal_handbook`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pascal_handbook`.`image` (
  `image_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `path` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`image_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pascal_handbook`.`author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pascal_handbook`.`author` (
  `author_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `country` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`author_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pascal_handbook`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pascal_handbook`.`article` (
  `article_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `body` TEXT NOT NULL,
  `date` DATE NOT NULL,
  `fk_image_id` INT UNSIGNED NOT NULL,
  `fk_author_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`article_id`),
  INDEX `fk_image_idx` (`fk_image_id` ASC),
  INDEX `fk_author_idx` (`fk_author_id` ASC),
  CONSTRAINT `fk_image`
    FOREIGN KEY (`fk_image_id`)
    REFERENCES `pascal_handbook`.`image` (`image_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_author`
    FOREIGN KEY (`fk_author_id`)
    REFERENCES `pascal_handbook`.`author` (`author_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
