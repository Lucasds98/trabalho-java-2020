<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Produtos dos Fornecedores</title>
    <link href="style.css" rel="stylesheet" />
</head>
<body>
<h4>Produtos dos fornecedores cadastrados</h4>
	<table class="table">
		<tr> 
		    <th>Nome Produto</th>
		    <th>Nome Fornecedor</th>
		    <th>Razao Social</th>
	   </tr>
		   <c:forEach var="f" items="${ProdutoFornecedor}">
		   <tr>
		   		<td>${f.nomeProduto}</td>
		   		<td>${f.nomeFornecedor}</td>
		   		<td>${f.razaoSocial}</td>

		  </tr>
		   </c:forEach> 
 
	</table>
	<div style="text-align: center;">
    	<a href="index.html" class="btn">Voltar ao menu</a>
    </div>
</body>
</html>