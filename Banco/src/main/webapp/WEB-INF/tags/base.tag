<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:test>
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
	</jsp:attribute>
	<jsp:body>
		<link rel="stylesheet" href="content/nav/style.css">
		<link rel="stylesheet" href="content/nav/prueba.css">

		<title>Sidebar + Navbar admin</title>

		<jsp:doBody />
	</jsp:body>

</t:test>
