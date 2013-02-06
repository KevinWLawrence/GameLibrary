/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 *
 * @author kevin.lawrence
 */
public class XMLContentHandler implements ContentHandler {
    
//  <editor-fold defaultstate="collapsed" desc="Methods">

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        element = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(element)) {
            if (propertyListener != null) {
                propertyListener.notify(element, value);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = String.copyValueOf(ch, start, length);
    }
//  </editor-fold>

//  <editor-fold defaultstate="collapsed" desc="Constructors">
    public XMLContentHandler(PropertyListener propertyListener) {
        this.propertyListener = propertyListener;
    }
//  </editor-fold>
        
//  <editor-fold defaultstate="collapsed" desc="Properties">  

    private String element = "";
    private String value = "";
    private PropertyListener propertyListener;

    /**
     * @return the propertyListener
     */
    public PropertyListener getPropertyListener() {
        return propertyListener;
    }

    /**
     * @param propertyListener the propertyListener to set
     */
    public void setPropertyListener(PropertyListener propertyListener) {
        this.propertyListener = propertyListener;
    }
//  </editor-fold>  
    
//  <editor-fold defaultstate="collapsed" desc="Non-implemented methods">
    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
    }
//  </editor-fold>  
}
