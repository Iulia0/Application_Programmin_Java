package Lab3;

import java.awt.*;

public class Circle extends Shape {
    Integer radius;

    Circle (Integer posX, Integer posY, Integer radius){
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }

    public static void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(170,80,150,150);
    }
}
