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
			
			<form:input path="produto.titulo" />
			<form:errors path="produto.titulo" />
		</div>
		<div>
			<label>Descricao</label>
			
			<form:textarea rows="10" cols="20" path="produto.descricao" />
			<form:errors path="produto.descricao" />
		</div>
		<div>
			<label>Páginas</label>
			
			<form:input path="produto.paginas"/>
			<form:errors path="produto.paginas" />
		</div>
		
		<div>
			<label>Data Lançamento</label>
			<form:input path="produto.dataLancamento"/>
			
			<form:errors path="produto.dataLancamento" />
			
		</div>
		<c:forEach items = "${tipos}" var="tipoPreco" varStatus="status">
		
			<div>
				<label>${tipoPreco}</label>
				<form:input path="produto.precos[${status.index}].valor"/>
				<form:hidden path="produto.precos[${status.index}].tipo" value="${tipoPreco}"/>
			</div>
			
		</c:forEach>
		<button type="submit">Cadastrar livro</button>	
	
	</form>
	
</body>
</html>