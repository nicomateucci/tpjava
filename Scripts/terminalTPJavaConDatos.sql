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

INSERT INTO `Persona` (`dni`,`nombre`,`apellido`,`tipoDni`,`fechaNac`,`fechaInicio`,`contacto`,`nombreUsuario`,`contraseña`,`email`,`esAdmin`) VALUES ('11111111','Matias','Lamens','DNI','1980-01-02',NULL,NULL,'mlamens','mlamens','m@gmail.com',1);
INSERT INTO `Persona` (`dni`,`nombre`,`apellido`,`tipoDni`,`fechaNac`,`fechaInicio`,`contacto`,`nombreUsuario`,`contraseña`,`email`,`esAdmin`) VALUES ('22222222','Agsutin','Lloy','DNI','1971-05-15','1999-01-03','341000000',NULL,NULL,'NULL',0);
INSERT INTO `Persona` (`dni`,`nombre`,`apellido`,`tipoDni`,`fechaNac`,`fechaInicio`,`contacto`,`nombreUsuario`,`contraseña`,`email`,`esAdmin`) VALUES ('33333333','Sara','Laius','DNI','1993-10-11',NULL,NULL,'slaius','slaius','s@gmail.com',0);
INSERT INTO `Persona` (`dni`,`nombre`,`apellido`,`tipoDni`,`fechaNac`,`fechaInicio`,`contacto`,`nombreUsuario`,`contraseña`,`email`,`esAdmin`) VALUES ('44444444','Azucar','Ledesma','DNI','1953-10-26',NULL,NULL,'aledesma','aledesma','aledesma@gmail.com',0);
INSERT INTO `Persona` (`dni`,`nombre`,`apellido`,`tipoDni`,`fechaNac`,`fechaInicio`,`contacto`,`nombreUsuario`,`contraseña`,`email`,`esAdmin`) VALUES ('55555555','Matias','Choy','DNI','1993-11-24',NULL,NULL,'mchoy','mchoy','mchoy@gmail.com',0);
INSERT INTO `Persona` (`dni`,`nombre`,`apellido`,`tipoDni`,`fechaNac`,`fechaInicio`,`contacto`,`nombreUsuario`,`contraseña`,`email`,`esAdmin`) VALUES ('66666666','Cacho','Canale','DNI','1953-01-19','2003-11-15','2364469820',NULL,NULL,NULL,0);
INSERT INTO `Persona` (`dni`,`nombre`,`apellido`,`tipoDni`,`fechaNac`,`fechaInicio`,`contacto`,`nombreUsuario`,`contraseña`,`email`,`esAdmin`) VALUES ('77777777','German','Graciano','DNI','1963-01-01','2006-11-29','3382481233',NULL,NULL,NULL,0);

-- Datos tabla Servicio

INSERT INTO `terminalTPJava`.`Servicio` (`idServicio`, `fechaServicio`, `horaServicio`) VALUES ('1', '2018-12-30', '16:00');
INSERT INTO `terminalTPJava`.`Servicio` (`idServicio`, `fechaServicio`, `horaServicio`) VALUES ('2', '2018-12-15', '10:00');
INSERT INTO `terminalTPJava`.`Servicio` (`idServicio`, `fechaServicio`, `horaServicio`) VALUES ('3', '2018-12-27', '13:00');
INSERT INTO `terminalTPJava`.`Servicio` (`idServicio`, `fechaServicio`, `horaServicio`) VALUES ('4', '2019-01-10', '19:00');

-- Datos tabla ServicioDestino

INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('1', '2', '0','1');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('1', '7', '600','2');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('2', '4', '0','1');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('2', '2', '400','2');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('2', '3', '600','3');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('2', '6', '900','4');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('3', '3', '0','1');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('3', '2', '250','2');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('3', '4', '700','3');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('4', '5', '0','1');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('4', '2', '650','2');
INSERT INTO `terminalTPJava`.`ServicioDestino` (`idServicio`, `idDestino`, `precio`, `ordenDestinos`) VALUES ('4', '4', '1030','3');

-- Datos tabla Micro

INSERT INTO `terminalTPJava`.`Micro` (`patente`, `porcentajeAumento`, `marca`, `fechaUltimoControl`) VALUES ('123ABC', NULL, 'Fiat', '2017-01-01');
INSERT INTO `terminalTPJava`.`Micro` (`patente`, `porcentajeAumento`, `marca`, `fechaUltimoControl`) VALUES ('478DEF', '1.15', 'Fiat', '2017-05-06');
INSERT INTO `terminalTPJava`.`Micro` (`patente`, `porcentajeAumento`, `marca`, `fechaUltimoControl`) VALUES ('89ABC00', '1.10', 'Ford', '2017-09-26');
INSERT INTO `terminalTPJava`.`Micro` (`patente`, `marca`, `fechaUltimoControl`) VALUES ('SSNNN11', 'Ford', '2016-04-05');
INSERT INTO `terminalTPJava`.`Micro` (`patente`, `porcentajeAumento`, `marca`, `fechaUltimoControl`) VALUES ('00AAA00', '1.20', 'Ford', '2017-8-6');

