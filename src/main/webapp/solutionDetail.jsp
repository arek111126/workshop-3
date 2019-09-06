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
<a href="/">Powrót</a>
<h2>Szczegóły rozwiązanai zadania</h2>

${solution.description}

<jsp:include page="/footer.jsp"/>
</body>
</html>
