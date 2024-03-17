<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
    <h1>Cadastro de Usuário</h1>
    <spring:url value = "/usuario/save" var = "link"/>    
    <form:form modelAttribute = "usuario"action="${link}" method="post">
        <label for="nome">Nome:</label>
        <form:input path="nome" class="class-control" ><br><br>
        
        <label for="email">Email:</label>
        <form:input path="email" class="class-control" ><br><br><br><br>
        
        <label for="idade">Idade:</label>
        <form:input path="idade" class="class-control" ><br><br><br><br>
        
        <button type="submit" value="Cadastrar">
    </form:form>
    