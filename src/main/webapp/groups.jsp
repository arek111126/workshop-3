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
<jsp:include page="/header.jsp"/>
<table>
    <tr>
        <th>Nazwa grupy</th>
        <th>Akcje</th>
    </tr>


    <c:forEach items="${allGroups}" var="group">
    <tr>
        <td>
                ${group.name}
        </td>
        <td>
               <a href="/uzytkownicyGrupy?id=${group.id}&name=${group.name}">Użytkownicy</a>
        </td>
    </c:forEach>


</table>
<jsp:include page="/footer.jsp"/>
</body>
</html>