-- Datos tabla ServicioMicro

INSERT INTO `terminalTPJava`.`ServicioMicro` (`patente`, `idServicio`) VALUES ('00AAA00', '1');
INSERT INTO `terminalTPJava`.`ServicioMicro` (`patente`, `idServicio`) VALUES ('123ABC', '1');
INSERT INTO `terminalTPJava`.`ServicioMicro` (`patente`, `idServicio`) VALUES ('478DEF', '2');
INSERT INTO `terminalTPJava`.`ServicioMicro` (`patente`, `idServicio`) VALUES ('89ABC00', '3');
INSERT INTO `terminalTPJava`.`ServicioMicro` (`patente`, `idServicio`) VALUES ('SSNNN11', '4');
INSERT INTO `terminalTPJava`.`ServicioMicro` (`patente`, `idServicio`) VALUES ('89ABC00', '4');
INSERT INTO `terminalTPJava`.`ServicioMicro` (`patente`, `idServicio`) VALUES ('123ABC', '4');

-- Datos tabla MicroConductor

INSERT INTO `terminalTPJava`.`MicroConductor` (`patente`, `dniConductor`, `idServicio`) VALUES ('00AAA00', '22222222', '1');
INSERT INTO `terminalTPJava`.`MicroConductor` (`patente`, `dniConductor`, `idServicio`) VALUES ('ABC123', '66666666', '1');
INSERT INTO `terminalTPJava`.`MicroConductor` (`patente`, `dniConductor`, `idServicio`) VALUES ('478DEF', '66666666', '2');
INSERT INTO `terminalTPJava`.`MicroConductor` (`patente`, `dniConductor`, `idServicio`) VALUES ('478DEF', '22222222', '2');
INSERT INTO `terminalTPJava`.`MicroConductor` (`patente`, `dniConductor`, `idServicio`) VALUES ('89ABC00', '22222222', '3');
INSERT INTO `terminalTPJava`.`MicroConductor` (`patente`, `dniConductor`, `idServicio`) VALUES ('SSNNN11', '66666666', '4');

-- Datos tabla butaca

INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('1', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('2', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('3', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('4', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('5', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('6', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('7', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('8', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('9', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('10', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('11', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('12', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('13', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('14', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('15', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('16', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('17', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('18', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('19', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('20', '123ABC');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('1', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('2', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('3', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('4', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('5', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('6', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('7', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('8', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('9', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('10', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('11', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('12', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('13', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('14', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('15', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('16', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('17', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('18', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('19', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('20', '478DEF');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('1', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('2', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('3', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('4', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('5', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('6', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('7', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('8', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('9', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('10', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('11', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('12', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('13', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('14', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('15', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('16', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('17', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('18', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('19', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('20', '89ABC00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('1', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('2', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('3', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('4', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('5', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('6', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('7', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('8', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('9', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('10', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('11', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('12', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('13', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('14', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('15', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('16', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('17', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('18', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('19', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('20', 'SSNNN11');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('1', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('2', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('3', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('4', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('5', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('6', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('7', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('8', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('9', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('10', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('11', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('12', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('13', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('14', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('15', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('16', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('17', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('18', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('19', '00AAA00');
INSERT INTO `terminalTPJava`.`Butaca` (`numButaca`, `patenteMicro`) VALUES ('20', '00AAA00');

-- Datos tabla PersonaMicroSerivico

INSERT INTO `terminalTPJava`.`PersonaServicioMicro` (`dniPersona`, `idServicio`, `patenteMicro`, `numButaca`) VALUES ('33333333', '1', '00AAA00', '8');
INSERT INTO `terminalTPJava`.`PersonaServicioMicro` (`dniPersona`, `idServicio`, `patenteMicro`, `numButaca`) VALUES ('44444444', '1', '123ABC', '19');
INSERT INTO `terminalTPJava`.`PersonaServicioMicro` (`dniPersona`, `idServicio`, `patenteMicro`, `numButaca`) VALUES ('55555555', '2', '478DEF', '13');
INSERT INTO `terminalTPJava`.`PersonaServicioMicro` (`dniPersona`, `idServicio`, `patenteMicro`, `numButaca`) VALUES ('33333333', '2', '478DEF', '19');
INSERT INTO `terminalTPJava`.`PersonaServicioMicro` (`dniPersona`, `idServicio`, `patenteMicro`, `numButaca`) VALUES ('44444444', '3', '89ABC00', '20');





