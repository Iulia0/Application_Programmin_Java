package Assignment_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;


public class DrawShape extends JComponent implements KeyListener, Runnable {
    private Thread myThread = new Thread(this); // game's thread
    private Square mySquare;// square to be drawn
    private Circle myCircle;// circle to be drawn
    private Triangle myTriangle;// triangle to be drawn
    private Pie myPie;// pie to be drawn
    private Rectangle myRectangle;//rectangle to be drawn
    private Collection<Shape> myShapes;//collection holding shapes to be drawn
    private boolean upStatus, downStatus, leftStatus, rightStatus;// key events listeners
    private int posX = 25, posY = 50;
    private int right = 10; // to the right
    private int left = -10; //to the left
    private int up = 10; // upward
    private int down = -10; // down

    DrawShape() {
        // Create Shapes, shape collection, add shapes to to the collection
        mySquare = new Square(posX+50, posY+56, 25, 25);
        myCircle = new Circle(posX+100, posY, 25, 25);
        myRectangle = new Rectangle(posX+200, posY, 25, 10);
        myTriangle = new Triangle(posX, posY+300, 25, 25);
        myPie = new Pie(posX, 150, posY, 25);
        mySquare.setCRandom(mySquare.getC());
        myCircle.setCRandom(myCircle.getC());
        myRectangle.setCRandom(myRectangle.getC());
        myTriangle.setCRandom( myTriangle.getC());
        myPie.setCRandom(myPie.getC());
        myShapes = new ArrayList<>();
        myShapes.add(mySquare);
        myShapes.add(myCircle);
        myShapes.add(myRectangle);
        myShapes.add(myTriangle);
        myShapes.add(myPie);

        myThread.start();
    }
    //  Draw shapes to the frame
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : myShapes){
            shape.draw(g);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // Move lines (ships) boolean to false
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upStatus = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downStatus = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftStatus = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightStatus = false;
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upStatus = true;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downStatus = true;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftStatus = true;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightStatus = true;
            }
        }
    }

    public void move(){
        if(upStatus){
            posX += up;
        }
        if (downStatus){
            posX += down;
        }
        if(leftStatus){
            posY += left;
        }
        if (rightStatus){
            posY += right;
        }
        repaint();
    }

    @Override
    public void run() {
        while(true) {

            for (Shape shape : myShapes) {
                try {
                    Thread.sleep(50);
                }
                catch(InterruptedException ex) {
                }
                move();
            }
        }
    }
}
