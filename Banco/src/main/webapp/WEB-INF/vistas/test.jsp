<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>${CuentaUnica.alias}</h1>
	<h1>${generoUnico}</h1>
	<h1>${paisUnico}</h1>
	<h1>${provinciaUnica}</h1>
	<h1>${localidadUnica}</h1>
	<h1>${MovimientUnico}</h1>
	<h1>${UsuarioUnico}</h1>
	<h1>${ClienteUnico}</h1>


<!-- ALTERNATIVA SELECT -->
<select>
    <option value="" disabled selected>--Select Cuenta--</option>
        <c:forEach items="${listCuentas}" var="cuenta" varStatus="status">
            <option value="${cuenta.nroCuenta}"><c:out value="${cuenta.alias}"></c:out> </option>
        </c:forEach>
</select>

<form:select path = "listClientes">
   <form:option value = "NONE" label = "Seleccionar cliente"/>
   <form:options items = "${listClientes}" />
</form:select>
	
<form:select path = "listUsuarios">
   <form:option value = "NONE" label = "Seleccionar usuario"/>
   <form:options items = "${listUsuarios}" />
</form:select>

<form:select path = "listMovimiento">
   <form:option value = "NONE" label = "Seleccionar movimiento"/>
   <form:options items = "${listMovimiento}" />
</form:select>
	
<form:select path = "listCuentas">
   <form:option value = "NONE" label = "Seleccionar Cuenta"/>
   <form:options items = "${listCuentas}" />
</form:select>

<form:select path = "listGeneros">
   <form:option value = "NONE" label = "Seleccionar Genero"/>
   <form:options items = "${listGeneros}" />
</form:select>

<form:select path = "listPais">
   <form:option value = "NONE" label = "Seleccionar Pais"/>
   <form:options items = "${listPais}" />
</form:select>

<form:select path = "listProvincias">
   <form:option value = "NONE" label = "Seleccionar Provincia"/>
   <form:options items = "${listProvincias}" />
</form:select>

<form:select path = "listProvincias2">
   <form:option value = "NONE" label = "Seleccionar Provincia Cuyo ID pais = 1"/>
   <form:options items = "${listProvincias2}" />
</form:select>

<form:select path = "listLocalidades">
   <form:option value = "NONE" label = "Seleccionar Localidad"/>
   <form:options items = "${listLocalidades}" />
</form:select>

<form:select path = "listLocalidades2">
   <form:option value = "NONE" label = "Seleccionar Localidad Cuyo ID provincia = 3"/>
   <form:options items = "${listLocalidades2}" />
</form:select>

	<table class="tg">
	<tr>
		<th>ID</th>
		<th>Name</th>

	</tr>
	<c:forEach items="${listGeneros}" var="gen">
		<tr>
			<td>${gen.id}</td>
			<td>${gen.nombre}</td>
		</tr>
	</c:forEach>
	</table>
	
	<a href="test2.html">Ir a test 2</a>

</body>
</html>