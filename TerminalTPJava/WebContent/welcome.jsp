<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="entities.Usuario"%>

<!DOCTYPE html>
<html lang="en">

<head>
<%
	Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogeado");
%>

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
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav" style="background-color:  #3e3d36  ">
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
						href="./pages/LoginUsuario.html"></a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Header --><!-- 
	<header class="masthead">
		<div class="container">
			<div class="intro-text">
				<div class="intro-lead-in">
					Bienvenidos
					</div>
				<div class="intro-heading text-uppercase ">Que paisaje quieres
					conocer en tus proximas vacaciones ?</div>
				<div></div>
				<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
					href="#services">Viajar</a>
			</div>

		</div>
	</header> -->
	
	
	<!-- Carrusel -->
	<section id="corrusel" style="background-color:#E6E6FA">
	<div class="container">
		<br>
		<div id="carousel-1" class="carousel slide" data-ride="carousel">

			<!-- Indicadores -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-1" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-1" data-slide-to="1"></li>
				<li data-target="#carousel-1" data-slide-to="2"></li>
			</ol>

			<!-- Contenedor de los slida -->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="img/Desierto-Sol-1200x400.jpg" alt="First slide"
						class="img-responsive d-block w-100">
					<div class="carousel-caption">
						<div class="intro-text">
							<div class="intro-lead-in">
								Hola
								<%=user.getNombre()%></div>
							<div class="intro-heading ">Que paisaje
								te gustaría conocer en tus proximas vacaciones ?</div>
							<div></div>
							<a
								class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
								href="#services">Viajar</a>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<img src="img/Ruta-en-montañas-800x400.jpg" alt="Third slide"
						class="img-responsive d-block w-100">
					<div class="carousel-caption">
						<div class="intro-text">
							<div class="intro-lead-in">
								Hola
								<%=user.getNombre()%></div>
							<div class="intro-heading text-uppercase ">Que paisaje
								te gustaría conocer en tus proximas vacaciones ?</div>
							<div></div>
							<a
								class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
								href="#services">Viajar</a>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<img src="img/Textura-horizontal-Horizonte-1024x400forzada.jpg"
						alt="Third slide" class="img-responsive d-block w-100">
					<div class="carousel-caption">
						<div class="intro-text">
							<div class="intro-lead-in">
								Hola
								<%=user.getNombre()%></div>
							<div class="intro-heading text-uppercase ">Que paisaje
								te gustaría conocer en tus proximas vacaciones ?</div>
							<div></div>
							<a
								class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
								href="#services">Viajar</a>
						</div>
					</div>
				</div>
			</div>

			<!-- Controles -->
			<a href="#carousel-1" class="carousel-control-prev" role="button"
				data-slide="prev"> <span class="carousel-control-prev-icon"
				aria-hidden="true"></span> <span class="sr-only">Anterior</span>
			</a> <a href="#carousel-1" class="carousel-control-next" role="button"
				data-slide="next"> <span class="carousel-control-next-icon"
				aria-hidden="true"></span> <span class="sr-only">Siguiente</span>
			</a>
		</div>
	</div>
	</section>

	<!-- Services -->
	<section id="services">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Servicios</h2>

					<form method=get action="ServletBuscarServicios">
						<input type="text" name="textOrigen" placeholder="Ingrese Origen"
							class="search-bar"><br> <input type="text"
							name="textDestino" placeholder="Ingrese Destino"
							class="search-bar"> <br>
						<button id="sendMessageButton"
							class="btn btn-primary btn-xl text-uppercase" type="submit">Buscar</button>


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