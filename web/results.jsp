<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Domaci 6</title>
</head>
<body>
<c:set var="name" value="gradeList" />
<c:forEach var="grade_obj" items="${sessionScope[name]}">
    <li><c:out value="${grade_obj.assistant_name}"/></li>
    <li><c:out value="${grade_obj.grade}"/></li>
</c:forEach>

</body>
</html>
