<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
<form action="LocomocaoCon" method="post">
	<fieldset>
	<legend>Formulário:</legend>
	
	
	
			<div class="row">
				<div class="col-md-5">
			       <label>Id</label><br>
        			<input type="number" name="id" value="${obj.id}"><br>		
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-md-5">  			
        			<label>Descrição</label><br>
        			<input type="text" name="descricao" value="${obj.descricao}"><br>
				</div>
			</div>

		<div class="row">
			<div class="col-md-5">  			
        		<label>Placa</label><br>
       		    <input type="text" name="placa" value="${obj.placa}"><br><br>
			</div>
		</div>
       
        
        <button type="submit" name="gravar">Gravar</button>	
        <button type="submit" name="cancelar">Cancelar</button>
	
	</fieldset>
</form>

</body>
</html>