<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Produtos</title>
</head>
<body>
	
	<form action="/projetospring/produtos" method="post">
		<div>
			<label>Titulo do Livro</label>
			<input type="text" name="titulo">
		</div>
		<div>
			<label>Descricao</label>
			<textarea rows="10" cols="20" name="descricao"></textarea>
		</div>
		<div>
			<label>Páginas</label>
			<input type="text" name="paginas">
		</div>
		<button type="submit">Cadastrar livro</button>	
	
	</form>
	
</body>
</html>