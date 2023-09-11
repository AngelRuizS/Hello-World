<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script src="https://kit.fontawesome.com/e5ed60d0dd.js"></script>
<link href="CSS/Registro_y_Login.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<form class = "formulario" action="ValidarServlet" method="post" >

<h1>Iniciar Sesion</h1>
<div class="contenedor">

<div class="input-contenedor">
<i class="fa-solid fa-envelope icon"></i>
<input type="text" placeholder="Correo Electronico" name="txtcorreo">
</div>

<div class="input-contenedor">
<i class="fa-solid fa-key icon"></i>
<input type="password" placeholder="Contraseña" name="txtcontra">
</div>
<input  type="submit" name="accion" value="Ingresar" class="button">
<p>Al registrarte, aceptas nuestras Condiciones de uso y Politica de privacidad.</p>

<p>¿No tienes Cuenta?<a class="link" href="registro.jsp">Registrarse</a></p>

</div>

</form>

</body>
</html>