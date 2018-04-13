package Assignment_2;
// code copied from Simon Lucas
// code copied by Udo Kruschwitz
// code updated by Ian Daly

import javax.swing.*;

public class TestShapes {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DrawShape shapes = new DrawShape();
                new TestFrame(shapes, "Iulia Petria, 1601159");
            }
        });
    }
}