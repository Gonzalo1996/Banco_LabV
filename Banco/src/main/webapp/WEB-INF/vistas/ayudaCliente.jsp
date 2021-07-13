<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:baseUsuario title="Ayuda">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@100&display=swap" rel="stylesheet">

	<div class="row">
		<div class="col-md-10">
			<h1 style="font-family: 'Barlow', sans-serif; text-align: center">Ayuda del Usuario:</h1>				
		</div>
	</div>

	<div class="row">
		<div class="col-md-10">
		
		<div id="accordion">
		  <div class="card">
		    <div class="card-header" id="headingOne">
		      <h6 class="mb-0">
				<a href="#collapse1"  data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne" style="color:#1d0d44">
				Sobre Inicio  
				<span class="fas fa-home"></span>
				</a>
		      </h6>
		    </div>
		
		    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
		      <div class="card-body">		
					<p>En la pantalla de Inicio, usted podrá visualizar y corroborar sus datos, tanto como su:</p>
						<ul>	
							<li>Nombre</li>
							<li>Apellido</li>
							<li>DNI</li>
							<li>CUIL</li>
							<li>Email</li>
							<li>Fecha de Nacimiento</li>
							<li>Cuentas</li>
						</ul>
						
					<p>En este último, se le dará el total de Cuentas que posea de forma Activa(tenga en cuenta que usted puede poseer hasta 4 Cuentas).</p>
					<p>Si usted considera que hay datos erróneos, comuníquese con los Administradores del Banco UTN.</p>
		      </div>
		    </div>
		  </div>
		  
		  <!-- PANEL 2 -->
		  <div class="card">
		    <div class="card-header" id="headingTwo">
		      <h6 class="mb-0">
				<a href="#collapse2" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" style="color:#1d0d44">
					Sobre Cuentas  
					<span class="fa fa-university"></span>
				</a>
		        
		      </h6>
		    </div>
		    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
				<div class="card-body">
					<p>En la pantalla de Cuentas, usted se encontrará con un Listado de las Cuentas que posea. En caso de no poseer cuentas, se le mostrará un Cartel
					aclaratorio sobre el mismo.
					Los datos que verá aquí son:
					</p>
						<ul>
							<li>Tipo de Moneda</li>
							<li>Nombre de la Cuenta</li>
							<li>Nro. de Cuenta</li>
							<li>Saldo</li>
						</ul>
					<p>Al seleccionar alguna de las Cuentas, se le mostrará el detalle de los Movimientos de la misma.
					Siendo los datos a verse:</p>
					    <ul>
					    	<li>Fecha</li>
							<li>Detalle</li>
							<li>Monto (si se debitó, le figurará el signo <b>-</b> que demuestra que se le descontó dinero)</li>
							<li>Saldo (Saldo que tiene al momento del Crédito/Débito)</li>
						</ul>
				</div>
		    </div>
		  </div>
		  
		  		  <!-- PANEL 2 -->
		  <div class="card">
		    <div class="card-header" id="headingThree">
		      <h6 class="mb-0">
				<a href="#collapse3" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree" style="color:#1d0d44">
					Sobre Transferencias  
					<span class="fa fa-exchange"></span>
				</a>
		        
		      </h6>
		    </div>
		    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
				<div class="card-body">
					<p>En la pantalla de Transferencias, usted podrá realizar 2 tipos de Acciones:</p>
						<ul>
							<li>Transferencia a otras Cuentas</li>
							<li>Transferencia a Cuentas Propias</li>
						</ul>
						<h2>Transferencias a otras Cuentas</h2>
					
					<p>Aquí usted podrá realizar transferencias de dinero a distintas cuentas registradas en el Banco. Deberá elegir de que Cuenta saldrá el Dinero, ingresar el CBU a enviar, el importe a transferir y el detalle del mismo.</p>
					<p>Importante a tener en cuenta:</p>
						<ul>
							<li>Las cuentas, tanto de Salida como Destino, deben ser del mismo Tipo de Moneda</li>
							<li>El CBU donde se va a realizar la Transferencia debe existir en el Banco</li>
							<li>El monto debe ser menor o igual al Disponible</li>
						</ul>					
					<p>Si se cumplen estos items mencionados, se podrá realizar la Transferencia.</p>
					
						<h2>Transferencias a Cuentas Propias</h2>
					
					<p>Usted podrá mover dinero entre sus cuentas activas mientras:</p>
						<ul>
							<li>La Cuenta de Salida y Destino no sean las mismas</li>
							<li>Las Cuentas sean del mismo Tipo de Moneda</li>
							<li>El monto de la cuenta de Salida sea menor o igual al Disponible</li> 
						</ul>
					<p>Si se cumplen estos items mencionados, se podrá realizar la Transferencia.</p>
				</div>
		    </div>
		  </div>
		</div>
	</div>
	</div>
	
</t:baseUsuario>