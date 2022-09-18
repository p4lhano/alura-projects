<!-- <!DOCTYPE html> -->
<%
	String nomeEmpresaJSP = (String) request.getAttribute("nomeEmpresa");
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Cadastro de Empresa</title>
</head>
<body>
	
	<h1>1 leu nova empresa Scriplet verboso: <% out.println(nomeEmpresaJSP); %></h1>
	<h1>2 leu nova empresa Scriplet simplificado exibicao:<%= nomeEmpresaJSP %></h1>
	<h1>2 leu nova empresa Expression Language: ${ nomeEmpresa } </h1>
</body>
</html>