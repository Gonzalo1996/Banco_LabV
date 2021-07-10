<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:baseUsuario title="Transferencias">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@100&display=swap" rel="stylesheet">

	<div class="row">
		<div class="col-md-10">
			<h4 style="font-family: 'Barlow', sans-serif">¿A dónde querés transferir?:</h4>				
		</div>
	</div>

	<div class="row">
		<div class="col-md-10">
		
		<div id="accordion">
		  <div class="card">
		    <div class="card-header" id="headingOne">
		      <h6 class="mb-0">
				<a href="#collapse1"  data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne" style="color:#1d0d44">
				A otra cuenta con CBU/CVU 
				<span class="fa fa-university"></span>
				</a>
		      </h6>
		    </div>
		
		    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
		      <div class="card-body">
		      
					<form method="post" action="transferenciasOtros.html">
						<div class="form-group row">
							<label class="col-md-3 col-form-label" for="ddpCuenta">Transfiriendo desde:</label>
							<div class="col-md-5">
								<div class="dropdown ">
									<select class="form-control" name="nroCuenta">
										<c:forEach items="${listCuentas}" var="cuenta" varStatus="loop">
           									<option class="dropdown-item" value="${cuenta.nroCuenta}">
           										<c:choose>
													<c:when test="${cuenta.tipoMoneda.id == 1}">
														<b>En Pesos</b> &nbsp; &nbsp; &nbsp;
													</c:when>
													<c:otherwise>
														<b>En Dolares</b> &nbsp;
													</c:otherwise>
												</c:choose>
													${cuenta.nombreCuenta}
           											${cuenta.nroCuenta} $ 
           											${cuenta.saldo}
           									</option>
    									</c:forEach>
									</select>
								</div>	 											
							</div>
						</div>
		
						<div class="form-group row">
								<label class="col-md-3 col-form-label" for="txtCbu">Ingresá el CBU/CVU destino:</label>
								<div class="col-md-5">
									<input id="txtCbu" type="text" name="cbu" class="form-control" placeholder="CBU/CVU">
								</div>
						</div>
						
						<div class="form-group row">
								<label class="col-md-3 col-form-label" for="txtMonto">Importe:</label>
								<div class="col-md-5">
									<div class="input-group mb-3">
									  <div class="input-group-prepend">
									    <span class="input-group-text">$</span>
									  </div>
									  <input id="txtMonto" type="number" step="any" name="montoOtros" class="form-control" placeholder="Monto" aria-describedby="basic-addon1">
									</div>
								</div>								
						</div>
						
						<div class="form-group row">
								<label class="col-md-3 col-form-label" for="txtDetalle">Detalle:</label>
								<div class="col-md-5">
									<input name="detalle" id="txtDetalle" type="text" class="form-control" placeholder="Detalle">
								</div>
						</div>
						
						<div class="row">
							<div class="col-md-4 offset-md-3">
								<button id="btnTransferir" class="btn btn-primary" type="submit">Transferir
									<span class="fa fa-paper-plane-o"></span>
								</button>
							</div>
						</div>
	
					</form>			
						
		      </div>
		    </div>
		  </div>
		  
		  <!-- PANEL 2 -->
		  <div class="card">
		    <div class="card-header" id="headingTwo">
		      <h6 class="mb-0">
				<a href="#collapse2" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" style="color:#1d0d44">
					A una de mis cuentas banco UTN 
					<span class="fa fa-exchange"></span>
				</a>
		        
		      </h6>
		    </div>
		    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
				<div class="card-body">
				
					<form method="post" action="transferenciasPropias.html">
						<div class="form-group row">
							<label class="col-md-3 col-form-label">Transfiriendo desde:</label>
							<div class="col-md-5">
								<div class="dropdown ">
									<select class="form-control" name="nroCuentaOrigen">
										<c:forEach items="${listCuentas}" var="cuenta" varStatus="loop">
           									<option class="dropdown-item" value="${cuenta.nroCuenta}">
           										<c:choose>
													<c:when test="${cuenta.tipoMoneda.id == 1}">
														<b>En Pesos</b> &nbsp; &nbsp; &nbsp;
													</c:when>
													<c:otherwise>
														<b>En Dolares</b> &nbsp;
													</c:otherwise>
												</c:choose>
													${cuenta.nombreCuenta}
           											${cuenta.nroCuenta} $ 
           											${cuenta.saldo}
           									</option>
    									</c:forEach>
									</select>
								</div>	 											
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-md-3 col-form-label">Cuenta a trasnferir:</label>
							<div class="col-md-5">
								<div class="dropdown ">
									<select class="form-control" name="nroCuentaDestino">
										<c:forEach items="${listCuentas}" var="cuenta" varStatus="loop">
           									<option class="dropdown-item" value="${cuenta.nroCuenta}">
           										<c:choose>
													<c:when test="${cuenta.tipoMoneda.id == 1}">
														<b>En Pesos</b> &nbsp; &nbsp; &nbsp;
													</c:when>
													<c:otherwise>
														<b>En Dolares</b> &nbsp;
													</c:otherwise>
												</c:choose>
													${cuenta.nombreCuenta}
           											${cuenta.nroCuenta} $ 
           											${cuenta.saldo}
           									</option>
    									</c:forEach>
									</select>
								</div>	 											
							</div>
						</div>
						
						<div class="form-group row">
								<label class="col-md-3 col-form-label" for="txtMonto2">Importe:</label>
								<div class="col-md-5">
									<div class="input-group mb-3">
									  <div class="input-group-prepend">
									    <span class="input-group-text">$</span>
									  </div>
									  <input id="txtMonto2" type="number" step="0.01" name="montoPropias" class="form-control" placeholder="Monto" aria-describedby="basic-addon1">
									</div>
								</div>								
						</div>
						
						<div class="form-group row">
								<label class="col-md-3 col-form-label" for="txtDetalle">Detalle:</label>
								<div class="col-md-5">
									<input name="detalle" id="txtDetalle" type="text" class="form-control" placeholder="Detalle">
								</div>
						</div>
						
						<div class="row">
							<div class="col-md-4 offset-md-3">
								<button id="btnTransferir" class="btn btn-primary" type="submit">Transferir
									<span class="fa fa-paper-plane-o"></span>
								</button>
							</div>
						</div>
					</form>	
								
				</div>
		    </div>
		  </div>
		</div>
	</div>
	</div>
	
	    <c:if test="${!empty error}">
	    <script>
			Swal.fire({
			  icon: 'error',
			  title: 'Ups...',
			  text: '${error}',
			});
		</script>
	</c:if>
	
</t:baseUsuario>