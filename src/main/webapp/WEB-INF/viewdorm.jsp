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
    <div class="container bg-light rounded col-9 p-5">
        <form action="/dorms/${d.id}/add/student" method="POST">
            <select class="form-select" name="student_id">
                <option selected>Select a student</option>
                <c:forEach var="student" items="${students}">
                    <option value="${student.id}">${student.name} <p class="font-italic">${student.dorm.name}</p></option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>

	<div class="container col-9 bg-light p-5 rounded">
        <h1 class="display-4"><c:out value="${d.name}"/> Students</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="s" items="${d.students}">
                    <tr>
                        <td><c:out value="${s.name}"/></td>
                        <td>
                            <form action="/dorms/${d.id}/remove/${s.id}" method="POST">
                                <button type="submit" class="btn btn-sm btn-outline-danger" href=>Remove Student</button>                   
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>

