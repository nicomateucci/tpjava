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

				<div class="row">
					<div class="col-lg-9 main-chart">

						<div class="row mtbox">
							<div class="col-md-2 col-sm-2 col-md-offset-1 box0">
								<div class="box1">
									<span class="li_heart"></span>
									<h3>933</h3>
								</div>
								<p>933 People liked your page the last 24hs. Whoohoo!</p>
							</div>
							<div class="col-md-2 col-sm-2 box0">
								<div class="box1">
									<span class="li_cloud"></span>
									<h3>+48</h3>
								</div>
								<p>48 New files were added in your cloud storage.</p>
							</div>
							<div class="col-md-2 col-sm-2 box0">
								<div class="box1">
									<span class="li_stack"></span>
									<h3>23</h3>
								</div>
								<p>You have 23 unread messages in your inbox.</p>
							</div>
							<div class="col-md-2 col-sm-2 box0">
								<div class="box1">
									<span class="li_news"></span>
									<h3>+10</h3>
								</div>
								<p>More than 10 news were added in your reader.</p>
							</div>
							<div class="col-md-2 col-sm-2 box0">
								<div class="box1">
									<span class="li_data"></span>
									<h3>OK!</h3>
								</div>
								<p>Your server is working perfectly. Relax & enjoy.</p>
							</div>

						</div>
						<!-- /row mt -->


						<div class="row mt">
							<!-- SERVER STATUS PANELS -->
							<div class="col-md-4 col-sm-4 mb">
								<div class="white-panel pn donut-chart">
									<div class="white-header">
										<h5>SERVER LOAD</h5>
									</div>
									<div class="row">
										<div class="col-sm-6 col-xs-6 goleft">
											<p>
												<i class="fa fa-database"></i> 70%
											</p>
										</div>
									</div>
									<canvas id="serverstatus01" height="120" width="120"></canvas>
									<script>
									var doughnutData = [
											{
												value: 70,
												color:"#68dff0"
											},
											{
												value : 30,
												color : "#fdfdfd"
											}
										];
										var myDoughnut = new Chart(document.getElementById("serverstatus01").getContext("2d")).Doughnut(doughnutData);
								</script>
								</div>
								<! --/grey-panel -->
							</div>
							<!-- /col-md-4-->


							<div class="col-md-4 col-sm-4 mb">
								<div class="white-panel pn">
									<div class="white-header">
										<h5>TOP PRODUCT</h5>
									</div>
									<div class="row">
										<div class="col-sm-6 col-xs-6 goleft">
											<p>
												<i class="fa fa-heart"></i> 122
											</p>
										</div>
										<div class="col-sm-6 col-xs-6"></div>
									</div>
									<div class="centered">
										<img src="assets/img/product.png" width="120">
									</div>
								</div>
							</div>
							<!-- /col-md-4 -->

							<div class="col-md-4 mb">
								<!-- WHITE PANEL - TOP USER -->
								<div class="white-panel pn">
									<div class="white-header">
										<h5>TOP USER</h5>
									</div>
									<p>
										<img src="assets/img/ui-zac.jpg" class="img-circle" width="80"
											style="background-color: #FED13B">
									</p>
									<p>
										<b>Matias Lamens</b>
									</p>
									<div class="row">
										<div class="col-md-6">
											<p class="small mt">MEMBER SINCE</p>
											<p>2012</p>
										</div>
										<div class="col-md-6">
											<p class="small mt">TOTAL SPEND</p>
											<p>$ 47,60</p>
										</div>
									</div>
								</div>
							</div>
							<!-- /col-md-4 -->


						</div>
						<!-- /row -->



						<div class="row mt">
							<!--CUSTOM CHART START -->
							<div class="border-head">
								<h3>VISITS</h3>
							</div>
							<div class="custom-bar-chart">
								<ul class="y-axis">
									<li><span>10.000</span></li>
									<li><span>8.000</span></li>
									<li><span>6.000</span></li>
									<li><span>4.000</span></li>
									<li><span>2.000</span></li>
									<li><span>0</span></li>
								</ul>
								<div class="bar">
									<div class="title">JAN</div>
									<div class="value tooltips" data-original-title="8.500"
										data-toggle="tooltip" data-placement="top">85%</div>
								</div>
								<div class="bar ">
									<div class="title">FEB</div>
									<div class="value tooltips" data-original-title="5.000"
										data-toggle="tooltip" data-placement="top">50%</div>
								</div>
								<div class="bar ">
									<div class="title">MAR</div>
									<div class="value tooltips" data-original-title="6.000"
										data-toggle="tooltip" data-placement="top">60%</div>
								</div>
								<div class="bar ">
									<div class="title">APR</div>
									<div class="value tooltips" data-original-title="4.500"
										data-toggle="tooltip" data-placement="top">45%</div>
								</div>
								<div class="bar">
									<div class="title">MAY</div>
									<div class="value tooltips" data-original-title="3.200"
										data-toggle="tooltip" data-placement="top">32%</div>
								</div>
								<div class="bar ">
									<div class="title">JUN</div>
									<div class="value tooltips" data-original-title="6.200"
										data-toggle="tooltip" data-placement="top">62%</div>
								</div>
								<div class="bar">
									<div class="title">JUL</div>
									<div class="value tooltips" data-original-title="7.500"
										data-toggle="tooltip" data-placement="top">75%</div>
								</div>
							</div>
							<!--custom chart end-->
						</div>
						<!-- /row -->

					</div>
					<!-- /col-lg-9 END SECTION MIDDLE -->

				</div>
				<! --/row -->
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
        $(document).ready(function () {
        var unique_id = $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'Bienvenido a Plataforma23!',
            // (string | mandatory) the text inside the notification
            text: 'Si desea contactar con el soporte tecnico ingrese a <a href="http://somossistemas.com" target="_blank" style="color:#ffd777">somossistemas.com</a>.<br>Puede cerrar este cuadro de dialogo en cualquier momento.',
            // (string | optional) the image to display on the left
            image: 'assets/img/ui-sam.jpg',
            // (bool | optional) if you want it to fade out on its own or just sit there
            sticky: true,
            // (int | optional) the time you want it to be alive for before fading out
            time: '',
            // (string | optional) the class name you want to apply to that specific message
            class_name: 'my-sticky-class'
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
