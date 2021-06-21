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
                                  <input   class="form-control"  type="text" readonly value="Homero J.">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="name" class="col-4 col-form-label">Apellidos:</label> 
                                <div class="col-8">
                                  <input  class="form-control" type="text" readonly value="Simpson">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="lastname" class="col-4 col-form-label">DNI:</label> 
                                <div class="col-8">
                                  <input   class="form-control here" type="text" readonly value="44.444.444">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="text" class="col-4 col-form-label">CUIL:</label> 
                                <div class="col-8">
                                  <input   class="form-control here"  type="text" readonly value="21-44444444-4">
                                </div>
                              </div>
                              
                              <div class="form-group row">
                                <label for="email" class="col-4 col-form-label">Email:</label> 
                                <div class="col-8">
                                  <input   class="form-control here"  type="email" readonly value="amantedelacomida53@aol.com">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="website" class="col-4 col-form-label">Fecha Nac.</label> 
                                <div class="col-8">
                                  <input   class="form-control here" type="text" readonly value="12/05/1956">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="publicinfo" class="col-4 col-form-label">Numero total de cuentas:</label> 
                                <div class="col-8">
                                   <input  class="form-control here" type="text" readonly value="4">
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