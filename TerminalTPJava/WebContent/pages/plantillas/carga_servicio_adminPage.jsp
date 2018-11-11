<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Servicio"%>

<%
	if (request.getSession().getAttribute("tipo") == "alta") {

		if (request.getSession().getAttribute("estadoServicio").equals("CARGAID")) {

			JOptionPane.showMessageDialog(null, "La carga del servicio esta en estado CARGAID");
			System.out.println("La carga del servicio esta en estado CARGAID");
%>

<section id="main-content">
	<section class="wrapper">
		<div class="container main-chart">
			<form method=post action="../ServletServicio">
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
							<option value="ServicioDirecto">Servicio con destino
								directo</option>
							<option value="ServicioNormal" onchange="generarCantDestinos()">Servicio
								normal</option>
						</select>
					</div>
					<!-- <input type="button" value="Genera cantidad de destinos" class="btn btn-warning" onclick="generaCantDestinos()"> -->
					<div class="form-group col-lg-9">
						<button value="Ingresar" class="btn btn-primary">Cargar
							destinos</button>
					</div>
					<a href></a>
				</fieldset>
				<input type="button"
					onclick="if(document.getElementById('spoiler1') .style.display=='none') {document.getElementById('spoiler1') .style.display=''; this.value = 'Ocultar'; }else{document.getElementById('spoiler1') .style.display='none';this.value = 'Mostrar'; }"
					value="Gracias por ..." />
				<div id="spoiler1" style="display: none">Usar Plataforma 23 para conocer un nuevo destino en Argentina.</div>
			</form>
		</div>
	</section>
</section>
<%
	}

		if (request.getSession().getAttribute("estadoServicio").equals("CARGADESTINO")) {
			JOptionPane.showMessageDialog(null, "La carga del servicio esta en estado CARGADESTINO");
			System.out.println("La carga del servicio esta en estado CARGADESTINO");
%>

<jsp:include page="carga_destinos_servicio_adminPage.jsp"></jsp:include>

<%
	if (request.getSession().getAttribute("estadoServicio").equals("CARGAMICRO")) {
				JOptionPane.showMessageDialog(null, "La carga del servicio esta en estado CARGAMICRO");
				System.out.println("La carga del servicio esta en estado CARGAMICRO");
%>
<section id="main-content">
	<section class="wrapper">
		<div class="container main-chart">
			<form method=post action="../ServletServicio">
				<fieldset>
					<br>
					<h2>Ingrese los datos del nuevo servicio:</h2>

					<div class="form-group col-lg-9">
						<label for="fechaServicio">Fecha del servicio: </label> <input
							type="text" name="fechaServicio" placeholder="aaaa-mm-dd"
							class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<label for="horaServicio">Hora del servicio: </label> <input
							type="text" name="horaServicio" class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<label for="tipoServicio">Tipo de Servicio: </label> <select
							name="tipoServicio" id="" class="form-control">
							<option value="ServicioDirecto">Servicio con destino
								directo</option>
							<option value="ServicioNormal">Servicio normal</option>
						</select>
					</div>
					<div class="form-group col-lg-9">
						<button value="Ingresar" class="btn btn-primary">Cargar
							conductores</button>
					</div>
					<a href></a>
				</fieldset>
				<input type="button"
					onclick="if(document.getElementById('spoiler1') .style.display=='none') {document.getElementById('spoiler1') .style.display=''; this.value = 'Ocultar'; }else{document.getElementById('spoiler1') .style.display='none';this.value = 'Mostrar'; }"
					value="Gracias por ..." />
				<div id="spoiler1" style="display: none">Usar Plataforma 23	para conocer un nuevo destino en Argentina.</div>
			</form>
		</div>
	</section>
</section>


<%
	}
		}
		if (request.getSession().getAttribute("estadoServicio").equals("CARGACONDUCTOR")) {
			JOptionPane.showMessageDialog(null, "La carga del servicio esta en estado CARGACONDUCTOR");
			System.out.println("La carga del servicio esta en estado CARGACONDUCTOR");
%>
<section id="main-content">
	<section class="wrapper">
		<div class="container main-chart">
			<form method=post action="../ServletServicio">
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
							<option value="ServicioNormal">Servicio normal</option>
						</select>
					</div>
					<div class="form-group col-lg-9">
						<button value="Ingresar" class="btn btn-primary">FInalizar</button>
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
<%
	}
	}
%>

















