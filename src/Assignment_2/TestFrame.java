package Assignment_2;
// code copied from Simon Lucas
// code copied by Udo Kruschwitz


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class TestFrame extends JFrame {
    public Component comp;
    DrawShape myDrawShape = new DrawShape(); // This is the panel of the game class
    public final int FRAMEWIDTH =1020;
    public final int FRAMEHEIGHT =850;

    public TestFrame(Component comp, String title) {
        super(title);
        this.comp = comp;
        setFocusable( true );
        setSize(FRAMEWIDTH,FRAMEHEIGHT);
        this.setVisible(true);
        repaint();
        getContentPane().add(BorderLayout.CENTER, comp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {myDrawShape.keyPressed(e);
            }
            public void keyReleased(KeyEvent e) {myDrawShape.keyReleased(e);
            }
        });
    }
}
