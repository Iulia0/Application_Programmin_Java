package Lab3;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tongue extends JPanel{
    private BufferedImage image;

    public Tongue (){
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tongue.gif"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        repaint();
    }

    public void paint (Graphics g) {
        g.drawImage(image, 300, 300, image.getWidth()  , image.getHeight()  , null);
    }
}
