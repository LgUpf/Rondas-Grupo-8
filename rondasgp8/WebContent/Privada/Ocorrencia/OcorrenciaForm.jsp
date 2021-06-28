<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>



	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
<form action="OcorrenciaCon" method="post">
	<fieldset>
	<legend>Formulário:</legend>
	
	
	
			<div class="row">
				<div class="col-md-3">
			       <label>Id</label><br>
        			<input type="number" name="id" value="${obj.id}"><br>		
				</div>
			</div>
			<div class="row">
				<div class="col-md-5">  			
        			<label>Titulo</label><br>
        			<input type="text" name="titulo" value="${obj.titulo}"><br>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-5">  			
        			<label>Descrição</label><br>
        			<input type="text" name="descricao" value="${obj.descricao}"><br>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-md-3">
			        <label>Data e Hora</label>
			        <input class="form-control"  type="date" name="dataHora" value="${obj.dataHora}">			
				</div>
			</div>
		<div class="row">
			<div class="col-md-3">
			     <label>Latitude</label>
			     <input class="form-control"  type="text" name="latitude" value="${obj.latitude}">			
			</div>
		</div>
       
       <div class="row">
			<div class="col-md-3">
			    <label>Longitude</label>
			    <input class="form-control"  type="text" name="longitude" value="${obj.longitude}">		
			</div>
		</div>		
        <button type="submit" name="gravar">Gravar</button>	
        <button type="submit" name="cancelar">Cancelar</button>
	
	</fieldset>
</form>

</body>
</html>