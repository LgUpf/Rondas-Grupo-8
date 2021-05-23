<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
<h1>LISTAGEM DE PESSOAS</h1>

<form action="PessoaCon">
	<button type="submit" name="incluir"><i class="fas fa-check-square"></i>Incluir</button>
	
	<table border="1" class="table table-hover table-condensed">
	
		<thead>
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Idade</td>
			<td>Dias</td>
			<td>Faixa</td>
			<td></td>
			<td></td>
			<td></td>
			
		</tr>
		</thead>
	
		<c:forEach items="${lista}" var="p" varStatus="cont">
		   <tr>
		      <td>${p.id}</td>
		      <td>${p.nome}</td>    
		      <td>${p.idade}</td>
		      <td>${p.diasVividos}</td>
		      <td>${p.faixaEtaria}</td>
		      <td><button type="submit" name="alterar" value="${p.id}"><i class="fas fa-edit"></i>Alterar</button></td>
		      <td><button type="submit" name="excluir" value="${p.id}"><i class="fas fa-trash"></i>Excluir</button></td>
		   </tr>
	    </c:forEach>
	</table>
</form>

</body>
</html>