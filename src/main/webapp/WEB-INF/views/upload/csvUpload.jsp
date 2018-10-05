<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload arquivo CSV</title>
</head>
<body>

	<form method="post" enctype="multipart/form-data" action="/projetospring/uploadCSV">
		<input type="file" name = "arquivo" >
		<input type="hidden" name = "pasta" value="C:\csv\teste" >
		<input type="hidden" name = "nome" value="joaopedroamaralsouza.csv" >
		
		<input type="submit" value="Enviar arquivo CSV">
	</form>
	
</body>
</html>