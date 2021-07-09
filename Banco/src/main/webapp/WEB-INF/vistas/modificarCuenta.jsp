<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!-- Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@100&display=swap" rel="stylesheet">

<t:baseAdmin>
	<div class="container-fluid">
		<div class="row">
	     		<div class="col-md-12">
					<h3 style="font-family: 'Barlow', sans-serif">Modificar cuenta:</h3>				
				</div>
	   	</div>
		<br>
		
			<div class="row">
			<div class="col-md-10">
				<form action="guardarCuentaModificada.html" method="post">
				
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="name">Nro. Cuenta:</label>
						    <div class="col-sm-10">
								<input name="nroCuenta" id="name" type="text" class="form-control"  value="${cuenta.nroCuenta}" readonly>
   							 </div>
					</div>
				
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="name">Nombre:</label>
						    <div class="col-sm-10">
								<input name="nombre" id="name" type="text" class="form-control" value="${cuenta.nombreCuenta}" placeholder="Nombre">
   							 </div>
					</div>

					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="dni">DNI:</label>
						    <div class="col-sm-10">
								<div class="input-group mb-3">
								  <input name="dni"  id="dni" type="text" class="form-control" value="${cuenta.cliente.dni}" placeholder="DNI" required pattern="^[a-z0-9_-]{7,8}$" title="DNI invalido, no debe contener puntos y debe ir de 7 a 8 digitos" required/>
								  <div class="input-group-append">
								    <span class="input-group-text">
								    	<i class="fa fa-id-card"></i>
								    </span>
								  </div>
								</div>
   							 </div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="alias">Alias:</label>
						    <div class="col-sm-10">
								<div class="input-group mb-3">
								  <input name="alias"  id="alias" type="text" class="form-control"  value="${cuenta.alias}" placeholder="Alias" >
								  <div class="input-group-append">
								    <span class="input-group-text">
								    	<i class="fa fa-university"></i>
								    </span>
								  </div>
								</div>
   							 </div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-1 col-form-label" for="estate">Estado:</label>
						    <div class="col-sm-10">
								<select name="estado" class="btn btn-outline-secondary col-md-2">							 

								 <c:choose>
									<c:when test="${cuenta.estado ==true}">					
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
</t:baseAdmin>

    <c:if test="${!empty error}">
	    <script>
			Swal.fire({
			  icon: 'error',
			  title: 'Ups...',
			  text: '${error}',
			});
		</script>
	</c:if>
     
<script src="content/dataTable/jquery/jquery-3.3.1.min.js"></script>
<script src="content/dataTable/popper/popper.min.js"></script>
<script src="content/dataTable/bootstrap/js/bootstrap.min.js"></script>