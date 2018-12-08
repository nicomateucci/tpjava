<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Usuario"%>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de sesion</title>

<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="../css/loginstyles.css">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Identificarme</h3>
					<div class="d-flex justify-content-end social_icon">
						<span><i class="fab fa-facebook-square"></i></span> <span><i
							class="fab fa-google-plus-square"></i></span> <span><i
							class="fab fa-twitter-square"></i></span>
					</div>
				</div>
				<div class="card-body">
					<form method=get action="../ServletLogin">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>

							<%
								ArrayList<Usuario> uu = (ArrayList<Usuario>) request.getSession().getAttribute("listaUsuarios");
								if (!(uu == null || uu.isEmpty())) {
							%>
							<datalist id="usuarios">
								<%
									for (Usuario u : uu) {
								%>
								<option value="<%=u.getNombreUsuario()%>"
									label="<%=u.getNombreUsuario()%>"></option>
								<%
									}
								%>
							</datalist>
							<%
								}
							%>
							<input type="text" name="textUsuario" class="form-control"
								placeholder="nombre de usuario" list="usuarios">
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>

							<!-- Tuve que sacar el type="contraseña" porque el servidor en jelastic no tiene -->
							<!--  //habilitada la opcion de usar SSH, SOLO PARA CUENTAS PREMIUM.-->
							<!--  
							<input type="password" class="form-control" name="textContrasena"
								placeholder="contraseña">-->
							<input type="text" class="form-control" name="textContrasena"
								placeholder="contraseña">
						</div>
						<%
							String m = (String) request.getSession().getAttribute("mensaje");
							if (m != null) {
						%>
						<div style="color: red">
							<i><%=m%></i>
						</div>

						<%
							}
						%>
						<div class="form-group">
							<input type="checkbox" name="checkRecordarme"><span
								style="color: white"> Recordame !</span> <input type="submit"
								value="Ingresar" name="btnIngresar"
								class="btn float-right login_btn">
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Es tu primera vez? <a href="agregarCliente.jsp">Registráte!</a>
					</div>
					<div class="d-flex justify-content-center">
						<a href="">Olvidaste algo? Nos gustaría ayudarte</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
