<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Signup Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            font-size: 24px;
        }

        label {
            font-size: 16px;
            margin-right: 10px;
        }

        input[type="text"], select {
            padding: 5px;
            font-size: 14px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            padding: 5px 10px;
            font-size: 14px;
        }
    </style>
</head>
<body>
<h1>This is the signup page</h1>
<form:form action="done" modelAttribute="vehicle">
    Car Number:
    <form:input path="RegisterationNumber" id="carNumber"/><br>

    Car Name:
    <form:select path="CarName">
        <form:option value="Seltos">Seltos</form:option>
        <form:option value="Creta">Creta</form:option>
        <form:option value="Swift">Swift</form:option>

    </form:select><br>

    Covered In Warranty:
    <form:select path="CarDetails">
        <form:option value="YES">YES</form:option>
        <form:option value="NO">NO</form:option>
    </form:select><br>

    Any remarks:
    <form:input path="CarWork"/><br>

    <input type="submit"/>
</form:form>
</body>
</html>