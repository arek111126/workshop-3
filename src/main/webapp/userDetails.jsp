<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 04.09.19
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>User details</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<c:choose>
    <c:when test="${fn:length(userDetailList) > 0}">
        <table>
            <tr>
                <th>Tytuł zadania</th>
                <th>Data dodania</th>
                <th>Akcje</th>
            </tr>

            Szczegóły użytkownika:
            <c:forEach items="${userDetailList}" var="item">
                <tr>
                    <td>
                            ${item.exerciseTitle}
                    </td>
                    <td>
                            ${item.create}
                    </td>
                    <td>
                        <a href="/solutionDetail?id=${item.solutionId}">szczegóły rozwiazania</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        user nie umiescił rozwiązania żadnego z zadań!!
    </c:otherwise>
</c:choose>

<jsp:include page="/footer.jsp"/>
</body>
</html>
