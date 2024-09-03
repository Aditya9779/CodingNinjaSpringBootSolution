<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<h1>Sign up Page</h1>
<form:form action="registerUser" modelAttribute="user">
    Name:
    <form:input path="name"></form:input>
    <br>
    <br>
    College:
    <form:select path="college">
        <form:option value="Srm">SRM</form:option>
        <form:option value="NIT">NIT</form:option>
    </form:select>
    <br>
    <br>
    Gender:
    <form:radiobutton path="gender" value="male"/> Male
    <form:radiobutton path="gender" value="female"/> Female
    <br>
    <br>
    Location:
    <form:select path="location">
        <form:option value="Chennai">Chennai</form:option>
        <form:option value="Mumbai">Mumbai</form:option>
    </form:select>
    <input type="submit">
</form:form>
</html>
