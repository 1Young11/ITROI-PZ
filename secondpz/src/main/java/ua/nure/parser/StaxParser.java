package ua.nure.parser;

import org.example.xml.entity.cinema.Film;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class StaxParser {

    public static void main(String[] args) throws Exception {
        System.out.println("--== StAX Parser ==--");
        StaxParser parser = new StaxParser();
        List<Film> films = parser.parse(new FileInputStream(Const.XML_FILE));
        System.out.println("====================================");
        System.out.println("Here is the films: \n" + films);
        System.out.println("====================================");
        films = parser.parse(new FileInputStream(Const.INVALID_XML_FILE));
        System.out.println("====================================");
        System.out.println("Here is the invalid films: \n" + films);
        System.out.println("====================================");
    }

    private List<Film> parse(InputStream in) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        // Configure factory
        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
		factory.setProperty(XMLInputFactory.SUPPORT_DTD, false); 
        // Validation does not supported by Sun's StAX implementation
//		factory.setProperty(XMLInputFactory.IS_VALIDATING, Boolean.TRUE);  // not supported
//		factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");         // not supported
// 		factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");      // not supported
		
		EventHandler handler = new EventHandler();
		
        XMLEventReader eventReader = factory.createXMLEventReader(in);
        
        
        while (eventReader.hasNext()) {
			XMLEvent event;
			try {
				event = eventReader.nextEvent();
				// skip any empty content
				if (event.isCharacters() && event.asCharacters().isWhiteSpace()) {
					continue;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
				break;
			}

            switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    handler.startElement(event);
                    break;

                case XMLStreamConstants.CHARACTERS:
                    handler.characters(event);
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    handler.endElement(event);
                    break;
				default:
			}
        }
		return handler.getFilms();
	}

}
