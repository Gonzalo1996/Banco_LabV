<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:baseUsuario title="Cuenta">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@100&display=swap" rel="stylesheet">

<div class="card">
	 <div class="card-header">
	    <h4 style="font-family: 'Barlow', sans-serif">Cuenta: ${nroCuenta}
	     <a href="cuentasCliente.html" class="btn btn-primary float-right" role="button">
	     <span class="fa fa-arrow-left"></span>
	      Volver
	     </a></h4>
	 	CBU: ${nroCbu}
	 </div>
	 
	 <div class="card-body">
	    <h3 class="card-title">Movimientos <b class="float-right">Saldo: $ ${saldo}</b></h3>
	    
<div class="row">
         <div class="col-md-12">
             <div class="table-responsive">        
                 <table id="example" class="table table-hover table-bordered" style="width:100%">
                 <thead>
                     <tr>
						<th>Fecha</th>
						<th>Descripción</th>
						<th>Importe</th>
						<th>Saldo Total</th>
                     </tr>
                 </thead>
                 <tbody>
						<c:forEach items="${listMovimientos}" var="m">
							<tr>
								<td>${m.fecha}</td>
								<td>${m.detalle}</td>
								<td>${m.monto}</td>						
								<td>${m.saldo}</td>
								</tr>
						</c:forEach>                      
                 </tbody>        
                </table>                  
             </div>
         </div>
 </div>

	 </div>
</div>

	
</t:baseUsuario>

    <script src="content/dataTable/jquery/jquery-3.3.1.min.js"></script>
    <script src="content/dataTable/popper/popper.min.js"></script>
    <script src="content/dataTable/bootstrap/js/bootstrap.min.js"></script>
      
    <!-- datatables JS -->
    <script type="text/javascript" src="content/dataTable/datatables/datatables.min.js"></script>    
    <script type="text/javascript" src="content/dataTable/main.js"></script> 

<footer  style="width:100%; margin-left: 0px;"  >
<div class="copyright" style="background-color: #0d47a1;">
    <div class="container-fluid" style="background-color: #0d47a1; color: #bbdefb;">
        ©  Copyright: BANCO UTN - 2021
    </div>
</div>
</footer>