package Lab3;
import java.awt.*;

public class Square extends Shape {
    Integer sideLength;

    Square(Integer posX, Integer posY, Integer sideLength) {
        this.posX = posX;
        this.posY = posY;
        this.sideLength = sideLength;
    }
    public static void paint(Graphics g ) {
        g.setColor(Color.BLUE);
        g.fillRect( 500, 80, 150, 150 );
    }
}

