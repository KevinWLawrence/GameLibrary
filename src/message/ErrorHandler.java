/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import message.MessageProcessor;

/**
 *
 * @author kevin.lawrence
 */
public class ErrorHandler implements MessageProcessor {

    @Override
    public String getMessageType() {
        return "error";
    }

    @Override
    public void process(String message) {
        
    }
    
}
