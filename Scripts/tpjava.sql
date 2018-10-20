-- MySQL dump 10.13  Distrib 8.0.12, for Linux (x86_64)
--
-- Host: localhost    Database: terminalTPJava
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Estructura de base de datos y permisos de usuario
--

DROP USER IF EXISTS 'usertpjava'@'localhost';
CREATE USER 'usertpjava'@'localhost' IDENTIFIED BY 'usertpjava';
GRANT ALL PRIVILEGES ON * . * TO 'usertpjava'@'localhost';
FLUSH PRIVILEGES;
DROP SCHEMA IF EXISTS terminalTPJava;
CREATE SCHEMA terminalTPJava;
USE terminalTPJava; 


--
-- Table structure for table `Persona`
--

DROP TABLE IF EXISTS `Persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Persona` (
  `dni` varchar(45) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `tipoDni` varchar(5) DEFAULT NULL,
  `fechaNac` date DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `contacto` varchar(45) DEFAULT NULL,
  `nombreUsuario` varchar(45) DEFAULT NULL,
  `contraseña` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `Persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Servicio`
--

DROP TABLE IF EXISTS `Servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Servicio` (
  `idServicio` int(11) NOT NULL,
  `fechaHoraServ` datetime DEFAULT NULL,
  PRIMARY KEY (`idServicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Servicio`
--

LOCK TABLES `Servicio` WRITE;
/*!40000 ALTER TABLE `Servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `Servicio` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Table structure for table `Butaca`
--



DROP TABLE IF EXISTS `Butaca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Butaca` (
  `idButaca` int(11) NOT NULL,
  `dniUsuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idButaca`),
  KEY `fk1_ButacaToUsuario_idx` (`dniUsuario`),
  CONSTRAINT `fk1_ButacaToUsuario` FOREIGN KEY (`dniUsuario`) REFERENCES `Persona` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Butaca`
--

LOCK TABLES `Butaca` WRITE;
/*!40000 ALTER TABLE `Butaca` DISABLE KEYS */;
/*!40000 ALTER TABLE `Butaca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Destino`
--

DROP TABLE IF EXISTS `Destino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Destino` (
  `idDestino` int(11) NOT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `porcentajeAumento` double DEFAULT NULL,
  PRIMARY KEY (`idDestino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Destino`
--

LOCK TABLES `Destino` WRITE;
/*!40000 ALTER TABLE `Destino` DISABLE KEYS */;
/*!40000 ALTER TABLE `Destino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Micro`
--

DROP TABLE IF EXISTS `Micro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Micro` (
  `patente` varchar(45) NOT NULL,
  `dniConductor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`patente`),
  KEY `fk1_MicroToConductor_idx` (`dniConductor`),
  CONSTRAINT `fk1_MicroToConductor` FOREIGN KEY (`dniConductor`) REFERENCES `Persona` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Micro`
--

LOCK TABLES `Micro` WRITE;
/*!40000 ALTER TABLE `Micro` DISABLE KEYS */;
/*!40000 ALTER TABLE `Micro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MicroConductor`
--

DROP TABLE IF EXISTS `MicroConductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `MicroConductor` (
  `patente` varchar(45) NOT NULL,
  `dniConductor` varchar(45) NOT NULL,
  `idServicio` int(11) NOT NULL,
  PRIMARY KEY (`patente`,`dniConductor`,`idServicio`),
  KEY `fk1_MicroConductorToConductor_idx` (`dniConductor`),
  KEY `fk3_MicroConductorToServicio_idx` (`idServicio`),
  CONSTRAINT `fk1_MicroConductorToConductor` FOREIGN KEY (`dniConductor`) REFERENCES `Persona` (`dni`),
  CONSTRAINT `fk2_MicroConductorToMicro` FOREIGN KEY (`patente`) REFERENCES `Micro` (`patente`),
  CONSTRAINT `fk3_MicroConductorToServicio` FOREIGN KEY (`idServicio`) REFERENCES `Servicio` (`idservicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MicroConductor`
--

LOCK TABLES `MicroConductor` WRITE;
/*!40000 ALTER TABLE `MicroConductor` DISABLE KEYS */;
/*!40000 ALTER TABLE `MicroConductor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MicroServicio`
--

DROP TABLE IF EXISTS `MicroServicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `MicroServicio` (
  `patente` varchar(45) NOT NULL,
  `idServicio` int(11) NOT NULL,
  `fechaServicio` datetime NOT NULL,
  PRIMARY KEY (`patente`,`idServicio`,`fechaServicio`),
  KEY `fk2_MicroServicioToServicio_idx` (`idServicio`),
  CONSTRAINT `fk1_MicroServicioToMicro` FOREIGN KEY (`patente`) REFERENCES `Micro` (`patente`),
  CONSTRAINT `fk2_MicroServicioToServicio` FOREIGN KEY (`idServicio`) REFERENCES `Servicio` (`idservicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MicroServicio`
--

LOCK TABLES `MicroServicio` WRITE;
/*!40000 ALTER TABLE `MicroServicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `MicroServicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PersonaServicio`
--

DROP TABLE IF EXISTS `PersonaServicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `PersonaServicio` (
  `dniPersona` varchar(45) NOT NULL,
  `idServicio` int(11) NOT NULL,
  PRIMARY KEY (`dniPersona`,`idServicio`),
  KEY `fk2_PersonaServicioToServicio_idx` (`idServicio`),
  CONSTRAINT `fk1_PersonaServicioToPersona` FOREIGN KEY (`dniPersona`) REFERENCES `Persona` (`dni`),
  CONSTRAINT `fk2_PersonaServicioToServicio` FOREIGN KEY (`idServicio`) REFERENCES `Servicio` (`idservicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PersonaServicio`
--

LOCK TABLES `PersonaServicio` WRITE;
/*!40000 ALTER TABLE `PersonaServicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `PersonaServicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ServicioDestino`
--

DROP TABLE IF EXISTS `ServicioDestino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ServicioDestino` (
  `idServicio` int(11) NOT NULL,
  `idDestino` int(11) NOT NULL,
  PRIMARY KEY (`idServicio`,`idDestino`),
  KEY `fk_ServicioDestinoToDestino_idx` (`idDestino`),
  CONSTRAINT `fk1_ServicioDestinoToServicio` FOREIGN KEY (`idServicio`) REFERENCES `Servicio` (`idservicio`),
  CONSTRAINT `fk_ServicioDestinoToDestino` FOREIGN KEY (`idDestino`) REFERENCES `Destino` (`iddestino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ServicioDestino`
--

LOCK TABLES `ServicioDestino` WRITE;
/*!40000 ALTER TABLE `ServicioDestino` DISABLE KEYS */;
/*!40000 ALTER TABLE `ServicioDestino` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-19 18:08:27
