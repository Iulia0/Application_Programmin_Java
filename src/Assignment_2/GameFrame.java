package Assignment_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.IOException;



public class GameFrame extends JFrame {
    Pong myPong = new Pong(); // This is the panel of the game class

    public GameFrame() throws IOException {
        this.setResizable(false);
        this.setMinimumSize(new Dimension(myPong.getFrameWidth(), myPong.getFrameHeight()));
        this.setMaximumSize(new Dimension(myPong.getFrameWidth(), myPong.getFrameHeight()));
        getContentPane().add(BorderLayout.CENTER, myPong);
        setTitle("Iulia Petria, 1601159");
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                myPong.keyPressed(e);
            }
            public void keyReleased(KeyEvent e) {myPong.keyReleased(e);
            }
        });
    }
}
