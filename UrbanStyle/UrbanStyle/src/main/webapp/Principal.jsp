<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/e5ed60d0dd.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<title>Urban Style</title>


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
          <a class="nav-link" href="ProductoServlet?accion=Carrito" ><i class="fas fa-cart-plus">(<label style="color: darkorange">${producto}</label>)</i>Carrito</a>
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
     <div class="row">
       <c:forEach var="p" items="${productos}">
       <div class="col-sm-4">
         <div class="card">
           <div class="card-header">
             <label>${p.getNombre() }</label>
           </div>
           <div class="card-body">
             <i>PEN.${p.getPrecio() }</i>
             <img src="Imagen/Item_4.jpg" width="200" height="180">
           </div>
           <div class="card-footer text-center">
             <label>${p.getDescripcion()}</label>
             <div>
               <a href="ProductoServlet?accion=AgregarCarrito&id=${p.getId() }" class="btn btn-outline-info">Añadir Carrito</a>
               <a href="ProductoServlet?accion=Comprar&id=${p.getId() }" class="btn btn-danger">Comprar</a>
             </div>
           </div>
         </div>
       </div>
       </c:forEach>

     </div>
   </div>

           

   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>





