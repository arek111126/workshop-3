<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 07.09.19
  Time: 00:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<a href="/userAdd">Dodaj</a>
<table>
    <tr>
        <th>login</th>
        <th>email</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${allUsers}" var="item">
        <tr>
            <td>
                    ${item.userName}
            </td>
            <td>
                    ${item.email}
            </td>
            <td>
                <a href="/userEditAndDelete?action=edit&id=${item.id}">edytuj</a>   <a href="/userEditAndDelete?action=delete&id=${item.id}">usun</a>
            </td>

        </tr>


    </c:forEach>
</table>
<jsp:include page="/footer.jsp"/>
</body>
</html>
