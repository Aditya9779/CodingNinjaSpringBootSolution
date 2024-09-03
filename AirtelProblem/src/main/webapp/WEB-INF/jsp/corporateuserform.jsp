<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<h1>
    welcome to corporate details page for signup
</h1>
<form:form action="corporateregister" modelAttribute="corporate">
    Name:<form:input path="name"/>
    <br/>
    <br/>
    Registered Phone number:<form:input path="number"/>
    <br/>
    <br/>
    <input type="submit"/>

</form:form>

</html>
