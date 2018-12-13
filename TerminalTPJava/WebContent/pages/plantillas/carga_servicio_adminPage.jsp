<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Servicio"%>
<%@page import="entities.Micro"%>
<%@page import="entities.MicroCama"%>
<%@page import="entities.Conductor"%>

<%
	if (request.getSession().getAttribute("tipo") == "alta") {

		if (request.getSession().getAttribute("estadoServicio").equals("CARGAID")) {

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
							type="text" name="horaServicio" class="form-control"
							placeholder="Ej: 13:30" />
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
				<div id="spoiler1" style="display: none">Usar Plataforma 23
					para conocer un nuevo destino en Argentina.</div>
			</form>
		</div>
	</section>
</section>
<%
	}

		if (request.getSession().getAttribute("estadoServicio").equals("CARGADESTINO")) {
			System.out.println("La carga del servicio esta en estado CARGADESTINO");
%>

<jsp:include page="carga_destinos_servicio_adminPage.jsp"></jsp:include>

<%
	}
		if (request.getSession().getAttribute("estadoServicio").equals("CARGAMICRO")) {
			System.out.println("La carga del servicio esta en estado CARGAMICRO");
%>
<section id="main-content">
	<section class="wrapper">
		<div class="container main-chart">
		<h2>Lista de micros:</h2>
			<table class="table table-striped table-bordered">
				<tr>
					<th>Patente</th>
					<th>Marca</th>
					<th>Fecha Ultimo Control</th>
					<th>Porcentaje aumento</th>
					<th>Tipo</th>
				</tr>
				<%
					ArrayList<Micro> listaMic = (ArrayList<Micro>) request.getSession().getAttribute("listaMicros");
							for (Micro m : listaMic) {
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
			<form method=post action="../ServletServicio">
				<fieldset>
					<br>
					<h2>Ingrese la patente de los micros que desée asociar al
						servicio:</h2>

					<div class="form-group col-lg-9">
						<label for="patenteMicro">Ingrese la patente del micro
							principal: </label> <input type="text" name="patenteMicro"
							placeholder="AA111BB" class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<label for="patenteRefuerzo">Ingrese la patente del micro
							de refuerzo: </label> <input type="text" name="patenteRefuerzo"
							class="form-control"
							placeholder="Dejar en blanco en caso de ausencia de refuerzos" />
					</div>
					<div class="col-lg-9">
						<i><strong>En caso de nuevos refuerzos, podra
								agregarlos desde la opcion "Agregar refuerzo" del submenu
								"Servicios" de la pagina principal</strong> </i>
					</div>
					<div class="form-group col-lg-9">
						<button value="Ingresar" class="btn btn-primary">Cargar
							conductores</button>
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
		if (request.getSession().getAttribute("estadoServicio").equals("CARGACONDUCTOR")) {
			System.out.println("La carga del servicio esta en estado CARGACONDUCTOR");
%>
<section id="main-content">
	<section class="wrapper">
		<div class="container main-chart">
			<h2>Lista de micros ingresados:</h2>
			<table class="table table-striped table-bordered">
				<tr>
					<th>Patente</th>
					<th>Marca</th>
					<th>Tipo</th>
				</tr>
				<%
					Servicio ser = (Servicio) request.getSession().getAttribute("servicio");
							for (Micro m : ser.getMicros()) {
				%>
				<tr>
					<td><%=m.getPatente()%></td>
					<td><%=m.getMarca()%></td>
					<td><%=m.getClass().toString().substring(15)%></td>
				</tr>
				<%
					}
				%>

			</table>
			<form method=post action="../ServletServicio">
				<fieldset>
					<br>
					<h2>Ingrese los conductores de los micros:</h2>

					<div class="form-group col-lg-9">
						<label for="dni">Ingrese dni del conductor del micro
							horario: </label> <input type="text" name="dni"
							placeholder="Ej: 12345678" class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<label for="dni2">Ingrese dni del co-conductor del micro
							horario: </label> <input type="text" name="dni2"
							placeholder="En caso de no tener dejar en blanco"
							class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<label for="dniRef">Ingrese dni del conductor del micro
							refuerzo: </label> <input type="text" name="dniRef"
							placeholder="Ej: 12345678" class="form-control" value="" />
					</div>
					<div class="form-group col-lg-9">
						<label for="dniRef2">Ingrese dni del co-conductor del
							micro refuerzo: </label> <input type="text" name="dniRef2"
							placeholder="En caso de no tener dejar en blanco" value=""
							class="form-control" />
					</div>
					<div class="col-lg-9">
						<i><strong>En caso de nuevos conductores o
								coconductores, podra agregarlos desde la opcion "Agregar
								conductor" del submenu "Micros" de la pagina principal</strong> </i>
					</div>
					<div class="form-group col-lg-9">
						<button value="Ingresar" class="btn btn-primary">Finalizar</button>
					</div>
				</fieldset>
				<input type="button"
					onclick="if(document.getElementById('spoiler1') .style.display=='none') {document.getElementById('spoiler1') .style.display=''; this.value = 'Ocultar'; }else{document.getElementById('spoiler1') .style.display='none';this.value = 'Mostrar'; }"
					value="Gracias por ..." />
				<div id="spoiler1" style="display: none">Usar Plataforma 23
					para conocer un nuevo destino en Argentina.</div>
			</form>
			<h2>Lista de conductores:</h2>
			<table class="table table-striped table-bordered">
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Dni</th>
					<th>Fecha Nacimiento</th>
					<th>Fecha Inicio</th>
					<th>Contacto</th>
				</tr>
				<%
					ArrayList<Conductor> listaCon = (ArrayList<Conductor>) request.getSession()
									.getAttribute("listaConductores");
							for (Conductor c : listaCon) {
				%>
				<tr>
					<td><%=c.getNombre()%></td>
					<td><%=c.getApellido()%></td>
					<td><%=c.getDni()%></td>
					<td><%=c.getFechaNacimiento()%></td>
					<td><%=c.getFechaInicio()%></td>
					<td><%=c.getContacto()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</section>
</section>
<%
	}
	}
%>

















