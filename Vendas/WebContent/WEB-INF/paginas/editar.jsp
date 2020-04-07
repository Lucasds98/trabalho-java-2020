<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Fornecedor</title>
<link href="style.css" rel="stylesheet" />
</head>
<body>
<form method="POST" action="EditarFornecedorServlet">
        <div>
            Qual fornecedor deseja editar?
            <select style="width: 174px;height: 30px;" name="codigo">
                <c:forEach var="f" items="${fornecedor}">
                    <option value="${f.codigo}">${f.nome}</option>
                </c:forEach>
            </select><br /><br />
            <hr />
            <br />
            Novo nome: <input type="text" name="nome">
            
            <br /><br /><br />
            <input type="submit" value="Editar" />
        </div>
    </form>
    <div style="text-align: center;">${mensagem}</div><br /><br />
    
    <div style="text-align: center;">
    	<a href="index.html" class="btn">Voltar ao menu</a>
    </div>
</body>
</html>