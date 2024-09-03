<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h1>Registration Successful</h1>
</header>

<div class="container">
    <p>You have successfully registered!</p>
    <a href="<%="/select?id=" + request.getParameter("id") + "&name=" + request.getParameter("name") %>">
        Movies Recommendations
    </a>
</div>

<footer>
    <p>&copy; 2024 Movie Recommendation App</p>
</footer>
</body>
</html>
