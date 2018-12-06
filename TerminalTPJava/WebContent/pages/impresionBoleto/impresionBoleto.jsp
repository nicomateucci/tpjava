<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Micro"%>
<%@page import="entities.Servicio"%>
<%@page import="entities.Usuario"%>
<%@page import="entities.Butaca"%>
<%@page import="entities.Destino"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Boleto de viaje</title>
<link rel="stylesheet" href="bootstrap.css">
<style>
body {
	background: #59ABE3;
	margin: 0
}

.form {
	width: 550px;
	height: 700px;
	background: #e6e6e6;
	border-radius: 8px;
	box-shadow: 0 0 40px -10px #000;
	margin: calc(50vh - 220px) auto;
	padding: 20px 30px;
	max-width: calc(100vw - 
	 40px);
	box-sizing: border-box;
	font-family: 'Montserrat', sans-serif;
	position: relative
}

h2 {
	text-align: center;
	margin: 10px 0;
	padding-bottom: 10px;
	width: 500px;
	color: #78788c;
	border-bottom: 3px solid #78788c
}

input:focus {
	border-bottom: 2px solid #78788c
}

p:before {
	content: attr(type);
	display: block;
	margin: 18px 0 0;
	font-size: 12px;
	color: #5a5a5a
}

button {
	float: center;
	font-family: 'Montserrat', sans-serif;
	border: 2px solid #78788c;
	background: 0;
	color: #5a5a6e;
	cursor: pointer;
	transition: all .3s
}

button:hover {
	background: #78788c;
	color: #fff
}

span {
	margin: 0 5px 0 15px
}
</style>
</head>
<body>
	<%
		//Mostrar: destinoOrigen, destinoLegada, dniPasajero, numero de butaca.
		//			Solicitar o mostrar mail para enviar los boletos por pdf
		//			Precio, patente del micro, nombre y apellido de conductor
		//			Fecha y hora de partida del servicio.
		Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogeado");
		Micro mic = (Micro) request.getSession().getAttribute("micro");
		Servicio servicio = (Servicio) request.getSession().getAttribute("servicio");
		Destino desOrigenSinPrecio = (Destino) request.getSession().getAttribute("desOrigen");
		Destino desLlegadaSinPrecio = (Destino) request.getSession().getAttribute("desLlegada");
		int butaca = (int) request.getSession().getAttribute("numButaca");
		String dni = (String) request.getSession().getAttribute("dni");
		Double precio = (Double) request.getSession().getAttribute("precio");
	%>
	<form class="form" method=post action="../../ServletVentaPasaje">
		<h2>Boleto de viaje</h2>
		<p>Boleto numero: 156151</p>
		<p>
			Dni pasajero:
			<%=dni%></p>
		<p>
			Se anuncia a
			<%=desOrigenSinPrecio.getLocalidad()%> - Con origen en
			<%=desLlegadaSinPrecio.getLocalidad()%></p>
		<p>
			Fecha de partida:
			<%=(servicio.getFechaServicio() + " - Hora: " + servicio.getHoraServicio())%></p>
		<p>
			Numero de butaca
			<%=butaca%></p><br>
		<p>Empresa: Chevalier - 
			Patente del micro:
			<%
			mic.getPatente();
		%>
		</p>
		<p>
			Dni del conductor:
			<%
			mic.getConductores().get(0).getDni();%> - Nombre del condcutor:
				<%
				mic.getConductores().get(0).getNombre();
			%>
		</p><br>
		<p>
			Precio:
			<%=precio%></p><br>
		<%
			if (user == null) {
		%>
		<i>Ingrese su mail para recibir el boleto:</i>
		<div class="form-group col-lg-4">
			<label for="mail"></label> <input type="email" name="mail"
				class="form-control" />
		</div>
		<%
			} else {
		%>
		<p>
			Recibira este pasaje en el mail
			<%=user.getEmail()%>.
		</p>
		<%
			}
		%>
		<div class="form-group col-lg-9">
			<button type="submit" value="" class="btn btn-primary">Ir a la pagina principal</button>
		</div>
	</form>
</body>
</html>