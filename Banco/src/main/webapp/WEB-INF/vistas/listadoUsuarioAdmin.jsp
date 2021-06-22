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
				<h3 style="font-family: 'Barlow', sans-serif">Listado de usuarios:</h3>				
			</div>
     	</div>
     
   	<div class="row">
		<div class="col-md-12">
		
		<form method="get" action="x">
			<div class="form-group row">
					<label class="col-md-1 col-form-label" for="txtLocalidad">Localidad:</label>
					<div class="col-md-4">
						<input id="txtLocalidad" type="text" class="form-control" placeholder="Localidad">
					</div>
			
				<div class="col-md-4">
					<button type="submit" class="btn btn-primary">Filtrar <span class="fa fa-filter"></span></button>
					<button type="submit" class="btn btn-info">Quitar <span class="fa fa-times"></span></button>				
				</div>
			</div>
			  
		<div class="form-group row">
			<label class="col-md-1 col-form-label" for="txtDni" >DNI:</label>
			<div class="col-md-4">
			 	<input id="txtDni" type="text" class="form-control" placeholder="DNI">
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
								<th>Nombre</th>
								<th>Apellido</th>
								<th>DNI</th>
								<th>CUIL</th>
								<th>Localidad</th>
								<th>Dirección</th>
								<th>Correo</th>
								<th>Editar</th>
								<th>Borrar</th>
                            </tr>
                        </thead>
                        <tbody>
                        
                            <tr>
								<td>Gonzalo</td>
								<td>Alderete</td>
								<td>410001</td>
								<td>20413333</td>
								<td>Garin</td>
								<td>Calle falsa 123</td>
								<td>gonza@gmail.com</td>
								<td><button type="submit" class="btn btn-primary"><span class="fa fa-pencil"></span></button></td>
								<td><button type="submit" class="btn btn-info"><span class="fa fa-trash"></span></button></td>
                            </tr>                       
                         
                            <tr>
								<td>Marcos</td>
								<td>Vera</td>
								<td>430101</td>
								<td>204301015</td>
								<td>Don torcuato</td>
								<td>Calle falsa 456</td>
								<td>marcos@gmail.com</td>
								<td><button type="submit" class="btn btn-primary"><span class="fa fa-pencil"></span></button></td>
								<td><button type="submit" class="btn btn-info"><span class="fa fa-trash"></span></button></td>
                            </tr>

                            <tr>
								<td>Mauricio</td>
								<td>Molina</td>
								<td>40184763</td>
								<td>204018015</td>
								<td>José c paz</td>
								<td>Calle falsa 768</td>
								<td>mauricio@gmail.com</td>
								<td><button type="submit" class="btn btn-primary"><span class="fa fa-pencil"></span></button></td>
								<td><button type="submit" class="btn btn-info"><span class="fa fa-trash"></span></button></td>
                            </tr>
                            <tr>
								<td>Juan</td>
								<td>Gonzalez</td>
								<td>42184763</td>
								<td>20421847635</td>
								<td>San miguel</td>
								<td>Calle falsa 678</td>
								<td>juan@gmail.com</td>
								<td><button type="submit" class="btn btn-primary"><span class="fa fa-pencil"></span></button></td>
								<td><button type="submit" class="btn btn-info"><span class="fa fa-trash"></span></button></td>
                            </tr>
                            
                             <tr>
								<td>Jose</td>
								<td>Rodriguez</td>
								<td>41184763</td>
								<td>20421847635</td>
								<td>San miguel</td>
								<td>Calle falsa 123</td>
								<td>jose@gmail.com</td>
								<td><button type="submit" class="btn btn-primary"><span class="fa fa-pencil"></span></button></td>
								<td><button type="submit" class="btn btn-info"><span class="fa fa-trash"></span></button></td>
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