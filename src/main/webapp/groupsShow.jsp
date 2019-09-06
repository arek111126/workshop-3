<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 06.09.19
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>groups</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<a href="/addNewGroup">Dodaj</a>
    <table>
        <tr>
            <th>Nazwa grupy</th>
            <th>Akcje</th>
        </tr>
        <c:forEach items="${allGroups}" var="item">
            <tr>
                <td>
                    ${item.name}
                </td>
                <td>
                   <a href="/editGroupsServlet?action=edit&id=${item.id}">edytuj</a>   <a href="/editGroupsServlet?action=delete&id=${item.id}">usun</a>
                </td>

            </tr>


        </c:forEach>
    </table>
<jsp:include page="/footer.jsp"/>
</body>
</html>
