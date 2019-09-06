<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 06.09.19
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja Grupy</title>
</head>
<body>
<form action="/editGroupsServlet" method="post">
    Nowa Nazwa <input type="text" name="title"><br>
    <input type="hidden" name="id" value="${id}">

    <input type="submit" value="zapisz">

</form>
</body>
</html>
