<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

<h1>LISTAGEM DE USUÁRIOS</h1>

<form action="UsuarioCon">
	<button type="submit" name="incluir">Incluir</button>
	
	<table border="1">
		<c:forEach items="${lista}" var="p" varStatus="cont">
		   <tr>
		      <td>${p.id}</td>
		      <td>${p.nome}</td>    
		      <td>${p.email}</td>
		      <td>${p.senha}</td>
		      <td>${p.dataNascimento}</td>
		      <td><button type="submit" name="alterar" value="${p.id}">Alterar</button></td>
		      <td><button type="submit" name="excluir" value="${p.id}">Excluir</button></td>
		   </tr>
	    </c:forEach>
	</table>
</form>

</body>
</html>