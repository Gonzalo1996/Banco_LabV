<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:test>
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
          <a href=""><i class="fa fa-question"></i>Ayuda</a>
        </li>
	</jsp:attribute>
	<jsp:body>
		<link rel="stylesheet" href="content/nav/style2.css">

		<title>Sidebar + Navbar usuario</title>

		<jsp:doBody />
	</jsp:body>

</t:test>
