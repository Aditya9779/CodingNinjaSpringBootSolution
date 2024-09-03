<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>The list of the instructor here</h1>
<% //Here we are type casting for getting in the jsp file
    ArrayList<HashMap<String, Object>> listOfInstructor = (ArrayList<HashMap<String, Object>>)
            request.getAttribute("listOfInstructor");
    for (HashMap<String, Object> x : listOfInstructor) {
%>   Name: <%=x.get("name") %> --
<a href="profile/<%= x.get("id")%>"> Profile</a>
<br>
<%
    }
%>
</body>
</html>
