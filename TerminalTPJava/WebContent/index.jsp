<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Destino"%>
<%@page import="entities.DestinoDirecto"%>

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
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
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
<link href="css/agency.min.css" rel="stylesheet">
<link href="css/agency.css" rel="stylesheet">
<link href="css/mystyle.css" rel="stylesheet">



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
						href="#services">Servicios</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#contact">Contacto</a></li>
					<li><a class="fa fa-user nav-link js-scroll-trigger user"
						href="./pages/loginUsuario.jsp"></a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Header -->
	<header class="masthead">
		<div class="container">
			<div class="intro-text">
				<div class="intro-lead-in">Bienvenidos a Pasajero23</div>
				<div class="intro-heading text-uppercase ">Nos encanta que
					estes aquí</div>
				<div></div>
				<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
					href="#services">Viajar</a>
			</div>

		</div>
	</header>

	<!-- Services -->
	<section id="services">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Servicios</h2>
					<div class="container" id="container"></div>

					<!--  
					<script type="text/javascript">
						document.getElementById('cargarDestinos').click();
					</script>
					<a id="cargarDestinos" href="ServletIndex"></a>
					-->
					<%
						ArrayList<Destino> dd = (ArrayList<Destino>) request.getSession().getAttribute("listaDestinos");
						if (!(dd == null || dd.isEmpty())) {
					%>
					<datalist id="destinos">
						<%
							for (Destino d : dd) {
						%>
						<option value="<%=d.getLocalidad()%>"
							label="<%=d.getLocalidad()%>"></option>
						<%
							}
						%>
					</datalist>
					<%
						}
					%>
					<form method=get action="ServletBuscarServicios">
						<input type="text" name="textOrigen" placeholder="Ingrese Origen"
							class="search-bar" list="destinos"><br> <input
							type="text" name="textDestino" placeholder="Ingrese Destino"
							class="search-bar" list="destinos"> <br>
						<button id="sendMessageButton"
							class="btn btn-primary btn-xl text-uppercase" type="submit">Buscar</button>
					</form>
					<form method=get action="ServletIndex">
						<button id="cargarDestinos" class="btn" type="submit">
							<i>Cargar destinos disponibles</i>
						</button>
					</form>
				</div>
			</div>
		</div>
	</section>



	<!-- Contact -->
	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Contáctanos</h2>
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
										placeholder="Tu Teléfono *" required="required"
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
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Contact form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/agency.min.js"></script>
	

	
	

</body>

</html>