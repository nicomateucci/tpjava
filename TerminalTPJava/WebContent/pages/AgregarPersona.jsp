<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina para la alta de un nuevo usuario</title>

<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>

	<section id="container">
		<section id="main-content">
			<jsp:include page="plantillas/plantilla_adminPage.jsp"></jsp:include>

			<h2>Ingrese sus informacion personal:</h2>

			<section class="wrapper">
				<div class="container main-chart">
					<form method=get action="../ServletAgregarPersona">
						<fieldset>
							<br>
							<div class="form-group">
								<label for="nombre">Nombre: </label> <input type="text"
									name="nombre" class="form-control" />
							</div>
							<div class="form-group">
								<label for="apellido">Apellido: </label> <input type="text"
									name="apellido" class="form-control" />
							</div>
							<div class="form-group">
								<label for="tipoDni">Tipo DNI: </label> <select name="tipoDni"
									id="tipoDni" class="form-control">
									<option value="DNI">DNI</option>
									<option value="CI">CI</option>
									<option value="LE">LE</option>
									<option value="LC">LC</option>
								</select>
							</div>
							<div class="form-group">
								<label for="dni">N° DNI: </label> <input type="text" name="dni"
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="fecha">Fecha de nacimiento: </label> <input
									type="date" name="fecha" placeholder="dd/mm/aaaa"
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="nombreU">Nombre de usuario:</label> <input
									type="text" name="nombreU" class="form-control" />
							</div>
							<div class="form-group">
								<label for="password">Contraseña:</label> <input type="password"
									name="password" class="form-control">
							</div>
							<div class="form-group">
								<label for="mail">Mail</label>
								</td> <input type="text" name="mail" class="form-control" />
							</div>
							<div class="form-group">
								<button type="reset" value="Resetear" class="btn btn-warning">Resetear</button>
								<button type="submit" value="Ingresar" class="btn btn-info">Finalizar</button>
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


		<jsp:include page="plantillas/plantillaFooter_adminPage.jsp"></jsp:include>
	</section>
</body>
</html>