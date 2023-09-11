/**
 * 
 */
$(document).ready(function(){
	$("tr #btnDelete").click(function(){
		var idp=$(this).parent().find("#idp").val();
		swal({
         title: "Esta Seguro de Eliminar?",
         text: "Once deleted, Ud puede agregar de nuevo!",
         icon: "warning",
         buttons: true,
         dangerMode: true,
       }).then((willDelete) => {
                  if (willDelete) {
			          eliminar(idp);
                      swal("Poof! Your imaginary file has been deleted!", {
                      icon: "success",
                     }).then((willDelete)=>{
			                  if(willDelete){
				               parent.location.href="ProductoServlet?accion=Carrito";
			                 }  
		                   });
                           } else {
                              swal("Registro no eliminado!");
                           }
                         });
		
	});
	function eliminar(idp){
		var url="ProductoServlet?accion=Delete";
		$.ajax({
			type : 'POST',
			url : url,
			data : "idp="+idp,
			success: function(data,textStatus,jqXHR){
			}
		})
	}
	
	$("tr #cantidad").click(function(){
		var idp=$(this).parent().find("#idpro").val();
		var cantidad=$(this).parent().find("#cantidad").val();
		var url ="ProductoServlet?accion=ActualizarCantidad";
		$.ajax({
			type : 'POST',
			url:url,
			data:"idp=" + idp + "&cantidad=" + cantidad,
			success: function(data,textStatus,jqXHR){
					location.href="ProductoServlet?accion=Carrito"
			}
		});
	});
});