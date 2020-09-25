<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Task Manager</title>
</head>
<body>
<h1>Atualizar Tarefa</h1>
<form action='Atualiza' method ='post'>
<input type="text" name="tarefa" value='${param.tarefa}'> 
<input type="hidden" name="id" value='${param.id}'>
<input type="submit" value="atualizar">
</form>
</body>
</html>