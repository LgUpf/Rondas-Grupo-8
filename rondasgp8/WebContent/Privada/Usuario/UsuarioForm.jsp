<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
<form action="UsuarioCon" method="post">
	<fieldset>
	<legend>Formulário:</legend>
	
        <label>Id</label><br>
        <input type="number" name="id" value="${obj.id}"><br>

        <label>Nome</label><br>
        <input type="text" name="nome" value="${obj.nome}"><br>

        <label>Email</label><br>
        <input type="text" name="email" value="${obj.email}"><br><br>
        
         <label>Senha</label><br>
        <input type="text" name="senha" value="${obj.senha}"><br><br>
        
        <label>Data Nascimento</label><br>
        <input type="date" name="dataNascimento" value="${obj.dataNascimento}"><br><br>
        	
        <button type="submit" name="gravar">Gravar</button>	
        <button type="submit" name="cancelar">Cancelar</button>
	
	</fieldset>
</form>

</body>
</html>