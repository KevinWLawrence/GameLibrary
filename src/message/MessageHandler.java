/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

/**
 *
 * @author kevin.lawrence
 */
public class MessageHandler implements MessageProcessor {

    @Override
    public String getMessageType() {
        return "text";
    }

    @Override
    public void process(String message) {
        
    }
    
}
