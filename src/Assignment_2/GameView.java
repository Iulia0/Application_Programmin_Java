package Assignment_2;
// code copied from Simon Lucas
// code copied by Udo Kruschwitz
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.TreeSet;
// import all the Colors
import static java.awt.Color.*;

public class GameView extends JComponent {
    static Color[] colors =
            {black, green, blue, red,
                    yellow, magenta, pink, cyan};
    int[][] a;
    int w, h;
    static int size = 20;

    public GameView(int[][] a) {
        this.a = a;
        w = a.length;
        h = a[0].length;
    }

//grid of filled squares

    public void paintComponent(Graphics g) {
        // a[6][10] = 3;
        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                g.setColor(colors[a[i][j]]);
                g.fill3DRect(i * size, j * size,
                        size, size, true);
            }
        }
   }


    public Dimension getPreferredSize() {
        return new Dimension(w * size, h * size);
    }
}
