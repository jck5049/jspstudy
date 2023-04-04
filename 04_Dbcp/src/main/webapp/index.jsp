<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 
1.	<a href="/04_Dbcp/getAllBoardList.do">게시판</a>
	
2.	<a href="<%=request.getContextPath()%>/getAllBoardList.do">게시판</a>
	
	<%
3.		pageContext.setAttribute("contextPath", request.getContextPath());
	%>
	<a href="${contextPath}/getAllBoardList.do">게시판</a>
--%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="page" />
	<a href="${contextPath}/getAllBoardList.do">게시판</a>
	
	<a href="<c:url value="/getAllBoardList.do"/>">게시판</a>
	
</body>
</html>