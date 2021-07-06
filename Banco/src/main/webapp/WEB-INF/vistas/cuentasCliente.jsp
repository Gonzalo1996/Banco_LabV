<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


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

	 <!-- Pregunto si la Lista de Cuentas está Vacia -->
	 <c:choose>
			<c:when test="${empty listCuentas}">
				Usted no posee cuentas
			</c:when>
	<c:otherwise>
	 <div class="card-body">
	    <h5 class="card-title">Seleccione una Cuenta:</h5>
	 </br>
	
		 <div class="col-md-5">
		<div class="dropdown ">
			<button class="btn btn-outline-secondary dropdown-toggle btn-md" style="width: 100%" type="submit"  id="ddpCuenta" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			Cuentas:
			</button>

				<div class="dropdown-menu" aria-labelledby="ddpCuentas">
						<c:forEach items="${listCuentas}" var="cuenta" varStatus="loop">
            					<a class="dropdown-item" href="">
            						<c:choose>
											<c:when test="${cuenta.moneda == 1}">
												<b>En Pesos</b> &nbsp; &nbsp; &nbsp;
											</c:when>
										<c:otherwise>
												<b>En Dolares</b> &nbsp;
										</c:otherwise>
									</c:choose>
							${cuenta.nombreCuenta}
            				${cuenta.nroCuenta} $ 
            				${cuenta.saldo}
            				</a>
       					</c:forEach>
				</div>
		
		</div>	 											
	</div>
	 </div>
	 	</c:otherwise>
			</c:choose>
					
</div>

</t:baseUsuario>

<footer  style="width:100%; margin-left: 0px;"  >
<div class="copyright" style="background-color: #0d47a1;">
    <div class="container-fluid" style="background-color: #0d47a1; color: #bbdefb;">
        ©  Copyright: BANCO UTN - 2021
    </div>
</div>
</footer>