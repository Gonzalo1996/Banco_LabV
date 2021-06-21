<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:base>
<link rel="stylesheet" href="content/form/form.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@200;400&display=swap" rel="stylesheet">
	
	<h3 class="title-client">Alta cliente:</h3>
	<section>
	
      <div class="container-form">
        <h3>Datos del cliente</h3>
        <form action="">
        <div class="col-form">
          <div class="row-form">
           <!-- <label for="">Nombres</label>--><br>
            <input type="text" placeholder="Nombre/s"> 
          </div>
          <div class="row-form">
           <!-- <label for="">Apellidos</label>--><br> 
            <input type="text" placeholder="Apellido/s"> 
          </div>
          <div class="row-form">
            <!--<label for="">Fecha Nac.</label>--><br>
            <input type="text" placeholder="Fecha nacimiento"> 
          </div>
        </div>
        <div class="col-form">
          <div class="row-form">
          <!--  <label for="">Dni</label>--><br>
            <input type="text" placeholder="DNI"> 
          </div>
          <div class="row-form">
          <!--  <label for="">cuil</label>--><br>
            <input type="text" placeholder="CUIL"> 
          </div>
          <div class="row-form">
          <!--  <label for="">cbu</label>--><br>
            <input type="text" placeholder="CBU"> 
          </div>
        </div>
        <div class="col-form">
          <div class="row-form">
          <!--  <label for="">Provincia</label>--><br>
            <input type="text" placeholder="Provincia"> 
          </div>
          <div class="row-form">
           <!-- <label for="">Localidad</label>--><br>
            <input type="text" placeholder="Localidad"> 
          </div>
          <div class="row-form">
          <!--  <label for="">Calle</label>--><br>
            <input type="text" placeholder="Calle"> 
          </div>       
        </div>
        <div class="btn-form">
          <button type="submit" class="btn btn-primary">Registrar
          <span class="fa fa-user"></span>
          </button>
        </div>
      </div>
    </form>
  </section>

</t:base>
