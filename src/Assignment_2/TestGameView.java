package Assignment_2;
// code copied from Simon Lucas
// code copied by Udo Kruschwitz
// code updated by Ian Daly
import java.util.Random;

public class TestGameView {
    public static void main(String[] args) {
        // test the view component
        Random r = new Random();
        int w = 50;
        int h = 40;
        int[][] a = new int[w][h];
        for (int i = 0; i < w; i++)
        {
            for (int j = h/2; j < h; j++)
            {
                a[i][j] = r.nextInt(GameView.colors.length);
            }
        }
        GameView tv = new GameView(a);
        new TestFrame(tv, "Iulia Petria, 1601159");
    }
}