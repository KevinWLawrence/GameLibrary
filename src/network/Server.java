/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author kevin.lawrence
 */
public class Server extends JFrame {

    public static final int DEFAULT_PORT = 9999;
    private int port = DEFAULT_PORT;

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        setLayout(new BorderLayout());
        add(new JScrollPane(jta), BorderLayout.CENTER);

        setTitle("Server");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        System.out.println("ready");

        try {
            //Create Server Socket
            ServerSocket serverSocket = new ServerSocket(getPort());
            appendMessage("Server started on port " + getPort() + " at " + new Date());

            //Listen for connection requests
            Socket socket = serverSocket.accept();

            //Create data input and output streams
//            DataInputStream input = new DataInputStream(socket.getInputStream());
            //BufferedReader input = new BufferedReader(new InputStreamReader(in));
            //BufferedReader input2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String value = "";
            while (true) {
//                double value = input.readDouble();
                System.out.println("listening");
                if (input.ready()) {
                    System.out.println("got data");
                    value = input.readLine();
                    System.out.println(value);
                    appendMessage("Value received: " + value);

                    output.writeDouble(3);
//                output.writeChars("Value received: " + value);
                }
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void appendMessage(String message) {
        if (this.jta == null) {
            System.out.println(message + "\n");
        } else {
            this.jta.append(message + "\n");
        }
    }
}
