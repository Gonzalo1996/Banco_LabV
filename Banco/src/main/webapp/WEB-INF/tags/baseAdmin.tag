<%@tag import="banco.constants.TipoUsuario"%>
<%@tag import="banco.model.Usuario"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%@ attribute name="title" required="true" %>


<%
	try {		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		if (usuario == null || usuario.getTipoUsuario() == null || !usuario.getTipoUsuario().getId().equals(TipoUsuario.ADMIN.getId()))
			throw new Exception("Usuario no logueado o sin permisos.");
	} catch (Exception e) {
		e.printStackTrace();
		response.setHeader("Location", request.getContextPath() + "/login.html");
		response.setStatus(302);
	} 
%>

<t:base title="${title}">
	<jsp:attribute name="menu">
        <li>
         	<a href=""><i class="fas fa-home"></i>Inicio</a>
        </li>
        <li>
          	<a href="altaCliente.html"><i class="fas fa-user-cog"></i>Alta Cliente</a>
        </li>
        <li>
       		<a href="altaCuenta.html"><i class="fas fa-hands-helping"></i>Alta cuenta</a>          
        </li>
        <li>
          	<a href="listadoCuentas.html"><i class="fas fa-clipboard"></i>Listado Cuentas</a>
        </li>
        <li>
          	<a href="listadoClientes.html"><i class="fa fa-address-book"></i>Listado Clientes</a>
        </li>
        <li>
          	<a href=""><i class="fas fa-info"></i>About</a>
        </li>
        <li>
          	<a href="detallecliente.html"><i class="fa fa-user-plus"></i>Vista cliente</a>
        </li>
	</jsp:attribute>
	<jsp:body>
		<link rel="stylesheet" href="content/nav/style.css">
		<link rel="stylesheet" href="content/nav/prueba.css">

		<title>Sidebar + Navbar admin</title>

		<jsp:doBody />
	</jsp:body>

</t:base>
