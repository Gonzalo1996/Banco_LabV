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
				<form action="guardarClienteModificado.html" method="post">
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="dni">DNI:</label>
						    <div class="col-sm-10">
								<input name="dni" id="dni" type="text" class="form-control" value="${cliente.dni}" readonly>
   							 </div>
					</div>
				
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="name">Nombre:</label>
						    <div class="col-sm-10">
								<input name="nombre" id="name" type="text" class="form-control" value="${cliente.nombre}">
   							 </div>
					</div>
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="surname">Apellido:</label>
						    <div class="col-sm-10">
								<input name="apellido" id="surname" type="text" class="form-control" value="${cliente.apellido}">
   							 </div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="surname">Fecha nac:</label>
						    <div class="col-sm-10">
								<input name="fecha" id="fecha" type="date" class="form-control" value="${fecha}">
   							 </div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="email">Correo:</label>
						    <div class="col-sm-10">
								<div class="input-group mb-3">
								  <input name="correo"  id="email" type="email" class="form-control" value="${cliente.correo}" >
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
								  <input name="direccion"  id="text" type="text" class="form-control" value="${cliente.direccion}" >
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
							<select name="pais" class="btn btn-outline-secondary col-md-2">
								<option value="1">Nacionalidad</option>									
							</select>
				        
							<span class="input-group-addon" style="color: white">-</span>    
						<select name="provincia" class="btn btn-outline-secondary col-md-3" required>
						    <option value="" disabled selected>Seleccione provincia</option>
						        <c:forEach items="${listProvincias}" var="provincia" varStatus="status">
						            <option value="${provincia.id}"><c:out value="${provincia.nombre}"></c:out> </option>
						        </c:forEach>
						</select>
						
						<span class="input-group-addon" style="color: white">-</span>    							
						<select name="localidad" class="btn btn-outline-secondary col-md-3" required>
						    <option value="" disabled selected>Seleccione localidad</option>
						        <c:forEach items="${listLocalidades}" var="localidad" varStatus="status">
						            <option value="${localidad.id}"><c:out value="${localidad.nombre}"></c:out> </option>
						        </c:forEach>
						</select>
							
							<span class="input-group-addon" style="color: white">-</span>    
				  			<select name="estado" class="btn btn-outline-secondary col-md-2">
								 <c:choose>
									<c:when test="${cliente.usuario.estado == true}">					
										<option value="1">Activa</option>
										<option value="0">Inactiva</option>
									</c:when>
									<c:otherwise>
										<option value="0">Inactiva</option>
										<option value="1">Activa</option>										
									</c:otherwise>
								</c:choose>											
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