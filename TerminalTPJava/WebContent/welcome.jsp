<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="entities.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Destino"%>
<%@page import="entities.DestinoDirecto"%>

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
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav"
		style="background-color: #3e3d36">
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
					<li class="nav-item"><select style="background-color: black"
						onchange="location.href=this.options[this.selectedIndex].value"
						name="elige" size="1">
							<option value="">Mi cuenta</option>
							<option value="">Ayuda</option>
							<option value="SevletCerrarSesion">Salir</option>
					</select></li>
				</ul>
			</div>
		</div>
	</nav>

	<jsp:include page="pages/carouselBootstrap/carruselPaisajes.jsp"></jsp:include>

	<!-- Services -->
	<section id="services">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Servicios</h2>

					<br>
					<canvas id="myChart" style="width: 90%; height: 80%"></canvas>
					<br>

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
							class="search-bar"><br> <input type="text"
							name="textDestino" placeholder="Ingrese Destino"
							class="search-bar"> <br>
							<%
							String m = null;
							m = (String) request.getSession().getAttribute("mensaje");
							if (m != null) {
						%>
						<div style="color: red">
							<i><%=m%></i>
						</div>

						<%
							}
						%>
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

	<script src="js/Chart.min.js"></script>
	<%
		String[][] datos = (String[][]) request.getSession().getAttribute("informeDestinos");
	%>

	<script>
		var ctx = document.getElementById("myChart").getContext('2d');
		var myChart = new Chart(ctx, {
		    type: 'bar',
		    data: {
		        labels: ['<%=datos[0][0]%>', '<%=datos[1][0]%>', '<%=datos[2][0]%>'],
		        datasets: [{
		            label: 'Destinos mas solicitados en el mes:',
		            //data: [12, 19, 3],
		            data: [<%=Integer.parseInt(datos[0][1])%>, <%=Integer.parseInt(datos[1][1])%>, <%=Integer.parseInt(datos[2][1])%>],
		            backgroundColor: [
		                'rgba(255, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(255, 206, 86, 0.2)',
		            ],
		            borderColor: [
		                'rgba(255,99,132,1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)',
		            ],
		            borderWidth: 5
		        }]
		    },
		    options: {
		        scales: {
		        	yAxes: [{
		                stacked: true,
		            }]
		        }
		    }
		});
	</script>



</body>

</html>