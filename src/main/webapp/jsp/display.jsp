<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table border="1">
			<tr>
				<td>key</td>
				<td>Value</td>
			</tr>
		
	<c:forEach items="${sessionScope.FB_CHAT}" var="chat">
        <tr>
				<td>${chat.key}</td>
				<td>${chat.value}</td>
			</tr>
    </c:forEach>
    </table>
    </center>
</body>
</html>