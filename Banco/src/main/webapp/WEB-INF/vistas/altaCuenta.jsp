<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:base>
<link rel="stylesheet" href="content/form/form-cuenta.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@200;400&display=swap" rel="stylesheet">

	<c:if test="${!empty error}">
		<span>${error}</span>
	</c:if>	

	<h3 class="title-client">Alta cuentas</h3>
	
	
	<section class="section-mov">
    <div class="container-form mov">
      <h3>Nueva Cuenta</h3>
      
      <form action="guardarCuenta.html" method="post">
      <div class="col-form">
        <div class="row-form">
         <br>
          <input name="cbu" type="text" placeholder="CBU"> 
        </div>
        <div class="row-form">
         <br> 
          <input name="alias" type="text" placeholder="Alias"> 
        </div>
        <div class="row-form date">
         <br>
          <input name="fecha" type="date" placeholder="Fecha creación">  
        </div>
      </div>
      <div class="col-form">
        <div class="row-form">
        <br>
          <input name="dni" type="text" placeholder="DNI cliente"> 
        </div>
        <!--
        <div class="row-form">
        <br>
          <input type="text" placeholder="CUIL"> 
        </div>
        -->
        <div class="row-form">
        <br>
            <select name="moneda" id="moneda" class="drop-list">
              <option value="1">Pesos</option>
              <option value="2">Dolares</option>
            </select> 
          </div>
      </div>
 
      <div class="btn-form">
        <button type="submit" class="btn-register">Registrar</button>
      </div>  </form>
    </div>

   <!--
      <div class="container-form">
        <h2>Datos del cliente</h2>
        <form action="">
        <div class="col-form">
          <div class="row-form">
           <br>
            <input type="text" placeholder="Nombre/s"> 
          </div>
          <div class="row-form">
           <br> 
            <input type="text" placeholder="Apellido/s"> 
          </div>
          <div class="row-form date">
           <br>
            <input  type="date" placeholder="Fecha nacimiento"> 
          </div>
        </div>
        <div class="col-form">
          <div class="row-form">
          <br>
            <input type="text" placeholder="DNI"> 
          </div>
          <div class="row-form">
          <br>
            <input type="text" placeholder="CUIL"> 
          </div>
          <div class="row-form">
          <br>
              <select name="prov" id="prov" class="drop-list">
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
            <select name="prov" id="prov" class="drop-list">
              <option selected class="disabled">Selec. Provincia</option>
              <option value="1">Prov 1</option>
              <option value="2">Prov 2</option>
              <option value="3">Prov 3</option>
              <option value="4">Prov 4</option>
            </select> 
          </div>
          <div class="row-form">
          <br>
            <select name="prov" id="prov" class="drop-list">
              <option selected class="disabled">Selec. Localidad </option>
              <option value="1">Loc 1</option>
              <option value="2">Loc 2</option>
              <option value="3">Loc 3</option>
              <option value="4">Loc 4</option>
            </select>  
          </div>
          <div class="row-form">
          <br>
            <input type="text" placeholder="Direccion"> 
          </div>               
        </div>
        <div class="col-form-correo">
          <div class="row-form">
           <br>
            <input type="text" placeholder="correo"> 
          </div>
        </div>
        <div class="btn-form">
          <button type="submit" class="btn-register">Registrar</button>
        </div>
      </div>
    </form>
  -->
  </section>
</t:base>
