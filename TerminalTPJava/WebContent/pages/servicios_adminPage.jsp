<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Servicio"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Pagina de administracion de Servicios</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="assets/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="assets/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">

<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">

<script src="assets/js/chart-master/Chart.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<section id="container">

		<jsp:include page="plantillas/plantilla_adminPage.jsp"></jsp:include>

		<!-- Contenido principal-->
		<!-- ****************************************************** -->
		<!-- ****************************************************** -->

		<% if (request.getSession().getAttribute("tipo") == "consulta"){%>

		<section id="main-content">
			<section class="wrapper">
				<div class="container main-chart">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Id</th>
							<th>Fecha</th>
							<th>Hora partida</th>
							<th>Destinos</th>
							<!--<th> Micro </th>-->
							<!--<th> Marca</th>th>-->
							<!--<th> Conductor </th>   -->
							<!--<th> Refuerzo </th><!-- Si o no -->
							<!--  <th> Asientos vendidos </th>-->
							<!-- <th> Asientos disponibles </th>-->
						</tr>
						<%
				ArrayList<Servicio> listaSer = (ArrayList<Servicio>)request.getSession().getAttribute("listaServicios");
	      				//boolean refuerzos[] = (boolean[]) request.getSession().getAttribute("arregloRefuerzos");
	      				for(Servicio s: listaSer){
	      				%>
						<tr>
							<td><%= s.getIdServicio()%></td>
							<td><%= s.getFechaServicio()%></td>
							<td><%= s.getHoraServicio()%></td>
							<td><%= s.getRecorrido()%></td>
							<!-- Tengo que ver como lo hago -->
						</tr>
						<%
	      			}
	      			%>
					</table>
				</div>

			</section>
		</section>



		<%} else if (request.getSession().getAttribute("tipo") == "alta"){ %>


		<section id="main-content">
			<section class="wrapper">
				<div class="container main-chart">
					<form method=post action="">
						<fieldset>
							<br>
							<h2>Ingrese los datos del nuevo servicio:</h2>

							<div class="form-group col-lg-9">
								<label for="fechaServicio">Fecha del servicio: </label> <input
									type="date" name="fechaServicio" placeholder="aaaa-mm-dd"
									class="form-control" />
							</div>
							<div class="form-group col-lg-9">
								<label for="horaServicio">Hora del servicio: </label> <input
									type="text" name="horaServicio" class="form-control" />
							</div>
							<div class="form-group col-lg-9">
								<label for="tipoServicio">Tipo de Servicio: </label> <select
									name="tipoServicio" id="" class="form-control">
									<option value="ServicioDirecto">Servicio con destin
										directo</option>
									<option value="ServicioNormal">Serivico normal</option>
								</select>
							</div>
							<div class="form-group col-lg-9">
								<button type="" href="" value="Ingresar" class="btn btn-info">Siguiente</button>
							</div>
						</fieldset>
						<input type="button"
							onclick="if(document.getElementById('spoiler1') .style.display=='none') {document.getElementById('spoiler1') .style.display=''; this.value = 'Ocultar'; }else{document.getElementById('spoiler1') .style.display='none';this.value = 'Mostrar'; }"
							value="Gracias por ..." />
						<div id="spoiler1" style="display: none">Usar Plataforma 23
							para conocer un nuevo destino en Argentina.</div>
					</form>
				</div>
			</section>
		</section>


		<%} else if (request.getSession().getAttribute("tipo") == "baja"){ %>

		<%} %>

		<jsp:include page="plantillas/plantillaFooter_adminPage.jsp"></jsp:include>

	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="assets/js/jquery.sparkline.js"></script>


	<!--common script for all pages-->
	<script src="assets/js/common-scripts.js"></script>

	<script type="text/javascript"
		src="assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="assets/js/gritter-conf.js"></script>

	<!--script for this page-->
	<script src="assets/js/sparkline-chart.js"></script>
	<script src="assets/js/zabuto_calendar.js"></script>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var unique_id = $.gritter
									.add({
										// (string | mandatory) the heading of the notification
										title : 'Bienvenido a Plataforma23!',
										// (string | mandatory) the text inside the notification
										text : 'Si desea contactar con el soporte tecnico ingrese a <a href="http://somossistemas.com" target="_blank" style="color:#ffd777">somossistemas.com</a>.<br>Puede cerrar este cuadro de dialogo en cualquier momento.',
										// (string | optional) the image to display on the left
										image : 'assets/img/ui-sam.jpg',
										// (bool | optional) if you want it to fade out on its own or just sit there
										sticky : true,
										// (int | optional) the time you want it to be alive for before fading out
										time : '',
										// (string | optional) the class name you want to apply to that specific message
										class_name : 'my-sticky-class'
									});

							return false;
						});
	</script>

	<script type="application/javascript">
		
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    
	</script>

</body>
</html>