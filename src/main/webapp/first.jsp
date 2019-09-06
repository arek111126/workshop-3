<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 03.09.19
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<jsp:include page="/header.jsp"/>
<table>
    <tr>
        <th>Tytuł zadania</th>
        <th>Autor rozwiązania</th>
        <th>Data dodania</th>
    </tr>


    <c:forEach items="${mainViewDataList}" var="mainViewData">
    <tr>
        <td>
                ${mainViewData.exerciseTitle}
        </td>
        <td>
                ${mainViewData.authorSolution}
        </td>
        <td>
                ${mainViewData.addSolutionData}
        </td>
        <td>
            <a href="/solutionDetail?id=${mainViewData.solutionId}">szczegóły</a>
        </td>
        </c:forEach>


</table>
<jsp:include page="/footer.jsp"/>
</body>
</html>
