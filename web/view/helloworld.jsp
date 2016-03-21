<%-- 
    Document   : helloworld
    Created on : 08-Mar-2016, 09:01:29
    Author     : richou
--%>

<%@page import="model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!int count = 0;%>
        <%Person p = new Person(request.getParameter("first"), request.getParameter("last"));
        boolean known = p.isKnown();%>
        
        <h1>Hello <%=p.getFirstName()%> <%=p.getLastName()%></h1>
        <p>Called <%=++count%> times.</p>
    </body>
</html>
