/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.util.HashMap;
import java.util.Map.Entry;
import network.PropertyListener;
import network.XMLPropertyConverter;

/**
 *
 * @author kevin.lawrence
 */
public class Message {

    public static final String ELEMENT_MESSAGE = "Message";
    public static final String ELEMENT_MESSAGE_TYPE = "MessageType";
    public static final String ELEMENT_DATA = "Data";
    public static final String UNKNOWN_MESSAGE_TYPE = "Unknown";
    
    private final String XML_ELEMENT_FORMAT = "<%1$s>%2$s</%1$s>";
    private HashMap<String, String> elements = new HashMap<String, String>();

//  <editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * @return new instance of Message type
     * @param xml: a String of XML that will be directly set as the Message content
     */
    public Message(String xml) {
        this.elements.putAll(decodeXML(xml));
    }

    /**
     * @return new instance of Message type
     * @param messageType: a String that is the type of message be set
     * @param data: a String contains the data to be contained in the message
     */
    public Message(String messageType, String data) {
        this.elements.put(ELEMENT_MESSAGE_TYPE, messageType);
        this.elements.put(ELEMENT_DATA, data);
    }

    /**
     * @return new instance of Message type
     * @param elements: an array of Strings that lists the XML elements to be set
     * @param values: an array of Strings that lists the values (associated with
     * the provided elements) to be set as name/value pairs
     */
    public Message(String[] elements, String[] values) {
        for (int i = 0; i < elements.length; i++) {
            this.elements.put(elements[i], values[i]);
        }
    }
//  </editor-fold>

//  <editor-fold defaultstate="collapsed" desc="Methods">
    
    /**
     * @return a HashMap<String, String> data structure that contains the 
     * key/value pairs of the properties extracted from the formatted XML 
     * string that was input to the method. 
     * For example, if the XML is formatted as follows:
     * <Message> 
     *   <MessageType>move</MessageType> 
     *   <Data>
     *     <OriginalLocationRow>0</OriginalLocationRow>
     *     <OriginalLocationColumn>3</OriginalLocationColumn>
     *     <NewLocationRow>1</NewLocationRow>
     *     <NewLocationColumn>2</NewLocationColumn>
     *   </Data> 
     * </Message>
     * 
     * then the key/value entries will be:
     * Key                      Value
     * ---------                ------           
     * MessageType              move
     * OriginalLocationRow      0
     * OriginalLocationColumn   3
     * NewLocationRow           1
     * NewLocationColumn        2
     * 
     */
    public static HashMap<String, String> decodeXML(String xml) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();

        XMLPropertyConverter converter = new XMLPropertyConverter(
                new PropertyListener() {
                    @Override
                    public void notify(String property, String value) {
                        hashMap.put(property, value);
                    }
                });

        converter.convertXML(xml);
        return hashMap;
    }

    /**
     * @return the formatted XML string for the given element; for example, an
     * element/value pair having the element = "FirstName" and the value = "Bob"
     * will return a string of the form: <FirstName>Bob</FirstName>
     */
    public String getElementAsXML(String element) {
        String value = this.elements.get(element);

        if (value == null) {
            value = UNKNOWN_MESSAGE_TYPE;
        }
        return formatElementAsXML(element, value);
    }

    /**
     * @return the formatted XML string for all the "Data" elements of the
     * message instance.
     */
    public String getDataElementAsXML() {
        String data = "";

        for (Entry<String, String> entry : this.elements.entrySet()) {
            if (!entry.getKey().equalsIgnoreCase(ELEMENT_MESSAGE_TYPE)) {
                data += formatElementAsXML(entry.getKey(), entry.getValue()) + " ";
            }
        }
        return formatElementAsXML(ELEMENT_DATA, data);
    }

    /**
     * @return the formatted XML string for the message class; within a bounding
     * Message element, this should include a MessageType element, and any other
     * elements within a standard Data element. Note that, for simplicity,
     * subordinate elements to the Data element are "flat", i.e. they only allow
     * a single level below Data, and do not allow structure or recursion below
     * that level.
     *
     * For example, a simple "move" message for a checkers game may have a form:
     * <Message> 
     *   <MessageType>move</MessageType> 
     *   <Data>
     *     <OriginalLocationRow>0</OriginalLocationRow>
     *     <OriginalLocationColumn>3</OriginalLocationColumn>
     *     <NewLocationRow>1</NewLocationRow>
     *     <NewLocationColumn>2</NewLocationColumn>
     *   </Data> 
     * </Message>
     */
    public String getXML() {
        String messageType = getElementAsXML(ELEMENT_MESSAGE_TYPE);
        String data = getDataElementAsXML();

        return formatElementAsXML(ELEMENT_MESSAGE, messageType + " " + data);
    }

    /**
     * @return the formatted XML string
     * @param element the element name to format into XML
     * @param value the element value to format into XML
     */
    private String formatElementAsXML(String element, String value) {
        return String.format(XML_ELEMENT_FORMAT, element, value);
    }
    
//  </editor-fold>

//  <editor-fold defaultstate="collapsed" desc="Properties">
    /**
     * @return the message type; if the message type is not defined, will return
     * "Unknown"
     */
    public String getMessageType() {
        String messageType = elements.get(ELEMENT_MESSAGE_TYPE);

        if (messageType == null) {
            return UNKNOWN_MESSAGE_TYPE;
        } else {
            return messageType;
        }
    }

    /**
     * @param messageType the messageType to set
     */
    public void setMessageType(String messageType) {
        this.elements.put(ELEMENT_MESSAGE_TYPE, messageType);
    }

    /**
     * @return the element value
     * @param element the element identifier associated with the value to be
     * returned
     */
    public String getValue(String element) {
        return elements.get(element);
    }

    /**
     * @param element the element identifier to set
     * @param value the element value to set
     */
    public void setMessageType(String element, String value) {
        this.elements.put(element, value);
    }
//  </editor-fold>
}
