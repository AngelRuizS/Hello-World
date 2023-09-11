<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/e5ed60d0dd.js"></script>
<link href="CSS/Registro_y_Login.css" rel="stylesheet" type="text/css"/>
<title>Registro</title>
</head>
<body>

<form class = "formulario" action="RegistrServlet" method="post" >

<h1>Registro</h1>
<div class="contenedor">

<div class="input-contenedor">
<i class="fa-regular fa-id-card icon"></i>
<input type="text" placeholder="Documento de Identidad" name="txtdni">
</div>

<div class="input-contenedor">
<i class="fa-solid fa-user icon"></i>
<input type="text" placeholder="Nombres y Apellidos" name="txtnomape">
</div>

<div class="input-contenedor">
<i class="fa-solid fa-envelope icon"></i>
<input type="text" placeholder="Correo Electronico" name="txtcorreo">
</div>

<div class="input-contenedor">
<i class="fa-solid fa-key icon"></i>
<input type="password" placeholder="Contraseña" name="txtcontra">
</div>
<input type="submit" value="Registrar" class="button" >
<p>Al registrarte, aceptas nuestras Condiciones de uso y Politica de privacidad.</p>

<p>¿Ya tienes cuenta?<a class="link" href="login.jsp">Iniciar Sesion</a></p>

</div>

</form>

</body>
</html>