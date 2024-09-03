<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h1>Sign Up for Movie Recommendations</h1>
</header>

<div class="container">
    <form:form action="registerUser" modelAttribute="user">
        <div>
            <label for="userName">User Name:</label>
            <form:input path="userName" />
        </div>
        <br />
        <div>
            <label for="email">Email:</label>
            <form:input path="email" />
        </div>
        <br />
        <div>
            <label for="password">Password:</label>
            <form:input path="password" />
        </div>
        <br />
        <input type="submit" value="Sign Up" />
    </form:form>
</div>

<footer>
    <p>&copy; 2024 Movie Recommendation App</p>
</footer>
</body>
</html>
