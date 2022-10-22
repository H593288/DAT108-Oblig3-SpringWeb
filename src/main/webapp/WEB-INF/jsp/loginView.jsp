<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Oppgi ditt passord:</title>
    <link rel="stylesheet" href="css/simple.css">
</head>
    <body>

        <p>Gi inn passord:</p>
        <p><c:out value="${redirectMessage}" /></p>
        <form action="login" method="post">
            <input type="text" name="password"/>
            <br/>
            <br/>
            <input type="submit" value="Logg inn"/>
        </form>
    </body>
</html>