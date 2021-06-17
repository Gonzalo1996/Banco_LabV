<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:base>

<div class="container">	
	<div class="row">
		<div class="col-md-12">
		<form method="get" action="x">
		<div class="form-group row">
				<label class="col-md-1 col-form-label" for="txtNombre" >Nombre:</label>
				<div class="col-md-4">
					<input id="txtNombre" type="text" class="form-control" placeholder="Nombre">
				</div>
		
			<div class="col-md-4">
				<button type="submit" class="btn btn-primary">Filtrar <span class="fa fa-filter"></span></button>
				<button type="submit" class="btn btn-info">Quitar <span class="fa fa-times"></span></button>				
'			</div>
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
		<div class="col-md-11">
			<table class="table table-bordered table-hover table-responsive">
					<tr class="table-primary">
						<th>Nombre</th>
						<th>Apellido</th>
						<th>DNI</th>
						<th>CUIL</th>
						<th>Localidad</th>
						<th>Dirección</th>
						<th>Telefono</th>
						<th>Editar</th>
						<th>Borrar</th>
					</tr>
					<tr>
						<td>Gonzalo</td>
						<td>Alderete</td>
						<td>410001</td>
						<td>20413333</td>
						<td>Garin</td>
						<td>Calle falsa 123</td>
						<td>1132724000</td>
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
						<td>1132724000</td>
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
						<td>1132724000</td>
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
						<td>1132724000</td>
						<td><button type="submit" class="btn btn-primary"><span class="fa fa-pencil"></span></button></td>
						<td><button type="submit" class="btn btn-info"><span class="fa fa-trash"></span></button></td>
					</tr>									
			</table>
		</div>
	</div>
</div>

<div class="container-fluid">
	  <ul class="pagination">
	    <li class="page-item">
	      <a class="page-link" href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <li class="page-item"><a class="page-link" href="#">1</a></li>
	    <li class="page-item"><a class="page-link" href="#">2</a></li>
	    <li class="page-item"><a class="page-link" href="#">3</a></li>
	    <li class="page-item">
	      <a class="page-link" href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
</div>

</t:base>