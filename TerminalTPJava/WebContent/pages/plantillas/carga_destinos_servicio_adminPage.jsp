<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Destino"%>
<%@page import="entities.DestinoDirecto"%>


<%
	if (request.getSession().getAttribute("estadoCargaDestino").equals("CARGADESTINOSIGUIENTE")) {
		JOptionPane.showMessageDialog(null, "La carga del destinio esta en estado CARGADESTINOSIGUIENTE");
		System.out.println("La carga del destino esta en estado CARGADESTINOSIGUIENTE");
%>
<section id="main-content">
	<section class="wrapper">
		<div class="container main-chart">
			<form method=post action="../ServletServicio">
				<fieldset>
					<br>
					<h2>Ingrese el numero de identificacion del siguiente destino
						del viaje:</h2>
					<i>Cargo el destino </i>

					<div class="form-group col-lg-9">
						<label for="idDestino">Id del destino a agregar: </label> <input
							type="number" name="idDestino" placeholder="Ej: 1 o 5 o 9 ..."
							class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<label for="precio">Precio del origen a este destino: </label> <input
							type="number" name="precio" placeholder="Ej: 50, 150, 500 ..."
							class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<button value="Cargar micro" class="btn btn-primary" type="submit">Destino
							siguiente</button>
					</div>
				</fieldset>
				<input type="button"
					onclick="if(document.getElementById('spoiler1') .style.display=='none') {document.getElementById('spoiler1') .style.display=''; this.value = 'Ocultar'; }else{document.getElementById('spoiler1') .style.display='none';this.value = 'Mostrar'; }"
					value="Gracias por ..." />
				<div id="spoiler1" style="display: none">Usar Plataforma 23
					para conocer un nuevo destino en Argentina.</div>
			</form>
			<table class="table table-striped table-bordered">
				<tr>
					<th>Id</th>
					<th>Localidad</th>
					<th>Aumento</th>
					<th>Tipo</th>
				</tr>
				<%
					ArrayList<Destino> listaDes = (ArrayList<Destino>) request.getSession().getAttribute("listaDestinos");
						for (Destino d : listaDes) {
							if (d.getClass() == Destino.class) {
				%>
				<tr>
					<td><%=d.getIdDestino()%></td>
					<td><%=d.getLocalidad()%></td>
					<td><%=0.0%></td>
					<td><%=d.getClass().toString().substring(15)%></td>
				</tr>
				<%
					}
						}
				%>
			</table>

		</div>
	</section>
</section>
<%
	}

	if (request.getSession().getAttribute("estadoCargaDestino").equals("CARGADESTINOCANTIDAD")) {
		JOptionPane.showMessageDialog(null, "La carga del destino esta en estado CARGADESTINOCANTIDAD");
		System.out.println("La carga del destino esta en estado CARGADESTINOCANTIDAD");
%>
<section id="main-content">
	<section class="wrapper">
		<div class="container main-chart">
			<form method=post action="../ServletServicio">
				<fieldset>
					<br>
					<h2>Ingrese la cantidad de destinos que tendra el viaje,
						incluyendo al lugar de partida del micro:</h2>

					<div class="form-group col-lg-9">
						<label for="cantDestinos">Cantidad destinos: </label> <input
							type="number" name="cantDestinos" placeholder="3 o mas ..."
							class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<button value="Cargar micro" class="btn btn-primary" type="submit">Siguiente</button>
					</div>
					<input type="button"
						onclick="if(document.getElementById('spoiler1') .style.display=='none') {document.getElementById('spoiler1') .style.display=''; this.value = 'Ocultar'; }else{document.getElementById('spoiler1') .style.display='none';this.value = 'Mostrar'; }"
						value="Gracias por ..." />
					<div id="spoiler1" style="display: none">Usar Plataforma 23
						para conocer un nuevo destino en Argentina.</div>
				</fieldset>
			</form>
		</div>
	</section>
</section>
<%
	}

	if (request.getSession().getAttribute("estadoCargaDestino").equals("CARGADESTINOORIGEN")) {
		JOptionPane.showMessageDialog(null, "La carga del destino esta en estado CARGADESTINOORIGEN");
		System.out.println("La carga del destino esta en estado CARGADESTINOORIGEN");
%>
<section id="main-content">
	<section class="wrapper">
		<div class="container main-chart">
			<form method=post action="../ServletServicio">
				<fieldset>
					<br>
					<h2>Ingrese el numero de identificacion del lugar de partida
						del micro:</h2>

					<div class="form-group col-lg-9">
						<label for="idDestino">Numero: </label> <input type="number"
							name="idDestino" placeholder="Ej: 1, 5, 18" class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<button value="Cargar micro" class="btn btn-primary" type="submit">Siguiente</button>
					</div>
					<input type="button"
						onclick="if(document.getElementById('spoiler1') .style.display=='none') {document.getElementById('spoiler1') .style.display=''; this.value = 'Ocultar'; }else{document.getElementById('spoiler1') .style.display='none';this.value = 'Mostrar'; }"
						value="Gracias por ..." />
					<div id="spoiler1" style="display: none">Usar Plataforma 23
						para conocer un nuevo destino en Argentina.</div>
				</fieldset>
			</form>
			<table class="table table-striped table-bordered">
				<tr>
					<th>Id</th>
					<th>Localidad</th>
					<th>Aumento</th>
					<th>Tipo</th>
				</tr>
				<%
					ArrayList<Destino> listaDes = (ArrayList<Destino>) request.getSession().getAttribute("listaDestinos");
						for (Destino d : listaDes) {
							if (d.getClass() == Destino.class) {
				%>
				<tr>
					<td><%=d.getIdDestino()%></td>
					<td><%=d.getLocalidad()%></td>
					<td><%=0.0%></td>
					<td><%=d.getClass().toString().substring(15)%></td>
				</tr>
				<%
					}
						}
				%>
			</table>
		</div>
	</section>
</section>
<%
	}

	if (request.getSession().getAttribute("estadoCargaDestino").equals("CARGADESTINOFIN")) {
		JOptionPane.showMessageDialog(null, "La carga del destino esta en estado CARGADESTINOFIN");
		System.out.println("La carga del destino esta en estado CARGADESTINOFIN");
		if ((int) request.getSession().getAttribute("cantDestinos") == 2) {
%>
<section id="main-content">
	<section class="wrapper">
		<div class="container main-chart">
			<form method=post action="../ServletServicio">
				<fieldset>
					<br>
					<h2>Ingrese el numero de identificacion del lugar de arrivo
						del servicio directo:</h2>

					<div class="form-group col-lg-9">
						<label for="idDestino">Numero: </label> <input type="number"
							name="idDestino"
							placeholder="Ej: Directo a Santa Fe, Directo a Junin"
							class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<label for="precio">Precio del origen a este destino: </label> <input
							type="number" name="precio" placeholder="Ej: 50, 150, 500 ..."
							class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<button value="Cargar micros" class="btn btn-primary"
							type="submit">Cargar micros</button>
					</div>
					<input type="button"
						onclick="if(document.getElementById('spoiler1') .style.display=='none') {document.getElementById('spoiler1') .style.display=''; this.value = 'Ocultar'; }else{document.getElementById('spoiler1') .style.display='none';this.value = 'Mostrar'; }"
						value="Gracias por ..." />
					<div id="spoiler1" style="display: none">Usar Plataforma 23
						para conocer un nuevo destino en Argentina.</div>
				</fieldset>
			</form>
			<table class="table table-striped table-bordered">
				<tr>
					<th>Id</th>
					<th>Localidad</th>
					<th>Aumento</th>
					<th>Tipo</th>
				</tr>
				<%
					ArrayList<Destino> listaDes = (ArrayList<Destino>) request.getSession()
									.getAttribute("listaDestinos");
							for (Destino d : listaDes) {
								if (d.getClass() == DestinoDirecto.class) {
				%>
				<tr>
					<td><%=d.getIdDestino()%></td>
					<td><%=d.getLocalidad()%></td>
					<td><%=((DestinoDirecto) d).getPorcentajeAumento()%></td>
					<td><%=d.getClass().toString().substring(15)%></td>

				</tr>
				<%
					}
							}
				%>
			</table>
		</div>
	</section>
</section>
<%
	} else {
%>
<section id="main-content">
	<section class="wrapper">
		<div class="container main-chart">
			<form method=post action="../ServletServicio">
				<fieldset>
					<br>
					<h2>Ingrese el numero de identificacion del lugar de arrivo
						del servicio:</h2>

					<div class="form-group col-lg-9">
						<label for="idDestino">Numero: </label> <input type="number"
							name="idDestino" placeholder="Ej: Santa Fe, Rosario"
							class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<label for="precio">Precio del origen a este destino: </label> <input
							type="number" name="precio" placeholder="Ej: 50, 150, 500 ..."
							class="form-control" />
					</div>
					<div class="form-group col-lg-9">
						<button value="Cargar micro" class="btn btn-primary" type="submit">Cargar
							micros</button>
					</div>
					<input type="button"
						onclick="if(document.getElementById('spoiler1') .style.display=='none') {document.getElementById('spoiler1') .style.display=''; this.value = 'Ocultar'; }else{document.getElementById('spoiler1') .style.display='none';this.value = 'Mostrar'; }"
						value="Gracias por ..." />
					<div id="spoiler1" style="display: none">Usar Plataforma 23
						para conocer un nuevo destino en Argentina.</div>
				</fieldset>
			</form>
			<table class="table table-striped table-bordered">
				<tr>
					<th>Id</th>
					<th>Localidad</th>
					<th>Aumento</th>
					<th>Tipo</th>
				</tr>
				<%
					ArrayList<Destino> listaDes = (ArrayList<Destino>) request.getSession()
									.getAttribute("listaDestinos");
							for (Destino d : listaDes) {
								if (d.getClass() == Destino.class) {
				%>
				<tr>
					<td><%=d.getIdDestino()%></td>
					<td><%=d.getLocalidad()%></td>
					<td><%=0.0%></td>
					<td><%=d.getClass().toString().substring(15)%></td>
				</tr>
			</table>
		</div>
	</section>
</section>
<%
	}
			}
		}
	}
%>