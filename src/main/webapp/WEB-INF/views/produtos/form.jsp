<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Produtos</title>
</head>
<body>
	
	<form action="/projetospring/produtos" method="post">
		<div>
			<label>Titulo do Livro</label>
			
			<input type="text" name="titulo">
			<form:errors path="produto.titulo" />
		</div>
		<div>
			<label>Descricao</label>
			
			<textarea rows="10" cols="20" name="descricao"></textarea>
			<form:errors path="produto.descricao" />
		</div>
		<div>
			<label>Páginas</label>
			
			<input type="text" name="paginas">
			<form:errors path="produto.paginas" />
		</div>
		
		<c:forEach items = "${tipos}" var="tipoPreco" varStatus="status">
		
			<div>
				<label>${tipoPreco}</label>
				<input type="text" name="precos[${status.index}].valor">
				<input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}">
			</div>
			
		</c:forEach>
		<button type="submit">Cadastrar livro</button>	
	
	</form>
	
</body>
</html>