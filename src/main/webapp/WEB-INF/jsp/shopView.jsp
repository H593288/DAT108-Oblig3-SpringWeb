<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping list</title>
</head>
<body>
<h1>Min handleliste</h1>
<form action="" method="post">
    <button type="submit" name="action" value="add">Legg til </button><input type="text" name="item"/>
</form>
<br />

<c:forEach items="${shoppinglist.getItems()}" var="item" >
    <form action="" method="post"> <br />
        <input type="hidden" name="item" value="<c:out value="${item.getName()}" />">
        <button type="submit" name="action" value="delete">Slett</button> <c:out value="${item.getName()}" /> <br />
    </form>
</c:forEach>

</body>
</html>
