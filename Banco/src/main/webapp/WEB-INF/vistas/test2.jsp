<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:baseUsuario title="Test">
<form:select path = "listGeneros">
   <form:option value = "NONE" label = "Seleccionar Genero"/>
   <form:options items = "${listGeneros}" />
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

</t:baseUsuario>