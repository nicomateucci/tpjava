<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ingreso al sistema</title>
</head>
<body>
<f:view>
		<form>
			<label>Inicar sesion en Plataforma 23!</label><br><br>
			<label>Seleccione su Tipo de DNI:</label><br>
			<input type="radio" name="1">DNI<br>
			<input type="radio" name="1">LC<br>
			<input type="radio" name="1">MI<br>
			<textarea rows="8" cols="30">Ingrese una frase de una cancion.</textarea><br>
			<input type="submit" value="Ingresar">
		</form>
	</f:view>
</body>
</html>