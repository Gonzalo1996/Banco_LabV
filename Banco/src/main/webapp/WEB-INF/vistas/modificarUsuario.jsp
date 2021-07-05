<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!-- Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@100&display=swap" rel="stylesheet">

<t:base>
	<div class="container-fluid">
		<div class="row">
	     		<div class="col-md-12">
					<h3 style="font-family: 'Barlow', sans-serif">Modificar datos cliente:</h3>				
				</div>
	   	</div>
		<br>
		
			<div class="row">
			<div class="col-md-10">
				<form method="POST" action="x">
				
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="name">Nombre:</label>
						    <div class="col-sm-10">
								<input name="nombre" id="name" type="text" class="form-control" placeholder="Nombre">
   							 </div>
					</div>
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="surname">Apellido:</label>
						    <div class="col-sm-10">
								<input name="apellido" id="surname" type="text" class="form-control" placeholder="Apellido">
   							 </div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="email">Correo:</label>
						    <div class="col-sm-10">
								<div class="input-group mb-3">
								  <input name="Correo"  id="email" type="email" class="form-control" placeholder="Correo" >
								  <div class="input-group-append">
								    <span class="input-group-text">
								    	<i class="fa fa-envelope"></i>
								    </span>
								  </div>
								</div>
   							 </div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="email">Dirección:</label>
						    <div class="col-sm-10">
								<div class="input-group mb-3">
								  <input name="Correo"  id="email" type="text" class="form-control" placeholder="Dirección" >
								  <div class="input-group-append">
								    <span class="input-group-text">
								    	<i class="fa fa-map-marker"></i>
								    </span>
								  </div>
								</div>
   							 </div>
					</div>
				  
				<div class="form-group">
				        <label for="">Seleccionar:</label>
				        <div class="input-group">
							<select class="btn btn-outline-secondary col-md-2">
								<option>País</option>
								<option>Argentina</option>
								<option>Uruguay</option>										
							</select>
				        
							<span class="input-group-addon" style="color: white">-</span>    
							<select class="btn btn-outline-secondary col-md-2">
								<option>Provincia</option>
								<option>Buenos aires</option>
								<option>Punta del este</option>										
							</select>
							
							<span class="input-group-addon" style="color: white">-</span>    
				  			<select class="btn btn-outline-secondary col-md-2">
								<option>Localidad</option>
								<option>Pacheco</option>
								<option>La playa</option>										
							</select>
							
							<span class="input-group-addon" style="color: white">-</span>    
				  			<select class="btn btn-outline-secondary col-md-2">
								<option>Estado</option>
								<option>Activo</option>
								<option>Inactivo</option>										
							</select>        
						</div>
			</div>
				<div class="row">
					<div class="col-md-2">
						<button type="submit" class="btn btn-primary">
							Modificar <span class="fa fa-pencil"></span>
						</button>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>

</t:base>
      
<script src="content/dataTable/jquery/jquery-3.3.1.min.js"></script>
<script src="content/dataTable/popper/popper.min.js"></script>
<script src="content/dataTable/bootstrap/js/bootstrap.min.js"></script>