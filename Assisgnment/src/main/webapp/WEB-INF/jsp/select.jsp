<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<h2><%=request.getAttribute("message") %></h2>
<h3>Select the Genre</h3>
<form action="/movies" method="post">
    <select name="genre" id="genre">
        <option value="romantic">Romantic</option>
        <option value="comedy">comedy</option>
        <option value="horror">horror</option>
        <option value="drama">Drama</option>
        <option value="sci-fi">sci-fi</option>
        <option value="thriller">Thriller</option>
        <option value="suspense">Suspense</option>
    </select>
    <input type="submit">
</form>

</html>