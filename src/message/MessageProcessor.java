/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

/**
 *
 * @author kevin.lawrence
 */
public interface MessageProcessor {
    
    public String getMessageType();
    public void process(String message);
    
    /*
     *  <Message>
     *      <MessageType>
     *          MESSAGE_TYPE
     *      </MessageType>
     *      <Data>
     *          MESSAGE_DATA
     *      </Data>
     *  </Message> 
     */
    
}
