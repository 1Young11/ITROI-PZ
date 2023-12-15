<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:film="http://www.example.org/xml/films/"
                xmlns:ticket="http://www.example.org/xml/tickets/"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">

  <xsl:template match="/">
    <html>
      <body>
        <h2>Cinema Tickets</h2>
        <h3>Films:</h3>
        <table border="1">
          <tr bgcolor="#6495ED">
            <th>Movie Title</th>
            <th>Duration</th>
            <th>Genre</th>
            <th>Producer</th>
            <th>Release Date</th>
          </tr>
          <xsl:for-each select="cinema/film:film">
            <tr>
              <td><xsl:value-of select="film:movie_title"/></td>
              <td><xsl:value-of select="film:duration"/></td>
              <td><xsl:value-of select="film:genre"/></td>
              <td><xsl:value-of select="film:producer"/></td>
              <td><xsl:value-of select="film:release_date"/></td>
            </tr>
          </xsl:for-each>
        </table>

        <h3>Tickets:</h3>
        <table border="1">
          <tr bgcolor="#9acd32">
            <th>Ticket Number</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Seat Number</th>
            <th>Purchase Date</th>
            <th>Movie Title</th>
            <th>Duration</th>
            <th>Show Type</th>
          </tr>
          <xsl:for-each select="cinema/ticket:ticket">
            <tr>
              <td><xsl:value-of select="ticket:ticket_number"/></td>
              <td><xsl:value-of select="ticket:viewer/ticket:name"/></td>
              <td><xsl:value-of select="ticket:viewer/ticket:surname"/></td>
              <td><xsl:value-of select="ticket:seat_number"/></td>
              <td><xsl:value-of select="ticket:purchase_date"/></td>
              <td><xsl:value-of select="ticket:movie/ticket:movie_title"/></td>
              <td><xsl:value-of select="ticket:movie/ticket:duration"/></td>
              <td><xsl:value-of select="ticket:movie/ticket:show_type"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>