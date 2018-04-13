package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FilledFrame extends JFrame
{
    int size = 400;
    int smallSize = 100;
    int mediumSize = 200;


    public FilledFrame()
    {
        JButton butSmall   = new JButton("Small");
        butSmall.setBackground(Color.red);
        JButton butMedium  = new JButton("Medium");
        butMedium.setBackground(Color.yellow);
        JButton butLarge   = new JButton("Large");
        butLarge.setBackground(Color.blue);
        JButton butMessage = new JButton("Say Hi!");

        SquarePanel panel = new SquarePanel(this);
        JPanel butPanel = new JPanel();

        butPanel.add(butSmall);
        butPanel.add(butMedium);
        butPanel.add(butLarge);
        butPanel.add(butMessage);
        add(butPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setSize( size+100, size+200 );


        butSmall.addActionListener(new ButtonHandler(this, smallSize));
        butMedium.addActionListener(new ButtonHandler(this, mediumSize));
        butLarge.addActionListener(new ButtonHandler(this, size));

        butMessage.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Hi");
            }
        });


    }

}

