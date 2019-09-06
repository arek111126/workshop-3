<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 04.09.19
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <jsp:include page="/header.jsp"/>
    <tr>
        <th>Nazwa</th>
        <th>Akcje</th>
    </tr>

Lista użytkowników grupy : ${groupName}

    <c:forEach items="${usersFromGroups}" var="user">
    <tr>
        <td>
                ${user.userName}
        </td>
        <td>
            <a href="/userInfo?id=${user.id}">szczegóły</a>
        </td>


        </c:forEach>
        <jsp:include page="/footer.jsp"/>

</table>
</body>
</html>
