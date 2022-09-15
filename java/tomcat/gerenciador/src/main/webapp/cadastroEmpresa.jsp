<!-- <!DOCTYPE html> -->
<%
	String nomeEmpresa = (String) request.getAttribute("nomeEmpresa");
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Cadastro de Empresa</title>
</head>
<body>
	
	<h1>leu nova empresa <% out.println(nomeEmpresa); %></h1>
	<h1>leu nova empresa <%= nomeEmpresa %></h1>
</body>
</html>