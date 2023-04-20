<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
		function fnDetail(xeNo){
			location.href = '${contextPath}/detail.do?xeNo=' + xeNo;
		}
</script>
</head>
<body>

	<c:forEach var="xe" items="${xeList}">
		<div style="border: 1px solid gray; cursor: pointer;" onclick="fnDetail(${xe.xeNo})">
			<div>번호 : ${xe.xeNo}</div>
			<div>내용 : ${xe.xeContent}</div>
			<div>날짜 : ${xe.xeCreatedAt}</div>
		</div>
	</c:forEach>

</body>
</html>