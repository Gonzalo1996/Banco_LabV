<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:baseAdmin title="Alta cliente">
<link rel="stylesheet" href="content/form/form.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@200;400&display=swap" rel="stylesheet">

	
	<h3 class="title-client">Alta cliente:</h3>
	
	<section>
        <div class="container-form">
        <h3>Datos del cliente</h3>
        
        <form action="guardarUsuario.html" method="post">
        <div class="col-form">
          <div class="row-form">
           <br>
            <input name="nombre" type="text" placeholder="Nombre/s" required/> 
          </div>
          <div class="row-form">
           <br> 
            <input name="apellido" type="text" placeholder="Apellido/s" required/> 
          </div>
          <div class="row-form date">
           <br>
            <input name="fechaNacimiento" type="date" placeholder="Fecha nacimiento" required/> 
          </div>
        </div>
        <div class="col-form">
          <div class="row-form">
          <br>
            <input name="dni" type="text" placeholder="DNI" required pattern="^[a-z0-9_-]{7,8}$" title="DNI invalido, no debe contener puntos y debe ir de 7 a 8 digitos"> 
          </div>
          <div class="row-form">
          <br>
            <input name="cuil" type="text" placeholder="CUIL"> 
          </div>
          <div class="row-form">
          <br>
			<select name="genero" class="drop-list" required>
			    <option value="" disabled selected>--Seleccione genero--</option>
			        <c:forEach items="${listGeneros}" var="genero" varStatus="status">
			            <option value="${genero.id}"><c:out value="${genero.nombre}"></c:out> </option>
			        </c:forEach>
			</select>
          </div>
        </div>
            
        <!--  AGREGAR SELECT PAIS!!!!!!!!!!!!!!!!!!
                 <div class="row-form">
          <br>
			<select name="genero" class="drop-list">
			    <option value="" disabled selected>--Seleccione genero--</option>
			        <c:forEach items="${listGeneros}" var="genero" varStatus="status">
			            <option value="${genero.id}"><c:out value="${genero.nombre}"></c:out> </option>
			        </c:forEach>
			</select>
          </div> -->
        <div class="col-form">

		<div class="row-form">
          <br>
			<select id="provincia" name="provincia" class="drop-list" required>
			    <option value="" disabled selected>--Seleccione provincia--</option>
			        <c:forEach items="${listProvincias}" var="provincia" varStatus="status">
			            <option value="${provincia.id}"><c:out value="${provincia.nombre}"></c:out> </option>
			        </c:forEach>
			</select>
          </div>
          <div class="row-form">
          <br>
			<select id="localidad" name="localidad" class="drop-list" required>
			    <option value="" disabled selected>--Seleccione localidad--</option>
			        <c:forEach items="${listLocalidades}" var="localidad" varStatus="status">
			            <option value="${localidad.id}"><c:out value="${localidad.nombre}"></c:out> </option>
			        </c:forEach>
			</select>
          </div>
          <div class="row-form">
          <br>
            <input name="direccion" type="text" placeholder="Direccion" required/> 
          </div>               
        </div>
        <div class="col-form-correo">
          <div class="row-form">
           <br>
            <input name="correo" type="text" placeholder="Correo" required pattern="^[^@]+@[^@]+\.[a-zA-Z]{2,}$" title="Correo invalido, debe contener un @ y como minimo un punto."> 
          </div>
          
        <div class="row-form">
			<br>
			 <input name="nombreUsuario" type="text" placeholder="Nombre usuario" required/>
		</div>
		<div class="row-form">
			<br> 
			<input name="contrasenia" type="password" placeholder="Contraseña"  required/>
		</div>
          
       </div>

	  <div class="btn-form">
          <button type="submit" class="btn-register">Registrar</button>
        </div>
     </form>
      </div>
  </section>

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
</script>
</t:baseAdmin>
