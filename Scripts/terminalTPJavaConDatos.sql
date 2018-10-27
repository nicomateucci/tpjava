-- Datos terminal tp java

-- Datos tabla Destino

INSERT INTO `terminalTPJava`.`Destino` (`idDestino`, `localidad`) VALUES ('1', 'Cordoba');
INSERT INTO `terminalTPJava`.`Destino` (`idDestino`, `localidad`) VALUES ('2', 'Rosario');
INSERT INTO `terminalTPJava`.`Destino` (`idDestino`, `localidad`) VALUES ('3', 'Santa Fe');
INSERT INTO `terminalTPJava`.`Destino` (`idDestino`, `localidad`) VALUES ('4', 'Buenos Aires');
INSERT INTO `terminalTPJava`.`Destino` (`idDestino`, `localidad`) VALUES ('5', 'Mendoza');
INSERT INTO `terminalTPJava`.`Destino` (`idDestino`, `localidad`, `porcentajeAumento`) VALUES ('6', 'Cordoba', '1.15');
INSERT INTO `terminalTPJava`.`Destino` (`idDestino`, `localidad`, `porcentajeAumento`) VALUES ('7', 'Buenos Aires', '1.20');

-- Datos tabla Persona

INSERT INTO `terminalTPJava`.`Persona` (`dni`, `nombre`, `apellido`, `tipoDni`, `fechaNac`, `fechaInicio`, `contacto`, `nombreUsuario`, `contraseña`, `email`, `esAdmin`) VALUES ('11111111', 'Matias', 'Lamens', 'DNI', '1980-01-02', NULL, NULL, 'mlamens', 'mlamens', 'm@gmail.com', '1');
INSERT INTO `terminalTPJava`.`Persona` (`dni`, `nombre`, `apellido`, `tipoDni`, `fechaNac`, `fechaInicio`, `contacto`, `nombreUsuario`, `contraseña`, `email`, `esAdmin`) VALUES ('22222222', 'Agsutin', 'Lloy', 'DNI', '1971-05-15', '1999-01-03', '341000000', NULL, NULL, 'NULL', '0');
INSERT INTO `terminalTPJava`.`Persona` (`dni`, `nombre`, `apellido`, `tipoDni`, `fechaNac`, `fechaInicio`, `contacto`, `nombreUsuario`, `contraseña`, `email`, `esAdmin`) VALUES ('33333333', 'Sara', 'Laius', 'DNI', '1993-10-11', NULL, NULL, 'slaius', 'slaius', 's@gmail.com', '0');

-- Datos tabla Servicio

INSERT INTO `terminalTPJava`.`Servicio` (`idServicio`, `fechaServicio`, `horaServicio`) VALUES ('1', '2018-12-30', '16:00');
INSERT INTO `terminalTPJava`.`Servicio` (`idServicio`, `fechaServicio`, `horaServicio`) VALUES ('2', '2018-12-15', '10:00');
INSERT INTO `terminalTPJava`.`Servicio` (`idServicio`, `fechaServicio`, `horaServicio`) VALUES ('3', '2018-12-27', '13:00');
INSERT INTO `terminalTPJava`.`Servicio` (`idServicio`, `fechaServicio`, `horaServicio`) VALUES ('4', '2019-01-10', '19:00');

-- Datos tabla ServicioDestino

INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('1', '2', '0');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('1', '7', '600');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('2', '4', '0');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('2', '2', '400');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('2', '3', '600');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('2', '6', '900');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('3', '3', '0');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('3', '2', '250');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('3', '4', '700');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('4', '5', '0');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('4', '2', '650');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`) VALUES ('4', '4', '1030');

-- Stored procedures

USE `terminalTPJava`;
DROP procedure IF EXISTS `getServiciosByDestinos`;

DELIMITER $$
USE `terminalTPJava`$$
CREATE PROCEDURE `getServiciosByDestinos`(IN id INT, IN id2 INT)
BEGIN

	drop temporary table if exists temp;
	create temporary table temp select * from ServicioDestino where idDestino=id;
	select s.idServicio, s.fechaServicio, s.horaServicio, sd.precio from temp 
	inner join ServicioDestino sd on temp.idServicio = sd.idServicio
	inner join Servicio s on s.idServicio = sd.idServicio
	where sd.idDestino = id2 and sd.idTabla > temp.idTabla;
    
END$$

DELIMITER ;





