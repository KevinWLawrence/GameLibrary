/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author kevin.lawrence
 */
public class GameServer {
    public static final int DEFAULT_PORT = 9999;
    private JFrame frame;
    
//    public GameServer(int port){ 
    public GameServer(){
        InetAddress ip = null;        
        try {
            ip = InetAddress.getByName("localhost");
        } catch (UnknownHostException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
//        frame = ApplicationStarter.run(new String[0], "Game Server", new Dimension(400, 300), new ServerView("Server Test", ip , DEFAULT_PORT));
        
//        System.out.println("1");
////        ServerView svPanel = new ServerView("Server Test", ip , DEFAULT_PORT);
////        PlainServerView svPanel = new PlainServerView();
//        ServerView2 svPanel = new ServerView2();
//        System.out.println("2");
//        frame = ApplicationStarter.run(new String[0], "Game Server", new Dimension(400, 300), svPanel);
//        System.out.println("3");
    }
    
}
