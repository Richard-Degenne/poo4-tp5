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
        <title>POO TP3</title>
    </head>
    <body>
        <%!int count = 0;%>
        <%Person p = new Person(request.getParameter("first"), request.getParameter("last"));%>
        <jsp:useBean id="person" class="model.Person" />
        <jsp:setProperty name="person" property="firstName" param="first" />
        <jsp:setProperty name="person" property="lastName" param="last" />
        
        <h1>Hello <jsp:getProperty name="person" property="firstName" /> <jsp:getProperty name="person" property="lastName" />!</h1>
        <p>Called <%=++count%> times.</p>
    </body>
</html>
