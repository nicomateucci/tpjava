<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>Pagina del usuario administrador del sistema</title>

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

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<%
					double[] datos = (double[]) request.getSession().getAttribute("listaRecaudacionMes");
				%>
				<div class="row mt col-lg-10">
					<!--CUSTOM CHART START -->
					<div class="border-head">
						<h3>Recaudacion por mes:</h3>
					</div>
					<div class="custom-bar-chart">
						<!--
						<ul class="y-axis">
							<li><span>8.000</span></li>
							<li><span>6.000</span></li>
							<li><span>4.000</span></li>
							<li><span>2.000</span></li>
							<li><span>0</span></li>
						</ul>-->
						<div class="bar">
							<div class="title">Diciembre 2018</div>
							<div class="value tooltips" data-original-title="<%=datos[0]%>"
								data-toggle="tooltip" data-placement="top"><%=datos[0]/100%>
							</div>
						</div>
						<div class="bar ">
							<div class="title">Enero 2019</div>
							<div class="value tooltips" data-original-title="<%=datos[1]%>"
								data-toggle="tooltip" data-placement="top"><%=datos[1]/100%>
							</div>
						</div>
						<div class="bar ">
							<div class="title">Febrero</div>
							<div class="value tooltips" data-original-title="<%=datos[2]%>"
								data-toggle="tooltip" data-placement="top"><%=datos[2]/100%>
							</div>
						</div>
						<div class="bar ">
							<div class="title">Marzo</div>
							<div class="value tooltips" data-original-title="<%=datos[3]%>"
								data-toggle="tooltip" data-placement="top"><%=datos[3]/100%>
							</div>
						</div>
						<div class="bar ">
							<div class="title">Abril</div>
							<div class="value tooltips" data-original-title="<%=datos[4]%>"
								data-toggle="tooltip" data-placement="top"><%=datos[4]/100%>
							</div>
						</div>
						<div class="bar ">
							<div class="title">Mayo</div>
							<div class="value tooltips" data-original-title="<%=datos[5]%>"
								data-toggle="tooltip" data-placement="top"><%=datos[5]/100%>
							</div>
						</div>
						<div class="bar">
							<div class="title">Junio</div>
							<div class="value tooltips" data-original-title="<%=datos[6]%>"
								data-toggle="tooltip" data-placement="top"><%=datos[6]/100%>
							</div>
						</div>
					</div>
				</div>
			</section>
		</section>

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
