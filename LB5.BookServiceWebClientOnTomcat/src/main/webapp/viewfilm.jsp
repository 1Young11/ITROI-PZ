<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Film Details</title>
    <link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<div>
    <h1>Film Details</h1>
    <c:choose>
        <c:when test="${not empty errorMsg}">
            <h2>${errorMsg}</h2>
        </c:when>
        <c:otherwise>
            <div>
                <ul>
                    <li>Film Title: ${film.filmTitle}</li>
                    <li>Duration: ${film.duration}</li>
                    <li>Show Type: ${film.showType}</li>
                </ul>

                <h3>Tickets:</h3>
                <table border="1"> <!-- Add the border attribute here -->
                    <thead>
                    <tr>
                        <th>Ticket Number</th>
                        <th>Seat Number</th>
                        <th>Purchase Date</th>
                        <th>Viewer Name</th>
                        <th>Viewer Surname</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="ticket" items="${film.ticket}">
                        <tr>
                            <td>${ticket.ticketNumber}</td>
                            <td>${ticket.seatNumber}</td>
                            <td>${ticket.purchaseDate}</td>
                            <td>${ticket.viewer.name}</td>
                            <td>${ticket.viewer.surname}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
