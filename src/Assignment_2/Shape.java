package Assignment_2;


import java.awt.*;
import java.util.Random;



abstract public class Shape  {
     private int posX, posY, width, height;
     private Color color;
     Random r = new Random();

    Shape(int posX, int posY, int width, int height){
        this.posY = posY;
        this.posX =posX;
        this.width = width;
        this.height = height;
    }
    public abstract void draw(Graphics g);
    public Color getC(){return color;}
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void setPosX( int posX) {
        this.posX = posX;
    }
    public void setPosY( int posY) {this.posY = posY;}
    public void setWidth( int width) {
        this.width = width;
    }
    public void setHeight( int height) {
        this.height = height;
    }
    public void setC(Color color){
        this.color = color;
    }
   abstract public void setCRandom(Color color);
   abstract public void setPosXRandom(int posX);
   abstract public void setPosYRandom(int posY);
    abstract public void setWidthRandom(int width);
    abstract public void setHeightRandom(int height);
}

