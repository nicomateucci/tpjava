<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Micro"%>
<%@page import="entities.Servicio"%>
<%@page import="entities.Usuario"%>
<%@page import="entities.Butaca"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Terminal</title>

<!-- Bootstrap core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="../css/agency.min.css" rel="stylesheet">
<link href="../css/agency.css" rel="stylesheet">
<link href="../css/mystyle.css" rel="stylesheet">



</head>

<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Pasajero23</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#contact">Contacto</a></li>
					<li><a class="fa fa-user nav-link js-scroll-trigger user"
						href="./pages/LoginUsuario.html"></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!--Tengo que mostrar dos distintis con un if: seleccion de micro y seleccion de butaca-->
	<%
		if (request.getSession().getAttribute("estadoventa").equals("SELECCIONARMICRO")) {
	%>
	<section id="form">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Lista de micros asignados al servicio elegido:</h2>
					<table class="table table-striped table-bordered">
						<tr>
							<th>Patente</th>
							<th>Marca</th>
							<th>Fecha Ultimo Control</th>
							<th>Porcentaje aumento</th>
							<th>Tipo</th>
						</tr>
						<%
							Servicio ser = (Servicio) request.getSession().getAttribute("servicio");
								for (Micro m : ser.getMicros()) {
						%>
						<tr>
							<td><%=m.getPatente()%></td>
							<td><%=m.getMarca()%></td>
							<td><%=m.getFechaUltimoCtrl()%></td>
							<td><%=m.getAumento()%></td>
							<td><%=m.getClass().toString().substring(15)%></td>

						</tr>
						<%
							}
						%>
					</table>
					<form method=post action="../ServletVentaPasaje">
						<br>
						<h2>Ingrese la patente del micro:</h2>

						<div class="form-group col-lg-9">
							<label for="patente">Patente: </label> <input type="text"
								name="patente" placeholder="Ej: AA123BB o 961ASD"
								class="form-control" />
						</div>
						<div class="form-group col-lg-9">
							<button type="submit" value="Ingresar" class="btn btn-primary">Continuar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<%
		}
		if (request.getSession().getAttribute("estadoventa").equals("SELECCIONARBUTACA")) {
			request.getSession().setAttribute("estadoventa","IMPRIMIRBOLETO");
	%>
	<section id="form">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Butacas libres:</h2>
					<table class="table table-striped table-bordered">
						<tr>
							<th>Numero</th>
							<th>Pasajero</th>
						</tr>
						<%
							Butaca[] pasajeros = (Butaca[]) request.getSession().getAttribute("pasajeros");
								/*for (int i = 0; i < Math.ceil(pasajeros.length / 10); i++) {
									for (int j = 0; j < 10; j++) {*/
								for (int j = 0; j < pasajeros.length; j++){
						%>
						<tr>
							<td><%=pasajeros[j].getNumero()%></td>
							<%
								if (pasajeros[j].getPasajero() instanceof Usuario) {
							%>
							<td><%=pasajeros[j].getPasajero().getDni()%></td>
							<%
								} else {
							%>
							<td>vacío</td>
						</tr>
						<%
							}
								}
						%>
					</table>
					<form method=post action="../ServletVentaPasaje">
						<br>
						<h2>Ingrese el numero de butaca en la que desea viajar:</h2>

						<div class="form-group col-lg-9">
							<label for="numButaca">Butaca n°: </label> <input type="number"
								name="numButaca" placeholder="Ej: 1, 5, 12."
								class="form-control" />
						</div>
						<div class="form-group col-lg-9">
							<button type="submit" value="Ingresar" class="btn btn-primary">Continuar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>



	<%
		}
	%>
	<!-- Contact -->
	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Contactanos</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">


					<form id="formContacto" name="enviarMensaje"
						novalidate="novalidate" method="get" action="/ServletEmail">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<input class="form-control" name="nombre" type="text"
										placeholder="Tu Nombre *" required="required"
										data-validation-required-message="Please enter your name.">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<input class="form-control" name="email" type="email"
										placeholder="Tu Email *" required="required"
										data-validation-required-message="Please enter your email address.">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<input class="form-control" name="telefono" type="tel"
										placeholder="Tu TelÃ©fono *" required="required"
										data-validation-required-message="Please enter your phone number.">
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<textarea class="form-control" name="mensaje"
										placeholder="Tu comentario *" required="required"
										data-validation-required-message="Please enter a message."></textarea>
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="col-lg-12 text-center">
								<div id="success"></div>
								<button name="btnEnviarMensaje"
									class="btn btn-primary btn-xl text-uppercase" type="submit">Enviar</button>
							</div>
						</div>
					</form>


				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<span class="copyright">Copyright &copy; Your Website 2018</span>
				</div>
				<div class="col-md-4">
					<ul class="list-inline social-buttons">
						<li class="list-inline-item"><a href="#"> <i
								class="fa fa-twitter"></i>
						</a></li>
						<li class="list-inline-item"><a href="#"> <i
								class="fa fa-facebook"></i>
						</a></li>
						<li class="list-inline-item"><a href="#"> <i
								class="fa fa-linkedin"></i>
						</a></li>
					</ul>
				</div>
				<div class="col-md-4">
					<ul class="list-inline quicklinks">
						<li class="list-inline-item"><a href="#">Privacy Policy</a></li>
						<li class="list-inline-item"><a href="#">Terms of Use</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>



	<!-- Bootstrap core JavaScript -->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Contact form JavaScript -->
	<script src="../js/jqBootstrapValidation.js"></script>
	<script src="../js/contact_me.js"></script>

	<!-- Custom scripts for this template -->
	<script src="../js/agency.min.js"></script>

</body>

</html>
