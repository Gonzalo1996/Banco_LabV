<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<title>UTN BANK | Inicio</title>
<t:baseUsuario>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@100&display=swap" rel="stylesheet">

	<div class="col-md-9">
		    <div class="card">
		        <div class="card-body">
		            <div class="row">
		                <div class="col-md-12">
		                    <h4>Tu perfil bancario</h4>
		                    <hr>
		                </div>
		            </div>
		            
		            <div class="row">
		                <div class="col-md-12">
		                    <form>
                              <div class="form-group row">
                                <label for="username" class="col-4 col-form-label">Nombres:</label> 
                                <div class="col-8">
                                  <input   class="form-control"  type="text" readonly value="${cliente.nombre}">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="name" class="col-4 col-form-label">Apellidos:</label> 
                                <div class="col-8">
                                  <input  class="form-control" type="text" readonly value="${cliente.apellido}">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="lastname" class="col-4 col-form-label">DNI:</label> 
                                <div class="col-8">
                                  <input   class="form-control here" type="text" readonly value="${cliente.dni}">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="text" class="col-4 col-form-label">CUIL:</label> 
                                <div class="col-8">
                                  <input   class="form-control here"  type="text" readonly value="${cliente.cuil}">
                                </div>
                              </div>
                              
                              <div class="form-group row">
                                <label for="email" class="col-4 col-form-label">Email:</label> 
                                <div class="col-8">
                                  <input   class="form-control here"  type="email" readonly value="${cliente.correo}">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="website" class="col-4 col-form-label">Fecha Nac.</label> 
                                <div class="col-8">
                                  <input   class="form-control here" type="text" readonly value="${cliente.fechaNacimiento}">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="publicinfo" class="col-4 col-form-label">Numero total de cuentas:</label> 
                                <div class="col-8">
                                   <input  class="form-control here" type="text" readonly value="${totalCuentas}">
                                </div>
                              </div>
                             
                            </form>
		                </div>
		            </div>
		            
		        </div>
		    </div>
		</div>
	</div>
</div>



</t:baseUsuario>