<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
<form action="PessoaCon" method="post">

	<fieldset>
	<legend>Formulário:</legend>

			<div class="row">
				<div class="col-md-4">
					<label>Id</label><br>
       				<input class="form-control" type="number" name="id" value="${obj.id}"><br>
				</div>
			</div>
		
			<div class="row">
				<div class="col-md-5">
					 <label>Nome</label><br>
        		<input class="form-control" type="text" name="nome" value="${obj.nome}"><br>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-md-6">
					 <label>Idade</label><br>
       				 <input class="form-control" type="number" name="idade" value="${obj.idade}"><br><br>
				</div>
			</div>
			

        <button type="submit" class="btn btn-primary"  name="gravar">Gravar</button>	
        <button type="submit" class="btn btn-primary" name="cancelar">Cancelar</button>
	
	</fieldset>
</form>

</body>
</html>