<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 07.09.19
  Time: 01:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/userEditAndDelete" method="post">
    podaj nowy login <input type="text" name="userName"><br>
    podaj nowy email <input type="text" name="email"><br>
    Nowe haslo <input type="password" name="password"><br>
    Podaj id grupy <input type="text" name="groupId"><br>
    <input type="hidden" name="id" value="${id}">
    <table>
        <tr>
            <th>id grupy</th>
            <th>nazwa grupy</th>


        </tr>
        <c:forEach items="${allGroups}" var="item">
            <tr>
                <td>
                        ${item.id}
                </td>
                <td>
                        ${item.name}
                </td>


            </tr>


        </c:forEach>
    </table>

    <input type="submit" value="dodaj uzytkownika">

</form>
</body>
</html>
