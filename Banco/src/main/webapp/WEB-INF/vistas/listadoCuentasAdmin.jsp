<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:base>
	<link rel="stylesheet" type="text/css" href="content/dataTable/datatables/datatables.min.css"/>
    <link rel="stylesheet"  type="text/css" href="content/dataTable/datatables/DataTables-1.10.18/css/dataTables.bootstrap4.min.css">
	
	<!-- Fonts -->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@100&display=swap" rel="stylesheet">
	
 <div class="container"> 
	<div class="row">
		<div class="col-md-12">
			<h3 style="font-family: 'Barlow', sans-serif">Listado de cuentas:</h3>				
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<form method="get" action="x">
				<div class="form-group row">
						<label class="col-md-1 col-form-label" for="txtCuil">CUIL:</label>
						<div class="col-sm-12 col-md-4">
							<input id="txtCuil" type="text" class="form-control" placeholder="CUIL">
						</div>
					
					<div class="col-md-4">
						<button type="submit" class="btn btn-primary">Filtrar <span class="fa fa-filter"></span></button>
						<button type="submit" class="btn btn-info">Quitar <span class="fa fa-times"></span></button>				
					</div>
				</div>
					  
				<div class="form-group row">
					<label class="col-md-1 col-form-label" for="txtMoneda" >Tipo cuenta:</label>
					<div class="col-xs-12 col-md-4">
					 	 <!--<input id="txtMoneda" type="text" class="form-control" placeholder="Tipo cuenta">   -->	
 						<div class="dropdown ">
						  <button class="btn btn-outline-info  dropdown-toggle btn-md" style="width: 100%" type="submit"  id="ddpTipoCuenta" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Tipo de cuenta
						  </button>
						  <div class="dropdown-menu" aria-labelledby="ddpTipoCuenta">
						    <a class="dropdown-item" href="#">Peso</a>
						    <a class="dropdown-item" href="#">Dolar</a>
						  </div>
						</div>	 	 		 	 		 	 						
					</div>
				
				<div class="col-md-4">
					<button type="submit" class="btn btn-primary">Filtrar <span class="fa fa-filter"></span></button>
				    <button type="submit" class="btn btn-info">Quitar <span class="fa fa-times"></span></button>							
				</div>
				</div>
			</form>			
		</div>
	</div>
	
   <div class="row">
         <div class="col-md-12">
             <div class="table-responsive">        
                 <table id="example" class="table table-hover table-bordered" style="width:100%">
                 <thead>
                     <tr>
						<th>Cuenta</th>
						<th>CBU</th>
						<th>Alias</th>
						<th>Moneda</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Monto</th>
						<th>Editar</th>
						<th>Bloquear</th>
                     </tr>
                 </thead>
                 <tbody>
                 
                     <tr>
						<td>088-3863/4</td>
						<td>0720088511</td>
						<td>batman.robin.dc</td>
						<td>Peso</td>
						<td>Mauricio</td>
						<td>Molina</td>
						<td>5000</td>								
						<td><button type="submit" class="btn btn-primary"><span class="fa fa-pencil"></span></button></td>
						<td><button type="submit" class="btn btn-info"><span class="fa fa-ban"></span></button></td>
                     </tr>                       
                  
                     <tr>
						<td>088-3863/4</td>
						<td>07100118</td>
						<td>gato.perro.sapo</td>
						<td>Peso</td>
						<td>Juan</td>
						<td>Gonzalez</td>
						<td>1331</td>
						<td><button type="submit" class="btn btn-primary"><span class="fa fa-pencil"></span></button></td>
						<td><button type="submit" class="btn btn-info"><span class="fa fa-ban"></span></button></td>
                     </tr>

                     <tr>
						<td>088-3863/4</td>
						<td>07270111</td>
						<td>boca.grande.primera</td>
						<td>Dolar</td>
						<td>Gonza</td>
						<td>Alderete</td>
						<td>9000</td>
						<td><button type="submit" class="btn btn-primary"><span class="fa fa-pencil"></span></button></td>
						<td><button type="submit" class="btn btn-info"><span class="fa fa-ban"></span></button></td>
                     </tr>
                     <tr>
						<td>087-3863/4</td>
						<td>07270221</td>
						<td>river.nacional.b</td>
						<td>Peso</td>
						<td>Jose</td>
						<td>Rodriguez</td>
						<td>25000</td>
						<td><button type="submit" class="btn btn-primary"><span class="fa fa-pencil"></span></button></td>
						<td><button type="submit" class="btn btn-info"><span class="fa fa-ban"></span></button></td>
                     </tr>
                     
                      <tr>
						<td>081-3863/4</td>
						<td>02273111</td>
						<td>windows.pirata.siempre</td>
						<td>Dolar</td>
						<td>Marcos</td>
						<td>Vera</td>
						<td>30000</td>
						<td><button type="submit" class="btn btn-primary"><span class="fa fa-pencil"></span></button></td>
						<td><button type="submit" class="btn btn-info"><span class="fa fa-ban"></span></button></td>
                     </tr>
                 </tbody>        
                </table>                  
             </div>
         </div>
 </div>
 
</div>
	
</t:base>

    <script src="content/dataTable/jquery/jquery-3.3.1.min.js"></script>
    <script src="content/dataTable/popper/popper.min.js"></script>
    <script src="content/dataTable/bootstrap/js/bootstrap.min.js"></script>
      
    <!-- datatables JS -->
    <script type="text/javascript" src="content/dataTable/datatables/datatables.min.js"></script>    
    <script type="text/javascript" src="content/dataTable/main.js"></script>  
