<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 07.09.19
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<a href="/exerciseAdd">Dodaj</a>
<table>
    <tr>
        <th>Nazwa zadania</th>
        <th>opis zadania</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${allExercises}" var="item">
        <tr>
            <td>
                    ${item.title}
            </td>
            <td>
                    ${item.description}
            </td>
            <td>
                <a href="/exerciseEdit?action=edit&id=${item.id}">edytuj</a> <a href="/exerciseEdit?action=delete&id=${item.id}">usun</a>
            </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="/footer.jsp"/>
</body>
</html>
