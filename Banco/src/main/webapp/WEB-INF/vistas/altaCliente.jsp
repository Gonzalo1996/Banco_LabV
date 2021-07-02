<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:base>
<link rel="stylesheet" href="content/form/form.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@200;400&display=swap" rel="stylesheet">

	
	<h3 class="title-client">Alta cliente:</h3>
	
	<section>
        <div class="container-form">
        <h3>Datos del cliente</h3>
        
        <form action="guardarUsuario.html" method="get">
        <div class="col-form">
          <div class="row-form">
           <br>
            <input name="nombre" type="text" placeholder="Nombre/s"> 
          </div>
          <div class="row-form">
           <br> 
            <input name="apellido" type="text" placeholder="Apellido/s"> 
          </div>
          <div class="row-form date">
           <br>
            <input name="fechaNacimiento" type="date" placeholder="Fecha nacimiento"> 
          </div>
        </div>
        <div class="col-form">
          <div class="row-form">
          <br>
            <input name="dni" type="text" placeholder="DNI"> 
          </div>
          <div class="row-form">
          <br>
            <input name="cuil" type="text" placeholder="CUIL"> 
          </div>
          <div class="row-form">
          <br>
              <select name="genero" id="genero" class="drop-list">
                <option selected class="disabled">Selec. Genero</option>
                <option value="1">Genero 1</option>
                <option value="2">Genero 2</option>
                <option value="3">Genero 3</option>
              </select> 
            </div>
        </div>
        <div class="col-form">

		<div class="row-form">
          <br>
            <select name="provincia" id="prov" class="drop-list">
              <option selected class="disabled">Selec. Provincia</option>
              <option value="1">Prov 1</option>
              <option value="2">Prov 2</option>
              <option value="3">Prov 3</option>
              <option value="4">Prov 4</option>
            </select> 
          </div>
          <div class="row-form">
          <br>
            <select name="localidad" id="localidad" class="drop-list">
              <option selected class="disabled">Selec. Localidad </option>
              <option value="1">Loc 1</option>
              <option value="2">Loc 2</option>
              <option value="3">Loc 3</option>
              <option value="4">Loc 4</option>
            </select>  
          </div>
          <div class="row-form">
          <br>
            <input name="direccion" type="text" placeholder="Direccion"> 
          </div>               
        </div>
        <div class="col-form-correo">
          <div class="row-form">
           <br>
            <input name="correo" type="text" placeholder="Correo"> 
          </div>
          
        <div class="row-form">
			<br>
			 <input name="nombreUsuario" type="text" placeholder="Nombre usuario">
		</div>
		<div class="row-form">
			<br> 
			<input name="contrasenia" type="text" placeholder="Contraseña">
		</div>
          
       </div>

	  <div class="btn-form">
          <button type="submit" class="btn-register">Registrar</button>
        </div>
     </form>
      </div>
  </section>

</t:base>
