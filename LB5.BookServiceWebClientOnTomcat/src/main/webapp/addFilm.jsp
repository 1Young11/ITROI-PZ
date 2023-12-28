<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Film</title>
	<link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<div>
	<form action="add" method="post">
		<h1>Add Film</h1>
		<label for="filmTitle">Film Title:</label>
		<input type="text" name="filmTitle" id="filmTitle" required/><br/>

		<label for="durationFilm">Film Duration:</label>
		<input type="text" name="durationFilm" id="durationFilm" required/><br/>

		<label for="showTypeFilm">Film Show Type:</label>
		<input type="text" name="showTypeFilm" id="showTypeFilm" required/><br/>

		<!-- Input field for specifying the number of tickets -->
		<label for="numTickets">Number of Tickets:</label>
		<input type="number" name="numTickets" id="numTickets" min="1" required/><br/>

		<!-- Dynamic generation of ticket input forms based on the number specified above -->
		<div id="ticketForms"></div>

		<!-- JavaScript to generate ticket input forms based on the number specified -->
		<script>
			function generateTicketForms() {
				var numTickets = parseInt(document.getElementById('numTickets').value);
				var ticketForms = document.getElementById('ticketForms');
				ticketForms.innerHTML = ''; // Clear previous forms

				for (var i = 1; i <= numTickets; i++) {
					ticketForms.innerHTML += '<h2>Ticket ' + i + '</h2>' +
							'<label for="ticketNumber' + i + '">Ticket Number ' + i + ':</label>' +
							'<input type="text" name="ticketNumber' + i + '" id="ticketNumber' + i + '" required/><br/>' +
							'<label for="seatNumber' + i + '">Seat Number ' + i + ':</label>' +
							'<input type="text" name="seatNumber' + i + '" id="seatNumber' + i + '" required/><br/>' +
							'<label for="purchaseDate' + i + '">Purchase Date ' + i + ':</label>' +
							'<input type="text" name="purchaseDate' + i + '" id="purchaseDate' + i + '" required/><br/>' +
							'<label for="viewerName' + i + '">Viewer Name ' + i + ':</label>' +
							'<input type="text" name="viewerName' + i + '" id="viewerName' + i + '" required/><br/>' +
							'<label for="viewerSurname' + i + '">Viewer Surname ' + i + ':</label>' +
							'<input type="text" name="viewerSurname' + i + '" id="viewerSurname' + i + '" required/><br/>';
				}
			}

			// Trigger the function on page load
			generateTicketForms();

			// Add an event listener to the "Number of Tickets" input
			document.getElementById('numTickets').addEventListener('input', generateTicketForms);
		</script>

		<br/>
		<input type="submit" value="Submit"/>
	</form>
</div>
</body>
</html>
