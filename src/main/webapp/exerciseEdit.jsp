<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 07.09.19
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja Zadania</title>
</head>
<body>
<form action="/exerciseEdit" method="post">
    Nazwa zadania <input type="text" name="title"><br>
    opis zadania <input type="text" name="description"><br>
    <input type="hidden" name="id" value="${id}">

    <input type="submit" value="edytuj">

</form>
</body>
</html>
