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
	where sd.idDestino = id2 and sd.idTabla > temp.idTabla;
    
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

