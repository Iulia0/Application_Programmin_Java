package Assignment_2;
import java.awt.*;


public class Triangle extends Shape {
    int xpoints[] = {20, 40, 60};
    int ypoints[] = {200, 80, 200};
    int npoints = 3;

    Triangle(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        xpoints = new int[]{r.nextInt(60), r.nextInt(100), r.nextInt(120)};
        ypoints =  new int[]{r.nextInt(200), r.nextInt(80), r.nextInt(200)};
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getC());
        g2.fillPolygon(xpoints, ypoints, npoints);
    }
    public void setCRandom(Color color) {}
    public void setPosXRandom(int posX) {}
    public void setPosYRandom(int posY) {}
    public void setWidthRandom(int width) {}
    public void setHeightRandom(int height) {}
}
