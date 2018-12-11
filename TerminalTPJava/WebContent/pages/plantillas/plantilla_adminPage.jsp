
<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
<!--header start-->
<header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<!--logo start-->
	<a href="index.html" class="logo"><b>Pasajero 23</b></a>
	<!--logo end-->
	<div class="nav notify-row" id="top_menu"></div>
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<li><a class="logout" href="../SevletCerrarSesion">Logout</a></li>
		</ul>
	</div>
</header>
<!--header end-->

<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
<!--sidebar start-->
<aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion" name="#">

			<p class="centered">
				<a href="profile.html"><img src="assets/img/ui-sam.jpg"
					class="img-circle" width="60"></a>
			</p>
			<h5 class="centered">Matias Lamens</h5>

			<li class="sub-menu"><a href="javascript:;"> <!--  class="fa fa-cogs"></i> <span>Servicios</span>-->
					<i class="glyphicon glyphicon-globe"></i> <span>Servicios</span>

			</a>
				<ul class="sub">
					<li><a href="../ServletServicio?tipo=consulta">Consultar</a></li>
					<li><a href="../ServletServicio?tipo=alta">Agregar</a></li>
					<li><a href="../ServletServicio?tipo=modifica">Actualizar</a></li>
					<li><a href="../ServletServicio?tipo=agregarRefuerzo">Agregar
							refuerzo</a></li>
					<li><a href="../ServletServicio?tipo=baja">Dar de baja</a></li>
				</ul></li>
			<li class="sub-menu"><a class="" href=""> <i
					class="fa fa-dashboard"></i> <span>Micros</span>
			</a>
				<ul class="sub">
					<li><a href="../ServletMicro?tipo=consulta">Consultar</a></li>
					<li><a href="../ServletMicro?tipo=alta">Agregar</a></li>
					<li><a href="../ServletMicro?tipo=modifica">Actualizar</a></li>
					<li><a href="../ServletMicro?tipo=baja">Dar de baja</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="glyphicon glyphicon-user"></i> <span>Conductores</span>
			</a>
				<ul class="sub">
					<li><a href="../ServletConductor?tipo=consulta">Consultar</a></li>
					<li><a href="../ServletConductor?tipo=alta">Agregar</a></li>
					<li><a href="../ServletConductor?tipo=modifica">Actualizar</a></li>
					<li><a href="../ServletConductor?tipo=baja">Dar de baja</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="glyphicon glyphicon-road"></i> <span>Destinos</span>
			</a>
				<ul class="sub">
					<li><a href="../ServletDestino?tipo=consulta">Consultar</a></li>
					<li><a href="../ServletDestino?tipo=alta">Agregar</a></li>
					<li><a href="../ServletDestino?tipo=modifica">Actualizar</a></li>
					<li><a href="../ServletDestino?tipo=baja">Dar de baja</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-desktop"></i> <span>Clientes</span>
			</a>
				<ul class="sub">
					<li><a href="../ServletCliente?tipo=consulta">Consultar</a></li>
					<li><a href="../ServletCliente?tipo=baja">Dar de baja</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class=" glyphicon glyphicon-stats"></i> <span>Informes</span>
			</a>
				<ul class="sub">
					<li><a href="morris.html">Del dia</a></li>
					<li><a href="chartjs.html">Del mes</a></li>
					<li><a href="chartjs.html">Del año</a></li>
				</ul></li>
		</ul>
		<!-- sidebar menu end-->
	</div>
</aside>
<!--sidebar end-->