<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="br.edu.insper.mvc.*" %>
    

<!DOCTYPE html>
<html>
<head>
<title>Task Manager</title>
</head>
<body>
<h1>Task Manager</h1>
<h4>Tarefas de <%out.println((String) request.getSession().getAttribute("nome")); %></h4>
<%if ((Integer) request.getAttribute("size") < 1 ){ %>
<h4> N�o h� tarefas. Crie algumas abaixo!</h4>
<% } else {%>
<table border="1">
<tr>
<th>Task</th>
<th>Added</th>
<th>Updated</th>
<th>Actions</th>
</tr>
<c:forEach var="tarefa" items="${tarefas}">
<tr>
<td>${tarefa.tarefa}</td>
<td>${tarefa.createdAt}</td>
<td>${tarefa.updatedAt}</td>
<td>
<form action='Remove' method='post'>
<input type='hidden' name='id' value='${tarefa.id}'>
<input type='submit' value='remover'>
</form>
<form action='Atualiza' method='get'>
<input type='hidden' name='id' value='${tarefa.id}'>
<input type='hidden' name='tarefa' value='${tarefa.tarefa}'>
<input type='submit' value='atualizar'>
</form>
</td>
</tr>
</c:forEach>
</table>
<%} %>
<br>
<form action="Cria" method='post'>
<input type="text" name="tarefa"> 
<input type="submit" value="Adicione uma task">
</form>
<br>
<a href="Login">Sair</a>
</body>
</html>