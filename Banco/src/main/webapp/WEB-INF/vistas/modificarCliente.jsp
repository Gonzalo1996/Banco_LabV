<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!-- Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@100&display=swap"
	rel="stylesheet">

<t:baseAdmin title="Modificar cliente">

	<div class="container-fluid">

		<div class="row">
			<div class="col-md-12">
				<h3 style="font-family: 'Barlow', sans-serif">Modificar datos
					cliente:</h3>
			</div>
		</div>
		<br>

		<div class="row">
			<div class="col-md-10">

				<form action="guardarClienteModificado.html" method="post">

					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="dni">DNI:</label>
						<div class="col-sm-10">
							<input name="dni" id="dni" type="text" class="form-control"
								value="${cliente.dni}" readonly>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="nombre">Nombre:</label>
						<div class="col-sm-10">
							<input name="nombre" id="name" type="text" class="form-control"
								value="${cliente.nombre}" required/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="apellido">Apellido:</label>
						<div class="col-sm-10">
							<input name="apellido" id="surname" type="text"
								class="form-control" value="${cliente.apellido}" required/>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="fecha">Fecha
							nacimiento:</label>
						<div class="col-sm-10">
							<input name="fecha" id="fecha" type="date" class="form-control"
								value="${fecha}" required/>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="correo">Correo:</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input name="correo" id="email" type="email" 
								 	class="form-control" value="${cliente.correo}" required pattern="^[^@]+@[^@]+\.[a-zA-Z]{2,}$" title="Correo invalido, debe contener un @ y como minimo un punto.">
								<div class="input-group-append">
									<span class="input-group-text"> <i
										class="fa fa-envelope"></i>
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="direccion">Dirección:</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input name="direccion" id="text" type="text"
									class="form-control" value="${cliente.direccion}" required/>
								<div class="input-group-append">
									<span class="input-group-text"> <i
										class="fa fa-map-marker"></i>
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="pais">Nacionalidad:</label>
						<div class="col-md-10">
							<select id="pais" name="pais" class="form-control" required>
							        <c:forEach items="${listPaises}" var="pais" varStatus="status">
							            <option value="${pais.id}"><c:out value="${pais.nombre}"></c:out> </option>
							        </c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="provincia">Provincia:</label>
						<div class="col-md-10">
							<select id="provincia" name="provincia" class="form-control" required>
								<c:forEach items="${listProvincias}" var="provincia"
									varStatus="status">
									<option value="${provincia.id}"
										${provincia.id == cliente.provincia.id ? 'selected' : ''}>${provincia.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="localidad">Localidad:</label>
						<div class="col-md-10">
							<select id="localidad" name="localidad" class="form-control" required>
								<c:forEach items="${listLocalidades}" var="localidad"
									varStatus="status">
									<option value="${localidad.id}"
										${localidad.id == cliente.localidad.id ? 'selected' : ''}>${localidad.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="estado">Estado:</label>
						<div class="col-md-10">
							<select name="estado" class="form-control">
								<c:choose>
									<c:when test="${cliente.usuario.estado == true}">
										<option value="1">Activo</option>
										<option value="0">Inactivo</option>
									</c:when>
									<c:otherwise>
										<option value="0">Inactivo</option>
										<option value="1">Activo</option>
									</c:otherwise>
								</c:choose>
							</select>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="direccion">Contraseña:</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input name="contrasenia" id="contrasenia" type="password"
									class="form-control" value="${cliente.usuario.contrasenia}" required/>
								<div class="input-group-append">
							  		<button class="btn btn-info" type="button" onclick="mostrarPassword()">
							  			<span class="fa fa-eye-slash icon"></span>
							  		</button>
								</div>
							</div>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label" for="user">Nombre usuario:</label>
						<div class="col-sm-10">
							<div class="input-group">
								<input name="nombreUsuario" id="user" type="password"
									class="form-control" value="${cliente.usuario.nombreUsuario}" required/>
								<div class="input-group-append">
							  		<button class="btn btn-info" type="button" onclick="mostrarPassword2()">
							  			<span class="fa fa-eye-slash icon"></span>
							  		</button>
								</div>
							</div>
						</div>
					</div>

					<div class="form-group row">
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

<script>
$(function(){
	$('#provincia').change(function(e){
		var data = {
			idProvincia: parseInt(this.value)
		};
   		
        $.ajax({
            url: './getLocalidadesPorProvincia.html',
            type: 'GET',
            data: data,
            dataType: 'json',
            success: function (response) {                                
                var options = '';
                $.each(response, function(key, value) {
                    options += "<option value='"+value.id+"'>"+value.nombre+"</option>";
                });
                
                $('#localidad')
                	.empty()
                	.append(options);
            },
            error: function(xhr, ajaxOptions, thrownError) {
            	var errorMsg = 'Error ' + xhr.status + '\r\n' + xhr.responseText;
                alert(errorMsg);
            }
        });
        
	});
});

function mostrarPassword(){
	var cambio = document.getElementById("contrasenia");
	if(cambio.type == "password"){
		cambio.type = "text";
		$('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
	}else{
		cambio.type = "password";
		$('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
	}
} 


function mostrarPassword2(){
	var cambio = document.getElementById("user");
	if(cambio.type == "password"){
		cambio.type = "text";
		$('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
	}else{
		cambio.type = "password";
		$('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
	}
} 
</script>

</t:baseAdmin>
