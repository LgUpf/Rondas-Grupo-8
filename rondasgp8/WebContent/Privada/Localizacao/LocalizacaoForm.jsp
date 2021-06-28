<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
<form action="LocalizacaoCon" method="post">
	<fieldset>
	<legend>Formulario:</legend>
	
	
	
			<div class="row">
				<div class="col-md-3">
			       <label>Id</label><br>
        			<input type="number" name="id" value="${obj.id}"><br>		
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-md-3">
			        <label>horaData</label>
			        <input class="form-control"  type="date" name="horaData" value="${obj.horaData}">			
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