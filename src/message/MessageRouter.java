/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.util.HashMap;

/**
 *
 * @author kevin.lawrence
 */
public class MessageRouter {
    private HashMap<String, MessageProcessor> processors = new HashMap<String, MessageProcessor>();
    
//    <editor-fold defaultstate="Collapsed" desc="Methods">
    public void registerMessageProcessor(MessageProcessor processor){
       this.processors.put(processor.getMessageType(), processor);
    }
    
    public void unregisterMessageProcessor(String messageType){
        this.processors.remove(messageType);
    }
        
    public boolean routeMessage(String message){
        String messageID = getMessageID(message);

        MessageProcessor processor = this.processors.get(messageID);
        
        if (processor == null){
            return false;
        } else {
            processor.process(message);
            return true;
        }
    }

    private String getMessageID(String message) {
        // convert message to XML
        // extract message element "MessageType"
        
        
        return "";
    }
//    </editor-fold>
    
}
