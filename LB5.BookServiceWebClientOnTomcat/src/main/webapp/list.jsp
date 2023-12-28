<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of films</title>
	<link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<c:choose>
	<c:when test="${empty films}">
		<h2>No films found</h2>
	</c:when>
	<c:otherwise>
		<table class="brd">
			<thead class="tabhead">
			<tr>
				<th class="brd">Film ID</th>
				<th class="brd">Film Title</th>
				<th class="brd">Duration</th>
				<th class="brd">Show Type</th>
				<th class="brd">Actions</th> <!-- Added column for actions -->
			</tr>
			</thead>
			<tbody>
			<c:forEach var="film" items="${films}">
				<tr>
					<td class="brd">${film.id}</td>
					<td class="brd">${film.filmTitle}</td>
					<td class="brd">${film.duration}</td>
					<td class="brd right">${film.showType}</td>
					<td class="brd">
						<form action="deleteFilm" method="post">
							<input type="hidden" name="filmId" value="${film.id}">
							<button type="submit">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
</body>
</html>
