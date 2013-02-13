/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package environment;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author kevinlawrence
 */
public class ApplicationStarter {
    public static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(900, 600);
    
    public static void run(String[] args, String appName, Dimension appSize, Environment environment) {
        JFrame frame = new JFrame(appName);

        frame.add(environment);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(appSize);
        frame.setVisible(true);
    }

    public static void run(String appName, Environment environment) {
        run(new String[0], appName, DEFAULT_WINDOW_SIZE, environment);
    }
}
