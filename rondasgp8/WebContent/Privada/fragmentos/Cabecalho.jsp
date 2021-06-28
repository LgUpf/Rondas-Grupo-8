<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Aulas ADS</title>

	<link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.min.css">
	<script src="../../resources/jquery/jquery-3.6.0.min.js"></script>
	<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
	<link href="../../resources/fontawesome/css/all.css" rel="stylesheet">
	<link href="../../resources/smartmenus/css/sm-core-css.css" rel="stylesheet" type="text/css"/>
	<link href="../../resources/smartmenus/css/sm-blue/sm-blue.css" rel="stylesheet" type="text/css" />
	<link href="../../resources/estilos.css" rel="stylesheet">


</head>
<body>
	<h3>Aplicação web teste</h3>
	<h4>${sessionScope.usuarioLogado.nome}</h4>

		<nav class="main-nav" role="navigation">

		  <ul id="main-menu" class="sm sm-blue">
		    <li><a href="../Home/Home.jsp">Home</a></li>
		    <li><a href="#">Cadastro</a>
		      <ul>
		        <li><a href="../Pessoa/PessoaCon">Pessoas</a></li>
		        <li><a href="../Ronda/RondaCon">Rondas</a></li>
		         <li><a href="../Ocorrencia/OcorrenciaCon">Ocorrencia</a></li>
		         <li><a href="../Usuario/UsuarioCon">Usuarios</a></li>
		          <li><a href="../Locomocao/LocomocaoCon">Locomocao</a></li>
		        <li><a href="../Localizacao/LocalizacaoCon">Localizacao</a></li>
		 
		        <li><a href="#">Basicos</a>
		          <ul>
		            <li><a href="../Usuario/UsuarioCon">Usuarios</a></li>
		      
		          </ul>
		        </li>
		      </ul>
		    </li>
		    <li><a href="http://www.smartmenus.org/contact/">Contato</a></li>
		  </ul>
		</nav>

	<script type="text/javascript">
		<script type="text/javascript"
		src="../../resources/smartmenus/libs/jquery/jquery.js">
	</script>
	<script type="text/javascript"
		src="../../resources/smartmenus/jquery.smartmenus.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#main-menu').smartmenus({
				subMenusSubOffsetX : 1,
				subMenusSubOffsetY : -8
			});
		});
	</script>


</body>
</html>