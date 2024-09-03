<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<h1> Here are your plans </h1>

<h3>Choose according to your requirement</h3>
<%--@elvariable id="normalplan" type=""--%>
<form:form action="registernormalplan" modelAttribute="normalplan">
    Enter the data required:<form:input path="data"/>
    <br>
    <br>
    Validity(Days):<form:select path="duration">
    <form:option value="28"></form:option>
    <form:option value="60"></form:option>
    <form:option value="84"></form:option>
</form:select>
    <br/>
    <br/>
    Speed:<br />
    100 mbps<form:radiobutton path="speed" value="100"/>
    200 mbps<form:radiobutton path="speed" value="200"/>
    <br/>
    <br/>
    Call minutes: <br/>
    unlimited<form:radiobutton path="calls" value="unlimited"/>
    500<form:radiobutton path="calls" value="500"/>
    <br/>
    <br/>

    <input type="submit"/>
</form:form>

</html>