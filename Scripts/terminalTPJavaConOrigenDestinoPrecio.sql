-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


--
-- Usuario con permisos completos
--

DROP USER IF EXISTS 'usertpjava'@'localhost';
CREATE USER 'usertpjava'@'localhost' IDENTIFIED BY 'usertpjava';
GRANT ALL PRIVILEGES ON * . * TO 'usertpjava'@'localhost';
FLUSH PRIVILEGES;



-- -----------------------------------------------------
-- Schema terminalTPJava
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `terminalTPJava` ;

-- -----------------------------------------------------
-- Schema terminalTPJava
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `terminalTPJava` DEFAULT CHARACTER SET utf8 ;
USE `terminalTPJava` ;

-- -----------------------------------------------------
-- Table `terminalTPJava`.`Servicio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `terminalTPJava`.`Servicio` ;

CREATE TABLE IF NOT EXISTS `terminalTPJava`.`Servicio` (
  `idServicio` INT NOT NULL,
  `fechaServicio` DATE NULL,
  `horaServicio` VARCHAR(45) NULL,
  PRIMARY KEY (`idServicio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terminalTPJava`.`Destino`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `terminalTPJava`.`Destino` ;

CREATE TABLE IF NOT EXISTS `terminalTPJava`.`Destino` (
  `idDestino` INT NOT NULL,
  `localidad` VARCHAR(45) NULL,
  `porcentajeAumento` DOUBLE NULL,
  PRIMARY KEY (`idDestino`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terminalTPJava`.`ServicioDestino`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `terminalTPJava`.`ServicioDestino` ;

CREATE TABLE IF NOT EXISTS `terminalTPJava`.`ServicioDestino` (
  `idServicio` INT NOT NULL,
  `idDestino` INT NOT NULL,
  `precio` DOUBLE NULL,
  `ordenDestinos` INT NULL,
  PRIMARY KEY (`idServicio`, `idDestino`),
  CONSTRAINT `fk1_ServicioDestinoToServicio`
    FOREIGN KEY (`idServicio`)
    REFERENCES `terminalTPJava`.`Servicio` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ServicioDestinoToDestino`
    FOREIGN KEY (`idDestino`)
    REFERENCES `terminalTPJava`.`Destino` (`idDestino`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terminalTPJava`.`Persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `terminalTPJava`.`Persona` ;

CREATE TABLE IF NOT EXISTS `terminalTPJava`.`Persona` (
  `dni` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `tipoDni` VARCHAR(5) NULL,
  `fechaNac` DATE NULL,
  `fechaInicio` DATE NULL,
  `contacto` VARCHAR(45) NULL,
  `nombreUsuario` VARCHAR(45) NULL,
  `contrasena` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `esAdmin` TINYINT(1) NOT NULL,
  `fotoPerfil` MEDIUMBLOB NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terminalTPJava`.`Micro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `terminalTPJava`.`Micro` ;

CREATE TABLE IF NOT EXISTS `terminalTPJava`.`Micro` (
  `patente` VARCHAR(45) NOT NULL,
  `porcentajeAumento` DOUBLE NULL,
  `marca` VARCHAR(45) NULL,
  `fechaUltimoControl` DATE NULL,
  PRIMARY KEY (`patente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terminalTPJava`.`Butaca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `terminalTPJava`.`Butaca` ;

CREATE TABLE IF NOT EXISTS `terminalTPJava`.`Butaca` (
  `numButaca` INT NOT NULL,
  `patenteMicro` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`numButaca`, `patenteMicro`),
  CONSTRAINT `fk2_ButacaToMicro`
    FOREIGN KEY (`patenteMicro`)
    REFERENCES `terminalTPJava`.`Micro` (`patente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terminalTPJava`.`MicroConductor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `terminalTPJava`.`MicroConductor` ;

CREATE TABLE IF NOT EXISTS `terminalTPJava`.`MicroConductor` (
  `patente` VARCHAR(45) NULL,
  `dniConductor` VARCHAR(45) NOT NULL,
  `idServicio` INT NOT NULL,
  PRIMARY KEY (`dniConductor`, `idServicio`),
  CONSTRAINT `fk1_MicroConductorToConductor`
    FOREIGN KEY (`dniConductor`)
    REFERENCES `terminalTPJava`.`Persona` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk2_MicroConductorToMicro`
    FOREIGN KEY (`patente`)
    REFERENCES `terminalTPJava`.`Micro` (`patente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk3_MicroConductorToServicio`
    FOREIGN KEY (`idServicio`)
    REFERENCES `terminalTPJava`.`Servicio` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terminalTPJava`.`ServicioMicro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `terminalTPJava`.`ServicioMicro` ;

CREATE TABLE IF NOT EXISTS `terminalTPJava`.`ServicioMicro` (
  `patente` VARCHAR(45) NOT NULL,
  `idServicio` INT NOT NULL,
  PRIMARY KEY (`patente`, `idServicio`),
  CONSTRAINT `fk1_MicroServicioToMicro`
    FOREIGN KEY (`patente`)
    REFERENCES `terminalTPJava`.`Micro` (`patente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk2_MicroServicioToServicio`
    FOREIGN KEY (`idServicio`)
    REFERENCES `terminalTPJava`.`Servicio` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `terminalTPJava`.`PersonaServicioMicro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `terminalTPJava`.`PersonaServicioMicro` ;

CREATE TABLE IF NOT EXISTS `terminalTPJava`.`PersonaServicioMicro` (
  `dniPersona` VARCHAR(45) NOT NULL,
  `idServicio` INT NOT NULL,
  `patenteMicro` VARCHAR(45) NULL,
  `numButaca` INT NULL,
  `origen` INT NOT NULL,
  `destino` INT NOT NULL,
  `precio` DOUBLE NULL,
  PRIMARY KEY (`dniPersona`, `idServicio`),
  CONSTRAINT `fk1_PersonaServicioToPersona`
    FOREIGN KEY (`dniPersona`)
    REFERENCES `terminalTPJava`.`Persona` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk2_PersonaServicioToServicio`
    FOREIGN KEY (`idServicio`)
    REFERENCES `terminalTPJava`.`Servicio` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk3_PersonaServicioToMicro`
    FOREIGN KEY (`patenteMicro`)
    REFERENCES `terminalTPJava`.`Micro` (`patente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
