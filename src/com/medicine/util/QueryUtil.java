package com.medicine.util;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class QueryUtil extends CommonUtil {
	
	/**
	 * Get a SQL query from an XML file based on its ID.
	 * 
	 * @param id The ID of the query to retrieve.
	 * @return The SQL query as a string.
	 * @throws SAXException if there is an error related to parsing the XML file.
	 * @throws IOException if an I/O error occurs.
	 * @throws ParserConfigurationException if there is a configuration error while parsing the XML.
	 */
	public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException {
	
		NodeList nodeList;
		Element element = null;
		
		// Parse the XML file containing SQL queries.
		nodeList = DocumentBuilderFactory.newInstance()
			.newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\OrderMeds-web-app\\WEB-INF\\queries.xml"))
			.getElementsByTagName(CommonConstants.TAG_NAME);
		
		// Search for the query with the specified ID.
		for(int value = 0; value < nodeList.getLength(); value++) {
			
			element = (Element) nodeList.item(value);
			
			if(element.getAttribute(CommonConstants.ATTRIBUTE_NAME).equals(id)) {
				break;
			}
		}
		
		// Return the text content of the query element, trimmed of any whitespace.
		return element.getTextContent().trim();
	}
}
