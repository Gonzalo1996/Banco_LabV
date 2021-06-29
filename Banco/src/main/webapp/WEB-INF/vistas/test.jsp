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

	<h1>${generoUnico}</h1>

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
	
	<a href="test2.html">Ir a test 2</a>

</body>
</html>