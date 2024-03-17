<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tabela de Usuários</title>
</head>
<body>
    
    <table class="table table-striped table-condensed">
        <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>AÇÃO</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.email}</td>
                    <td>${usuario.idade}</td>
                    <td>
                        
                        <spring:url value = "/update{id}" var = "linkEditar"/>  
                        <a class="btn btn-info" href="${linkEditar}">Editar</a>
                        <spring:url value = "/delete{id}" var = "linkExcluir"/>
                        <a class="btn btn-danger" href="${linkExcluir}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>