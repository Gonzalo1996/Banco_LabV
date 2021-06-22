<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<title>Banco UTN</title>
<t:baseUsuario>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Barlow:wght@100&display=swap" rel="stylesheet">

<div class="card">
	 <div class="card-header">
	    <h4 style="font-family: 'Barlow', sans-serif">CUENTAS</h4>
	 </div>
	 <div class="card-body">
	    <h5 class="card-title">Selecciones una Cuenta:</h5>
	 </br>
	    
	 <div class="col-md-5">
		<div class="dropdown ">
			<button class="btn btn-outline-secondary dropdown-toggle btn-md" style="width: 100%" type="submit"  id="ddpCuenta" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			Cuentas:
			</button>
				<div class="dropdown-menu" aria-labelledby="ddpCuentas">
						<a class="dropdown-item" href="detalleCuentaCliente.jsp">EN PESOS &nbsp; &nbsp; &nbsp; &nbsp;Caja de Ahorro&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;246-6666666-1&nbsp;&nbsp; <b>$  5.000,00</b></a>
						<a class="dropdown-item" href="detalleCuentaCliente.jsp">EN PESOS &nbsp; &nbsp; &nbsp; &nbsp;Cuenta Corriente &nbsp; &nbsp; &nbsp;123-4567899-0&nbsp;&nbsp; <b>$   15.000,00</b></a>
						<a class="dropdown-item" href="detalleCuentaCliente.jsp">EN DOLARES&nbsp; &nbsp;Caja de Ahorro &nbsp; &nbsp; &nbsp; &nbsp; 433-1212120-2&nbsp;&nbsp; <b>U$D  1.000,00</b></a>
				</div>
		</div>	 											
	</div>
	    
	 </div>
</div>

</t:baseUsuario>

<footer  style="width:100%; margin-left: 0px;"  >
<div class="copyright" style="background-color: #0d47a1;">
    <div class="container-fluid" style="background-color: #0d47a1; color: #bbdefb;">
        ©  Copyright: BANCO UTN - 2021
    </div>
</div>
</footer>