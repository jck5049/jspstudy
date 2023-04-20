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
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>
	<h1>학생 관리</h1>
	<div>
		<input type="button" value="신규학생등록" onclick="">
	</div>
	<hr>
	<form id="frm_find">
		<div>
			평균
			<input type="number" id="begin" name="begin" placeholder="begin" min="0" max="100">
			~
			<input type="number" id="end" name="end" placeholder="end" min="0" max="100">
			<button>조회</button>
			<input type="button" value="전체조회" onclick="">
		</div>
		<hr>
		<hr>
		<table border="1">
			<caption><strong>전체 학생 명</strong></caption>
			<thead>
				<tr>
					<td>학번</td>
					<td>성명</td>
					<td>국어</td>
					<td>영어</td>
					<td>수학</td>
					<td>평균</td>
					<td>학점</td>
					<td>버튼</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="stu" items="${studentList}">
					<tr>
						<td>${stu.stuNo}</td>
						<td>${stu.name}</td>
						<td>${stu.kor}</td>
						<td>${stu.eng}</td>
						<td>${stu.math}</td>
						<td>${stu.ave}</td>
						<td>${stu.grade}</td>
						<td>
						<input type="button" value="상세" onclick="">
						<input type="button" value="삭제" onclick="">
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">전체평균</td>
					<td>총평균</td>
					<td colspan="2"></td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>