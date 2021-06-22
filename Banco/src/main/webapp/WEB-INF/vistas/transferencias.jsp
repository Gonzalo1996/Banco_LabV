<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:baseUsuario>
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
					<form method="get" action="x">
						<div class="form-group row">
							<label class="col-md-3 col-form-label" for="ddpCuenta">Transfiriendo desde:</label>
							<div class="col-md-5">
								<div class="dropdown ">
									<button class="btn btn-outline-secondary dropdown-toggle btn-md" style="width: 100%" type="submit"  id="ddpCuenta" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									Cuentas:
									</button>
									<div class="dropdown-menu" aria-labelledby="ddpTipoCuenta">
										<a class="dropdown-item" href="#">Caja de ahorro pesos $</a>
										<a class="dropdown-item" href="#">Cuenta dolares U$D</a>
									</div>
								</div>	 											
							</div>
						</div>
		
						<div class="form-group row">
								<label class="col-md-3 col-form-label" for="txtCbu">Ingresá el CBU/CVU destino:</label>
								<div class="col-md-5">
									<input id="txtCbu" type="text" class="form-control" placeholder="CBU/CVU">
								</div>
						</div>
						
						<div class="form-group row">
								<label class="col-md-3 col-form-label" for="txtMonto">Importe:</label>
								<div class="col-md-5">
									<div class="input-group mb-3">
									  <div class="input-group-prepend">
									    <span class="input-group-text">$</span>
									  </div>
									  <input id="txtMonto" type="text" class="form-control" placeholder="Monto" aria-describedby="basic-addon1">
									</div>
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
					<form method="get" action="x">
						<div class="form-group row">
							<label class="col-md-3 col-form-label">Transfiriendo desde:</label>
							<div class="col-md-5">
								<div class="dropdown ">
									<button class="btn btn-outline-secondary dropdown-toggle btn-md" style="width: 100%" type="submit"  id="ddpCuenta" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									Cuenta origen:
									</button>
									<div class="dropdown-menu" aria-labelledby="ddpCuentaOrigen">
										<a class="dropdown-item" href="#">Caja de ahorro pesos $</a>
										<a class="dropdown-item" href="#">Cuenta dolares U$D</a>
									</div>
								</div>	 											
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-md-3 col-form-label">Cuenta a trasnferir:</label>
							<div class="col-md-5">
								<div class="dropdown ">
									<button class="btn btn-outline-secondary dropdown-toggle btn-md" style="width: 100%" type="submit"  id="ddpCuenta" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									Cuenta destinatario:
									</button>
									<div class="dropdown-menu" aria-labelledby="ddpCuentaDestino">
										<a class="dropdown-item" href="#">Caja de ahorro pesos $</a>
										<a class="dropdown-item" href="#">Cuenta dolares U$D</a>
									</div>
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
									  <input id="txtMonto2" type="text" class="form-control" placeholder="Monto" aria-describedby="basic-addon1">
									</div>
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
	
</t:baseUsuario>