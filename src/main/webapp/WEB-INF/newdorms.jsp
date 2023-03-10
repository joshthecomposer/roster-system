<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Roster</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/dorms">Dorm Repo</a>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/dorms/new">Add a Dorm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/students/new">Add a Student</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<body>
	<div class="container col-9 bg-light p-5 rounded">
        <h1 class="display-4">Create a New Dorm</h1>
        <form:form action="/dorms/new" method="POST" modelAttribute="d">
            <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:input class="form-control" path="name" type="text"/>
            </div>
                <button type="submit" class="btn btn-primary col-12 my-3">Add</button>
        </form:form>
    </div>
</body>
</html>

