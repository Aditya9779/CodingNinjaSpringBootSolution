<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<h1>here are the plan to choose from</h1>
<%--@elvariable id="corporateplan" type=""--%>
<form:form action="registercorporateplan" modelAttribute="corporateplan">
    Enter the data required:<form:input path="data"/>
    <br>
    <br>
    Plan Validity(Days):<form:select path="duration">
    <form:option value="365"></form:option>
    <form:option value="200"></form:option>
    <form:option value="90"></form:option>
</form:select>
    <br/>
    <br/>
    Speed:<br />
    900 mbps<form:radiobutton path="speed" value="900"/>
    500 mbps<form:radiobutton path="speed" value="500"/>
    <br/>
    <br/>
    Call minutes: <br/>
    unlimited<form:radiobutton path="calls" value="unlimited"/>
    500<form:radiobutton path="calls" value="5000"/>
    <br/>
    <br/>

    <input type="submit"/>
</form:form>
</html>