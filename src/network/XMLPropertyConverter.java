/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author kevin.lawrence
 */
public class XMLPropertyConverter {

    private XMLContentHandler handler;

    /**
     * @return the propertyListener
     */
    public PropertyListener getPropertyListener() {
        if (handler == null) {
            return null;
        } else {
            return handler.getPropertyListener();
        }
    }

    /**
     * @param propertyListener the propertyListener to set
     */
    public void setPropertyListener(PropertyListener propertyListener) {
        if (this.handler != null) {
            handler.setPropertyListener(propertyListener);
        }
    }

    /**
     * @param propertyListener the propertyListener to set
     */
    public XMLPropertyConverter(PropertyListener propertyListener) {
        this.handler = new XMLContentHandler(propertyListener);
    }

    public boolean convertXML(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.getXMLReader().setContentHandler(handler);
            parser.getXMLReader().parse(new InputSource(new StringReader(xml)));

            return true;
        } catch (IOException ex) {
            Logger.getLogger(XMLPropertyConverter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLPropertyConverter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SAXException ex) {
            Logger.getLogger(XMLPropertyConverter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
