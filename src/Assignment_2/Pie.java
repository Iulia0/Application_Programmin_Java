package Assignment_2;


import java.awt.*;

public class Pie extends Shape{
    int size;

    Pie(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        size = r.nextInt(100);

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getC());
        g2.fillArc(getPosX(), getPosY(), getWidth(), getHeight() , 1, 110);
    }
    public void setCRandom(Color color){setC(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255))) ;}
    public void setPosXRandom(int posX){setPosX(r.nextInt(400));}
    public void setPosYRandom(int posY){setPosY(r.nextInt(400));}
    public void setWidthRandom(int width){setWidth(size);}
    public void setHeightRandom(int height){setHeight(size);}
}
