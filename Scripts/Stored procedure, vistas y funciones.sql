-- Stored procedures, vistas, funciones

-- Stored procedured

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
	where sd.idDestino = id2 and sd.ordenDestinos > temp.ordenDestinos;
    
END$$

DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDestinosByMesAno`(IN mes INT, IN ano INT)
BEGIN
    select localidad, count(destino) totalPasajes
	from PersonaServicioMicro ps
	inner join Destino d on ps.destino = d.idDestino
    inner join Servicio ser on ps.idServicio = ser.idServicio
    where month(ser.fechaServicio) = mes and year(ser.fechaServicio) = ano
	group by ps.destino 
	order by totalPasajes desc;
    
END$$
DELIMITER ;


USE `terminalTPJava`;
DROP procedure IF EXISTS `getRecaudacionPorMes`;

DELIMITER $$
USE `terminalTPJava`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRecaudacionPorMes`()
BEGIN
	SELECT  month(s.fechaServicio) as Mes,
	sum(ps.precio) 'ingresos'
	FROM PersonaServicioMicro ps
	inner join Servicio s on s.idServicio = ps.idServicio
	where (year(s.fechaServicio) = 2019 and month(s.fechaServicio) < 7) 
    or (year(s.fechaServicio) = 2018 and month(s.fechaServicio) = 12)
	group by month(s.fechaServicio);
END$$

DELIMITER ;



-- Vista


CREATE VIEW `terminalTPJava`.`getDetallesServicios` AS 
select `s`.`idServicio`,`s`.`fechaServicio` 
,`s`.`horaServicio` ,group_concat(distinct `m`.`patente` separator ',') AS `Patente`
,group_concat(distinct `m`.`marca` separator ',') AS `Marca`
,group_concat(distinct `d`.`localidad` separator ',') AS `Recorrido`
,group_concat(distinct concat(`p`.`nombre`,`p`.`apellido`) separator ',') AS `Nombre/s y apellido/s` 
from ((((((`terminalTPJava`.`Servicio` `s` 
join `terminalTPJava`.`ServicioMicro` `sm` on((`s`.`idServicio` = `sm`.`idServicio`))) 
join `terminalTPJava`.`Micro` `m` on((`sm`.`patente` = `m`.`patente`))) 
join `terminalTPJava`.`ServicioDestino` `sd` on((`sd`.`idServicio` = `s`.`idServicio`))) 
join `terminalTPJava`.`Destino` `d` on((`d`.`idDestino` = `sd`.`idDestino`))) 
join `terminalTPJava`.`MicroConductor` `mc` on((`mc`.`idServicio` = `sm`.`idServicio`))) 
join `terminalTPJava`.`Persona` `p` on((`p`.`dni` = `mc`.`dniConductor`))) 
group by `s`.`idServicio`;

-- Ejecutar la vista

-- select idServicio, fechaServicio, horaServicio, Recorrido from getDetallesServicios;


-- Funcion

USE `terminalTPJava`;
DROP function IF EXISTS `getTieneRefuerzo`;

DELIMITER $$
USE `terminalTPJava`$$
CREATE FUNCTION `getTieneRefuerzo` (idSer INT)
RETURNS BOOL
BEGIN
	select (not count(sm.idServicio) = 1) INTO @rta
	from ServicioMicro sm
	where sm.idServicio = idSer;
RETURN @rta;
END$$

DELIMITER ;


-- Triggers
USE `terminalTPJava`;

DELIMITER $$

DROP TRIGGER IF EXISTS terminalTPJava.Persona_BEFORE_DELETE$$
USE `terminalTPJava`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `terminalTPJava`.`Persona_BEFORE_DELETE` BEFORE DELETE ON `Persona` FOR EACH ROW
BEGIN
delete from PersonaServicioMicro where PersonaServicioMicro.dniPersona=old.dni;
END$$
DELIMITER ;


USE `terminalTPJava`;

DELIMITER $$

DROP TRIGGER IF EXISTS terminalTPJava.Micro_BEFORE_DELETE$$
USE `terminalTPJava`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `terminalTPJava`.`Micro_BEFORE_DELETE` BEFORE DELETE ON `Micro` FOR EACH ROW
BEGIN
	delete from ServicioMicro where ServicioMicro.patente= old.Patente;
	delete from Butaca where Butaca.patenteMicro=old.patente;
	delete from PersonaServicioMicro where PersonaServicioMicro.patenteMicro=old.patente;
    delete from MicroConductor where MicroConductor.patente=old.Patente;


END$$
DELIMITER ;


USE `terminalTPJava`;

DELIMITER $$

DROP TRIGGER IF EXISTS terminalTPJava.Butaca_BEFORE_DELETE$$
USE `terminalTPJava`$$
CREATE DEFINER = CURRENT_USER TRIGGER `terminalTPJava`.`Butaca_BEFORE_DELETE` BEFORE DELETE ON `Butaca` FOR EACH ROW
BEGIN
	delete from PersonaServicioMicro where PersonaServicioMicro.numButaca=old.numButaca;

END$$
DELIMITER ;

USE `terminalTPJava`;

DELIMITER $$

DROP TRIGGER IF EXISTS terminalTPJava.Destino_BEFORE_DELETE$$
USE `terminalTPJava`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `terminalTPJava`.`Destino_BEFORE_DELETE` BEFORE DELETE ON `Destino` FOR EACH ROW
BEGIN
	delete from ServicioDestino where ServicioDestino.idDestino=old.idDestino;
END$$
DELIMITER ;


USE `terminalTPJava`;

DELIMITER $$

DROP TRIGGER IF EXISTS terminalTPJava.Servicio_BEFORE_DELETE$$
USE `terminalTPJava`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `terminalTPJava`.`Servicio_BEFORE_DELETE` BEFORE DELETE ON `Servicio` FOR EACH ROW
BEGIN
	delete from ServicioDestino where ServicioDestino.idServicio=old.idServicio;
    delete from ServicioMicro where ServicioMicro.idServicio=old.idServicio;
	delete from PersonaServicioMicro where PersonaServicioMicro.idServicio=old.idServicio;
	delete from MicroConductor where MicroConductor.idServicio=old.idServicio;
END$$
DELIMITER ;
