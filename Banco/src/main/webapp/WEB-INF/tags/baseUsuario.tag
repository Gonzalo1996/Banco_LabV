<%@tag import="banco.constants.TipoUsuario"%>
<%@tag import="banco.model.Usuario"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="title" required="true" %>

      
<t:base title="${title}">
	<jsp:attribute name="menu">
        <li>
          <a href="detallecliente.html"><i class="fas fa-home"></i>Inicio</a>
        </li>
        <li>
          <a href="cuentasCliente.html"><i class="fa fa-university"></i>Cuentas</a>
        </li>
        <li>
          <a href="transferencias.html"><i class="fa fa-exchange"></i>Transferencias</a>
        </li>
        <li>
          <a href="ayudaCliente.html"><i class="fa fa-question"></i>Ayuda</a>
        </li>
        <c:if test="${usuario.tipoUsuario.id == TipoUsuario.ADMIN.id}">
	        <li>
	          <a href="listadoCuentas.html"><i class="fa fa-user-plus"></i>Vista administrador</a>
	        </li>
       	</c:if>
	</jsp:attribute>
	<jsp:body>
		<link rel="stylesheet" href="content/nav/style2.css">

		<title>Sidebar + Navbar usuario</title>

		<jsp:doBody />
	</jsp:body>

</t:base>
