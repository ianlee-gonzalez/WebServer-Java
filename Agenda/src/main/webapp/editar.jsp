<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de Contatos</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="icon" href="imagens/fone.png">
</head>
<body>
	<h1>Editar Contato</h1>
	<form name="frmContato" action="update">
		<table>
		
		<tr>
			<td><input type="text" name="idcon" placeholder="idcon" class="Caixa3" readonly 
			value="<%out.print(request.getAttribute("idon"));%>"></td>
			</tr>
			
			<tr>
			<td><input type="text" name="nome"  class="Caixa1" 
			value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			
			<tr>
			<td><input type="text" name="fone"  class="Caixa2" 
			value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			
			<tr>
			<td><input type="text" name="email"  class="Caixa1" 
			value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			
		</table>
		<input type="button" value = "Salvar" class="botao1" onclick="validar()">
	</form>
	<script src="scripts/Validador.js"></script>
</body>
</html>