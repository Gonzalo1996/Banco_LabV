<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<title>Banco UTN</title>
<t:baseUsuario>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@100&display=swap" rel="stylesheet">

<div class="card">
	 <div class="card-header">
	    <h4 style="font-family: 'Barlow', sans-serif">Cuenta: 246-6666666-1 <a href="cuentasCliente.jsp" class="btn btn-primary float-right" role="button">Volver</a></h4>
	 	CBU: 0246666666610012
	 </div>
	 
	 <div class="card-body">
	    <h5 class="card-title">Movimientos</h5>
	    
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
						<th></th>
                     </tr>
                 </thead>
                 <tbody>
                     <tr>
						<td>10/06/2021</td>
						<td>Extracción</td>
						<td>-$ 1.500,00</td>
						<td>$ 5.000,00</td>							
						<td><button type="submit" class="btn btn-primary">Ver</button></td>
                     </tr>                       
                     <tr>
						<td>30/05/2021</td>
						<td>Compra Visa Débito</td>
						<td>-$ 2.000,00</td>
						<td>$ 6.500,00</td>							
						<td><button type="submit" class="btn btn-primary">Ver</button></td>
                     </tr> 
                    <tr>
						<td>19/05/2021</td>
						<td>Pago de Servicios</td>
						<td>-$ 1.500,00</td>
						<td>$ 8.500,00</td>							
						<td><button type="submit" class="btn btn-primary">Ver</button></td>
                     </tr> 
                     <tr>
						<td>16/01/2021</td>
						<td>Apertura Cuenta</td>
						<td>$ 10.000,00</td>
						<td>$ 10.000,00</td>							
						<td><button type="submit" class="btn btn-primary">Ver</button></td>
                     </tr> 
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