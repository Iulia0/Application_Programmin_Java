package Assignment_2;

import javax.swing.*;
import java.io.IOException;

public class TestPong {
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameFrame game = new GameFrame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
