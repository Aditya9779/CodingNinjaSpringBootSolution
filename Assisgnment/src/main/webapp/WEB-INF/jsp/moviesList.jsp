<%@ page import="java.util.ArrayList" %>
<%@ page import="static jdk.internal.org.jline.utils.Colors.s" %>

<h1>Here are the recommended movies</h1>
<%
    ArrayList<String> al=(ArrayList<String>) request.getAttribute("movieslist");
    for (int i=0;i<al.size();i++){
%>
<ul>
    <li><%=al.get(i)%></li>
</ul>
<%
    }
%>