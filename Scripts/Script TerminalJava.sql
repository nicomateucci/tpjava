-- MySQL Script generated by MySQL Workbench
-- mar 25 sep 2018 11:39:01 -03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema TerminalJava
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TerminalJava
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TerminalJava` DEFAULT CHARACTER SET utf8 ;
USE `TerminalJava` ;

-- -----------------------------------------------------
-- Table `TerminalJava`.`Micros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TerminalJava`.`Micros` (
  `idMicros` INT NOT NULL,
  `patente` VARCHAR(45) NULL,
  PRIMARY KEY (`idMicros`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TerminalJava`.`saddasd`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TerminalJava`.`saddasd` (
  `idsaddasd` INT NOT NULL,
  `saddasdcol` VARCHAR(45) NULL,
  `Micros_idMicros` INT NOT NULL,
  PRIMARY KEY (`idsaddasd`),
  INDEX `fk_saddasd_Micros_idx` (`Micros_idMicros` ASC),
  CONSTRAINT `fk_saddasd_Micros`
    FOREIGN KEY (`Micros_idMicros`)
    REFERENCES `TerminalJava`.`Micros` (`idMicros`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `TerminalJava` ;

-- -----------------------------------------------------
-- Placeholder table for view `TerminalJava`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TerminalJava`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `TerminalJava`.`view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TerminalJava`.`view1`;
USE `TerminalJava`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

CREATE USER 'usertpjava' IDENTIFIED BY 'usertpjava';
GRANT ALL PRIVILEGES ON * . * TO 'usertpjava'@'%';
