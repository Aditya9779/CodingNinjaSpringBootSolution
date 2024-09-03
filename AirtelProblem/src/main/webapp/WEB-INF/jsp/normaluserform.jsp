<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<h1>
    welcome to user details page
</h1>

<%--@elvariable id="user" type=""--%>
<form:form action="register" modelAttribute="user">
    Name:<form:input path="name"/>
    <br/>
    <br/>
    Registered Phone number:<form:input path="number"/>
    <br/>
    <br/>
    Plan Type:<form:select path="plan">
    <form:option value="Prepaid"></form:option>
    <form:option value="PostPaid"></form:option>
</form:select>
    <br/>
    <br/>
    <input type="submit"/>

</form:form>
</html>