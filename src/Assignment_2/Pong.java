package Assignment_2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Pong extends JComponent implements Runnable, KeyListener, MouseListener {
    private final int FRAMEWIDTH = 500;// frame's width
    private final int FRAMEHEIGHT = 900;// frame's height
    private Thread myThread = new Thread(this); // game's thread
    private Circle ball; // ball used for the game
    private Rectangle leftSide, rightSide; // left and right lines(ships) used to pass the ball
    private boolean upStatus, downStatus; //listen for key events
    private boolean  gameOver; //game over
    private boolean gameStatus = true;// used to stop the game
    private boolean onClick = false;// listen for click events
    private int rightLineX = 870, rightLineY = 100; // X and y positions right line(ship)
    private int leftLineX = 10, leftLineY = 100;//x and y positions for left line(ship)
    private int lineHeight = 55;// height of lines
    private int ballX = 50, ballY = 150; // x and y positions for ball
    private int ballSize = 15;// ball dimension
    private int right = 10; // to the right
    private int left = -10; //to the left
    private int up = 10; // upward
    private int down = -10; // downward
    private int width, height; // Width and height of the ball
    private int lives = 4;     // lives left
    int score = -5;     //used to display the score and also to pass it to the Score class
    Score scoreList; // used to add score to the file


    Pong() throws IOException {
        addKeyListener(new KeyHandler(upStatus, downStatus));
        addMouseListener(this);
        myThread.start();
    }
    //return width for frame
    public int getFrameWidth(){
        return FRAMEHEIGHT;
    }
    // return height for frame
    public int getFrameHeight(){
        return FRAMEWIDTH;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball = new Circle(ballX, ballY, ballSize, ballSize);
        ball.setCRandom(ball.getC());
        ball.draw(g);

        leftSide = new Rectangle(leftLineX, leftLineY, 15, lineHeight);
        leftSide.setC(Color.black);
        leftSide.draw(g);

        rightSide = new Rectangle(rightLineX, rightLineY, 15, lineHeight);
        rightSide.setC(Color.BLACK);
        rightSide.draw(g);
        g.drawString("Lives " + lives, 850, 15);
        g.setColor(Color.blue);

        g.drawString("Score " + score, 0, 15);

        if (gameOver) {
            g.drawString("Game Over", 420, 0);
        }
    }

    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {
        onClick = true;
    }
    public void mouseReleased(MouseEvent e) {
        onClick = false;
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void keyTyped(KeyEvent e) {}
    // Listen to key pressed events
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downStatus = true;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            upStatus = true;
        }
    }
    // Listen to key released events
    @Override
    public void keyReleased(KeyEvent e) {
        // Move lines (ships) boolean to false
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downStatus = false;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            upStatus = false;
        }
    }
    //get height and weight space
    public void getDimension(){
        this.height =this.getHeight();
        this.width =this.getWidth();
    }
    // move left line(ship)
    public void moveLeftLine() {
        if (downStatus && leftLineY <= (this.getHeight()-65))
            leftLineY += up;
        if (upStatus && leftLineY >= 5)
            leftLineY += down;
        repaint();
    }
    // move right line(ship)
    public void moveRightLine() {
        if (downStatus && rightLineY <= (this.getHeight()-65))
            rightLineY += up;
        if (upStatus && rightLineY >= 5)
            rightLineY += down;
        repaint();
    }
    public void mouseClick(){
        if (onClick){
            try {                          // Delay
                Thread.sleep(200);
            }
            catch(InterruptedException ex) {
            }
        }
        repaint();
    }
    public void run() {
        boolean leftRight=false;
        boolean upDown=false;

        while(true){
            if(gameStatus){
                if (upDown) {
                    //change direction if up or down wall hit
                    ballY = ballY + up;
                    if (ballY + ballSize > height) {
                        upDown = false;
                    }
                }
                else {
                    ballY = ballY + down;
                    if ( ballY <= 0)
                        upDown = true;
                }
                //change direction if left or right wall hit
                if (leftRight) {
                    ballX += right;
                    if (ballX < 0 || ballX > width - ballSize) {
                        leftRight = false;
                    }
                }
                else {
                    ballX = ballX + left;
                    if (ballX <= 0) {
                        leftRight = true;
                    }
                }
                getDimension();
                repaint();
                try {                          // Delay
                    Thread.sleep(50);
                }
                catch(InterruptedException ex) {
                }
                moveLeftLine();
                moveRightLine();
                mouseClick();
                if (ballX >= (width - ballSize))
                    lives--;
                if ( ballX == 0)
                    lives--;

                if( ballY >= rightLineY && ballX ==(rightLineX -10) && ballY <=(rightLineY + lineHeight)) {
                    leftRight = false;
                    score += 5;
                }
                if( ballY >= leftLineY && ballX == leftLineX + 10 && ballY <=(leftLineY + lineHeight)) {
                    leftRight = true;
                    score += 5;
                }
                if(lives == 0 ) {
                    gameStatus = false;
                    gameOver = true;
                    try {
                        scoreList = new Score(score);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    scoreList.score = score;
                    try {
                        JOptionPane.showMessageDialog(null, "Your top 10 scores for the past 24 hrs : " + scoreList.topScores());
                        JOptionPane.showMessageDialog(null, "Your top 10 scores " + scoreList.topScoresAll());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}