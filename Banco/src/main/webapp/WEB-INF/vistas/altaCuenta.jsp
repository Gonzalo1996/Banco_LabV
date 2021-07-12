<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:baseAdmin title="Alta cuenta">
<link rel="stylesheet" href="content/form/form-cuenta.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@200;400&display=swap" rel="stylesheet">

	<h3 class="title-client">Alta cuentas</h3>
	
	
	<section class="section-mov">
    <div class="container-form mov">
      <h3>Nueva Cuenta</h3>
      
      <form action="guardarCuenta.html" method="post">
      <div class="col-form">
        <div class="row-form">
         <br>
          <input name="cbu" type="text" placeholder="CBU" required pattern="^\D*\d{22}$"  title="El CBU debe estar compuesto por 22 digitos"> 
        </div>
        <div class="row-form">
         <br> 
          <input name="alias" type="text" placeholder="Alias" required/> 
        </div>
        <div class="row-form date">
         <br>
          <input name="nombre" type="text" placeholder="Nombre cuenta" required/>  
        </div>
      </div>
      <div class="col-form">
        <div class="row-form">
        <br>
          <input name="dni" type="text" placeholder="DNI cliente" required/> 
        </div>
        
        <div class="row-form">
        <br>
	        <button href="#ventana1" class="btn btn-link" data-toggle="modal">
	    		<i class="fa fa-search" aria-hidden="true"></i>
	    	</button>        
	    	</div>
        
        <div class="row-form">
        <br>
            <select name="moneda" id="moneda" class="drop-list" required>
              <option value="1">Pesos</option>
              <option value="2">Dolares</option>
            </select> 
          </div>
      </div>
 
      <div class="btn-form">
        <button type="submit" class="btn btn-primary">
        Registrar
        <i class="fa fa-check-circle-o" aria-hidden="true"></i>
        </button>     
      </div> 
  
      </form>
    </div>
    

    
     <div class="modal fade" id="ventana1">
           <div class="modal-dialog">
               <div class="modal-content">
                   <div class="modal-header">
                   	<h3 class="modal-title">Buscar cliente</h3>                  
                       <button class="close" data-dismiss="modal"><span class="fa fa-times-circle"></span></button>
                   </div>
                   <div class="modal-body">
                   
						<label for="exampleDataList" class="form-label">Buscador de clientes</label>
						<input class="form-control" list="datalistOptions" id="exampleDataList" placeholder="Buscar cliente...">
						<datalist id="datalistOptions">
						        <c:forEach items="${listClientes}" var="c" varStatus="status">
						            <option value="${c.dni}">
							            <c:out value="Titular: "></c:out> 
							            <c:out value="${c.apellido}"></c:out> 
							            <c:out value="${c.nombre}"></c:out>          
									</option>
						        </c:forEach>
						</datalist>
                       
                   </div>
                   <div class="modal-footer">
                       <button class="btn btn-default" data-dismiss="modal" type="button">Cerrar</button>
                   </div>
               </div>
           </div>
       </div>


  </section>
</t:baseAdmin>
