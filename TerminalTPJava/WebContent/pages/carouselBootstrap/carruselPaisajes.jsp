<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="entities.Usuario"%>
<%
	Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogeado");
%>
<link rel="stylesheet" href="css/bootstrap.min.css">

<div id="carouselExampleIndicators" class="carousel slide"
	data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleIndicators" data-slide-to="0"
			class="active"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="5"></li>
	</ol>
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img class="d-block w-100" src="img/CataratasIguazuAncho700.jpg"
				alt="First slide">
			<div class="carousel-caption">
				<div class="intro-text">
					<p style="float: top">Cataratas del Iguazo</p>
					<div class="intro-lead-in">Hola <%=user.getNombre()%></div>
					<div class="intro-heading ">Que paisaje te gustaría conocer
						en tus proximas vacaciones ?</div>
					<div></div>
					<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
						href="#services">Viajar</a>
				</div>
			</div>
		</div>
		<div class="carousel-item">
			<img class="d-block w-100" src="img/LosAndesAncho700.jpg"
				alt="Second slide">
			<div class="carousel-caption">
				<div class="intro-text">
					<p style="float: top">Cordillera de Los Andes</p>
					<div class="intro-lead-in">Hola <%=user.getNombre()%></div>
					<div class="intro-heading ">Que paisaje te gustaría conocer
						en tus proximas vacaciones ?</div>
					<div></div>
					<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
						href="#services">Viajar</a>
				</div>
			</div>
		</div>
		<div class="carousel-item">
			<img class="d-block w-100" src="img/MonteFitzRoyAncho700.jpg"
				alt="Third slide">
			<div class="carousel-caption">
				<div class="intro-text">
					<p style="float: top">Monte Fitz Roy, La Patagonia 40</p>
					<div class="intro-lead-in">Hola <%=user.getNombre()%></div>
					<div class="intro-heading ">Que paisaje te gustaría conocer
						en tus proximas vacaciones ?</div>
					<div></div>
					<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
						href="#services">Viajar</a>
				</div>
			</div>
		</div>
		<div class="carousel-item">
			<img class="d-block w-100" src="img/PeritoMorenoAncho700.jpg"
				alt="Third slide">
			<div class="carousel-caption">
				<div class="intro-text">
					<p style="float: top">Perito Moreno, Tierra del Fuego</p>
					<div class="intro-lead-in">Hola <%=user.getNombre()%></div>
					<div class="intro-heading ">Que paisaje te gustaría conocer
						en tus proximas vacaciones ?</div>
					<div></div>
					<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
						href="#services">Viajar</a>
				</div>
			</div>
		</div>
		<div class="carousel-item">
			<img class="d-block w-100" src="img/Ruta40Ancho700.jpg"
				alt="Third slide">
			<div class="carousel-caption">
				<div class="intro-text">
					<p style="float: top">Paisajes sobre la Ruta 40</p>
					<div class="intro-lead-in">Hola <%=user.getNombre()%></div>
					<div class="intro-heading ">Que paisaje te gustaría conocer
						en tus proximas vacaciones ?</div>
					<div></div>
					<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
						href="#services">Viajar</a>
				</div>
			</div>
		</div>
		<div class="carousel-item">
			<img class="d-block w-100" src="img/SalinasGrandesJujuyAncho700.jpg"
				alt="Third slide">
			<div class="carousel-caption">
				<div class="intro-text">
					<p style="float: top">Grandes Salinas, Jujuy</p>
					<div class="intro-lead-in">Hola <%=user.getNombre()%></div>
					<div class="intro-heading ">Que paisaje te gustaría conocer
						en tus proximas vacaciones ?</div>
					<div></div>
					<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
						href="#services">Viajar</a>
				</div>
			</div>
		</div>

	</div>
	<a class="carousel-control-prev" href="#carouselExampleIndicators"
		role="button" data-slide="prev"> <span
		class="carousel-control-prev-icon" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
		role="button" data-slide="next"> <span
		class="carousel-control-next-icon" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a>
</div>

<script src="js/jquery-3.3.1.slim.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>