package ua.nure.it.demo;

public class TransformerDemo {

	public static void main(String[] args) throws Exception {
		XSLTransform.main(new String[] {"xml/cinema.xslt", "xml/cinema.xml", "xml/cinema.html"});
	}
}
