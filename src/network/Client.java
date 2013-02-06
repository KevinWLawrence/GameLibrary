/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import message.Message;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author kevin.lawrence
 */
public class Client extends JFrame {

    private JTextField jtfMessage = new JTextField();
    private JTextArea jta = new JTextArea();
    private PrintWriter output;
    private DataInputStream input;

    public Client() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Message"), BorderLayout.WEST);

        panel.add(jtfMessage, BorderLayout.CENTER);
        jtfMessage.setHorizontalAlignment(JTextField.RIGHT);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(jta), BorderLayout.CENTER);

        jtfMessage.addActionListener(new TextFieldListener());

        setTitle("Client");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            Socket socket = new Socket("localhost", Server.DEFAULT_PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new PrintWriter(socket.getOutputStream(), true);
//            output = new DataOutputStream(socket.getOutputStream());
        } catch (Exception ex) {
            appendMessage("Error: " + ex.toString());
        }
    }

    private void appendMessage(String message) {
        if (jta == null) {
            System.out.println(message + "\n");
        } else {
            jta.append(message + "\n");
        }

        testMessage();
    }

    private void testMessage() {
        String xml = "   <Message> "
                + "        <MessageType>move</MessageType> "
                + "        <Data>"
                + "          <OriginalLocationColumn>3</OriginalLocationColumn>"
                + "          <OriginalLocationRow>0</OriginalLocationRow>"
                + "          <NewLocationColumn>2</NewLocationColumn>"
                + "          <NewLocationRow>3</NewLocationRow>"
                + "          <Bob>99</Bob>"
                + "        </Data>"
                + "      </Message>";

        Message msg = new Message(xml);
        
        String xml2 = msg.getXML();
        System.out.println(xml + "/n");
        System.out.println(xml2);
        
        output.println(xml2 + "/n");
        output.flush();
    }

    private class TextFieldListener implements ActionListener {

        public TextFieldListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
//                Double value = Double.parseDouble(jtfMessage.getText().trim());
//                output.writeChars("Value from client = " + jtfMessage.getText() + '\n');
                output.println("Value from client = " + jtfMessage.getText());
                output.flush();

                Double avalue = input.readDouble();
                appendMessage("Received from server: " + avalue);

            } catch (Exception ex) {
                appendMessage("Error: " + ex.toString());
            }
        }
    }
}