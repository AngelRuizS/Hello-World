<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/e5ed60d0dd.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Urban Style</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ProductoServlet?accion=home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Ofertas del Dia</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href="ProductoServlet?accion=Principal">Seguir Comprando</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
      </form>
      <div class="dropdown">
           <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
              Secion Iniciada
           </button>
           <div class="dropdown-menu text-center">
              <a class="dropdown-item" href="#">
                 <img src="Imagen/User.jpg" alt="60" width="60">
              </a>
              <a class="dropdown-item" href="#"></a>
              <a class="dropdown-item" href="#">${usuario.getCorreo() }</a>
              <div class="dropdown-divider"></div>
              <form action="ValidarServlet" method="Post">
                 <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button> 
              </form>   
           </div>
      </div>
    </div>
  </div>
</nav>


<div class="container mt-4">
 <h3>Carrito</h3>
  <div class="row">
    <div class="col-sm-8">
       <table class="table table-hover">
          <thead>
             <tr>
                <th>ITEM</th>
                <th>NOMBRE</th>
                <th>DESCRIPCION</th>
                <th>PRECIO</th>
                <th>CANTIDAD</th>
                <th>SUBTOTAL</th>
                <th>ACCION</th>
             </tr>
          </thead>
          <tbody>
             <c:forEach var="car" items="${carrito }">
             <tr>
                <td>${car.getItem() }</td>
                <td>${car.getNombre() }</td>
                <td>${car.getDescripcion() }
                   <img src="Imagen/Item_4.jpg" width="100" height="100">
                </td>
                <td>${car.getPrecio() }</td>
                <td>
                   <input type="hidden" id="idpro" value="${car.getIdProducto()}">
                   <input type="number" id="cantidad" value="${car.getCantidad() }" class="form-control text-center" min="1">
                </td>
                <td>${car.getSubtotal() }</td>
                <td>
                   <input type="hidden" id="idp" value="${car.getIdProducto()}">
                   <a href="ProductoServlet?accion=Delete&idp=${car.getIdProducto()}" id="btnDelete">Eliminar</a>
                   
                </td>
             </tr>
             </c:forEach>
             
          </tbody>
       </table>
    </div>
    <div class="col-sm-4">
       <div class="card">
          <div class="card-header">
             <h3>Generar Compra</h3>
          </div>
          <div class="card-body">
             <label>Subtotal:</label>
             <input type="text" value="PEN ${totalpagar}0" readonly="" class="form-control">
             <label>Descuento:</label>
             <input type="text" readonly="" class="form-control">
             <label>Total a Pagar:</label>
             <input type="text" value="PEN ${totalpagar}0" readonly="" class="form-control"> 
          </div>
          <div class="card-footer">
             <a href="#" class="btn btn-info btn-block">Realizar Pago</a>
             <a href="ProductoServlet?accion=GenerarCompra" class="btn btn-danger btn-block">Generar Compra</a>
          </div>
       </div>
    </div>
  </div>
</div>
     
     
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
     <script src="js/funciones.js" type="text/javascript"></script>
</body>
</html>