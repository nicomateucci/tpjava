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
<style>
body {
	background: #59ABE3;
	margin: 0
}

.form {
	width: 340px;
	height: 440px;
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
	margin: 10px 0;
	padding-bottom: 10px;
	width: 180px;
	color: #78788c;
	border-bottom: 3px solid #78788c
}

input {
	width: 100%;
	padding: 10px;
	box-sizing: border-box;
	background: none;
	outline: none;
	resize: none;
	border: 0;
	font-family: 'Montserrat', sans-serif;
	transition: all .3s;
	border-bottom: 2px solid #bebed2
}

input:focus {
	border-bottom: 2px solid #78788c
}

p:before {
	content: attr(type);
	display: block;
	margin: 28px 0 0;
	font-size: 14px;
	color: #5a5a5a
}

button {
	float: right;
	padding: 8px 12px;
	margin: 8px 0 0;
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

div {
	content: 'Hi';
	position: absolute;
	bottom: -15px;
	right: -20px;
	background: #50505a;
	color: #fff;
	width: 320px;
	padding: 16px 4px 16px 0;
	border-radius: 6px;
	font-size: 13px;
	box-shadow: 10px 10px 40px -14px #000
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
		<p>Dni pasajero: <%=dni %></p>
		<p>Se anuncia a <%=desOrigenSinPrecio.getLocalidad() %></p>
		<p>Con origen en <%=desLlegadaSinPrecio.getLocalidad() %></p>
		<p></p>
		<p>Fecha y hora de partida: <%=(servicio.getFechaServicio() + " " + servicio.getHoraServicio()) %></p>
		<p>Numero de butaca <%= butaca %></p>
		<p></p>
		<p>Empresa: Chevalier</p>
		<p>Patente del micro: <%mic.getPatente(); %></p>
		<p>Dni del conductor: <%mic.getConductores().get(0).getDni(); %></p>
		<p>Nombre del condcutor: <%mic.getConductores().get(0).getNombre(); %></p>
		<p>Precio: <%= precio %></p>
		<p></p>
		<%if (user == null){ %>
		<i>Ingrese su mail para recibir el boleto:</i>
		<div class="form-group col-lg-9">
			<label for="mail">Mail: </label> <input type="email" name="mail" class="form-control" />
		</div>
		<%}else{ %>
			<p>Recibira este pasaje en el mail <%= user.getEmail() %>
		<%} %>
		<div class="form-group col-lg-9">
			<button type="submit" value="Ingresar" class="btn btn-primary">Ir
				a la pagina principal</button>
		</div>
	</form>
</body>
</html>