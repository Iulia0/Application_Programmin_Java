package Assignment_2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener {
    boolean downStatus;
    boolean upStatus;

    KeyHandler(boolean downStatus, boolean upStatus) {
        this.downStatus = downStatus;
        this.upStatus = upStatus;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // Listen to key pressed events
    public void keyPressed(KeyEvent e) {
        // Move lines (ships) boolean to true
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            downStatus = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            upStatus = true;
        }
    }

    // Listen to key released events
    public void keyReleased(KeyEvent e) {
        // Move lines (ships) boolean to false
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            downStatus = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            upStatus = false;
        }
    }
}