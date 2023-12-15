package ua.nure.parser;


import org.example.xml.entity.cinema.ObjectFactory;

public interface Const {
	String TAG_TICKET = "Ticket";
	String TAG_FILMTITLE = "Film_Title";
	String TAG_DURATION = "Duration";
	String TAG_SHOWTYPE = "Show_Type";
	String TAG_TICKETNUMBER = "Ticket_Number";
	String TAG_SEATNUMBER = "Seat_Number";
	String TAG_PURCHASEDATE = "Purchase_Date";
	String TAG_VIEWER = "Viewer";
	String TAG_NAME = "Name";
	String TAG_SURNAME = "Surname";
	String TAG_FILM = "Film";
	String TAG_FILMS = "Films";
	String FILMS_NAMESPACE_URI = "http://www.example.org/xml/entity/cinema/";
	String ATTRIBUTE_ID = "Id";


	String XML_FILE = "xml/Films.xml";
	String INVALID_XML_FILE = "xml/Invalid_films.xml";
	String XSD_FILE = "xml/Films.xsd";
	Class<?> OBJECT_FACTORY = ObjectFactory.class;
	
	String SCHEMA_LOCATION__ATTR_NAME = "schemaLocation";
	String SCHEMA_LOCATION__ATTR_FQN = "xsi:schemaLocation";
	String XSI_SPACE__PREFIX = "xsi";
	String SCHEMA_LOCATION__URI = "http://www.example.org/xml/entity/cinema/ Films.xsd";

	// validation features
	public static final String FEATURE__TURN_VALIDATION_ON = 
			"http://xml.org/sax/features/validation";
	public static final String FEATURE__TURN_SCHEMA_VALIDATION_ON = 
			"http://apache.org/xml/features/validation/schema";

}
