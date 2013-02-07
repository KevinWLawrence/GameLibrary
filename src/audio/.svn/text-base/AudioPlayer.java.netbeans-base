/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package audio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.*;

/**
 *
 * @author kevinlawrence
 */
public class AudioPlayer extends Thread {

    public enum Position {LEFT, RIGHT, NORMAL};

    private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb
    private final int NO_MORE_DATA = -1;

//    private int loopCount = 1;
    private Position curPosition = Position.NORMAL;
    private AudioInputStream audioInputStream = null;

    public static void play(InputStream audio) {
        new AudioPlayer(audio).start();
    }

    public AudioPlayer(InputStream inputStream) {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(inputStream);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    public AudioPlayer(String fileName) {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(fileName));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    public void run() {
        AudioFormat audioFormat = audioInputStream.getFormat();
        SourceDataLine sourceDataLine = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

        try {
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        if (sourceDataLine.isControlSupported(FloatControl.Type.PAN)) {
            FloatControl pan = (FloatControl) sourceDataLine.getControl(FloatControl.Type.PAN);

            if (curPosition == Position.RIGHT)
                pan.setValue(1.0f);
            else if (curPosition == Position.LEFT)
                pan.setValue(-1.0f);
        }

        sourceDataLine.start();
        int bytesRead = 0;
        byte[] audioBufferData = new byte[EXTERNAL_BUFFER_SIZE];

        try {
            while (bytesRead != NO_MORE_DATA) {
                bytesRead = audioInputStream.read(audioBufferData, 0, audioBufferData.length);
                
                if (bytesRead >= 0)
                    sourceDataLine.write(audioBufferData, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            sourceDataLine.drain();
            sourceDataLine.close();
        }
    }

}
