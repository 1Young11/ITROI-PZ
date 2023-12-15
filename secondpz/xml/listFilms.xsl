<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:cinema="http://www.example.org/xml/entity/cinema/"
                exclude-result-prefixes="cinema">

    <!-- Идентификация корневого элемента -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Films Information</title>
            </head>
            <body>
                <h1>Films Information</h1>
                <xsl:apply-templates select="cinema:Films/cinema:Film"/>
            </body>
        </html>
    </xsl:template>

    <!-- Преобразование информации о фильме -->
    <xsl:template match="cinema:Film">
        <div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 20px;">
            <h2><xsl:value-of select="cinema:Film_Title"/></h2>
            <p><strong>Duration:</strong> <xsl:value-of select="concat(cinema:Duration, ' minutes')"/></p>
            <p><strong>Show Type:</strong> <xsl:value-of select="cinema:Show_Type"/></p>
            <h3>Ticket Information:</h3>
            <xsl:apply-templates select="cinema:Ticket"/>
        </div>
    </xsl:template>

    <!-- Преобразование информации о билете -->
    <xsl:template match="cinema:Ticket">
        <div style="border: 1px solid #eee; padding: 5px; margin-bottom: 10px;">
            <p><strong>Ticket Number:</strong> <xsl:value-of select="cinema:Ticket_Number"/></p>
            <p><strong>Seat Number:</strong> <xsl:value-of select="cinema:Seat_Number"/></p>
            <p><strong>Purchase Date:</strong> <xsl:value-of select="cinema:Purchase_Date"/></p>
            <h4>Viewer Information:</h4>
            <xsl:apply-templates select="cinema:Viewer"/>
        </div>
    </xsl:template>

    <!-- Преобразование информации о зрителе -->
    <xsl:template match="cinema:Viewer">
        <p><strong>Name:</strong> <xsl:value-of select="cinema:Name"/></p>
        <p><strong>Surname:</strong> <xsl:value-of select="cinema:Surname"/></p>
    </xsl:template>
</xsl:stylesheet>
