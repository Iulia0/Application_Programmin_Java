package Assignment_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CE203_2017_EX1 extends JFrame {
    JTextField first, second, third, result;  // text fields listening for user input, first 3 for RGB color, last one for displaying the text
    JButton set,reset; // set the RGB color, and reset back to default
    JPanel bottom, center, top; // Jpanels positioned accordingly, south, center and north
    Color color = new Color(0, 0, 255);  // the color for the text (String "initial")
    String initial = "CE203 Assignment 1, submitted by: Iulia Petria, 1601159";  // text displayed on the centre

    CE203_2017_EX1() {
        bottom = new JPanel();
        center = new JPanel(new BorderLayout());
        top = new JPanel(new FlowLayout());

        JLabel prompt = new JLabel("Type a number and press the button");

        first = new JTextField(2);
        second = new JTextField(2);
        third = new JTextField(2);
        result = new JTextField();

        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        result.setFont(font1);
        result.setHorizontalAlignment(JTextField.CENTER);

        set = new JButton("set RGB color");
        reset = new JButton("Reset");

        bottom.add(prompt);
        bottom.add(first);
        bottom.add(second);
        bottom.add(third);
        bottom.add(set);
        center.add(result);
        top.add(reset, BorderLayout.NORTH);

        result.setEditable(false);
        result.setForeground(color);
        result.setText(initial);


        ButtonHandler handle = new ButtonHandler(this);
        set.addActionListener(handle);
        reset.addActionListener(handle);

        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        add(top, BorderLayout.NORTH);
        setSize(800, 600);
    }

    //handles the actions for every button pressed
    class ButtonHandler implements ActionListener {
        CE203_2017_EX1 theApp;

        ButtonHandler(CE203_2017_EX1 theApp) {
            this.theApp = theApp;
        }
        //
        @Override
        public void actionPerformed(ActionEvent e) {
            // change the text's color
            if (e.getSource() == set) {
                try {
                    clearInvalidField(first);
                    clearInvalidField(second);
                    clearInvalidField(third);

                    Integer first = Integer.parseInt(theApp.first.getText());
                    Integer second = Integer.parseInt(theApp.second.getText());
                    Integer third = Integer.parseInt(theApp.third.getText());

                    theApp.color = new Color(findValue(first,theApp.first), findValue(second,theApp.second), findValue(third,theApp.third));
                    result.setText("Iulia Petria, 1601159");
                    result.setForeground(color);
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "You have to input a number in every box, try again");
                }

            }
            // reset text fields and text color
            else if (e.getSource() == theApp.reset){
                theApp.first.setText("");
                theApp.second.setText("");
                theApp.third.setText("");
                theApp.color = new Color(0,0,255);
                result.setText(initial);
                result.setForeground(color);
            }
        }
    }

    //  check the text fields for input, if not digit, set to null
    private void clearInvalidField (JTextField f) {
        try {
            Integer field = Integer.parseInt(f.getText());
        }
        catch (NumberFormatException e){
            f.setText("");
        }
    }
    // if input lower than 0 set the value to 200, if higher than 255 set it to 255
    private Integer findValue(Integer number, JTextField f){
        if (number <= -1){
            number = 200;
            f.setText(Integer.toString(number));
        }
        else if (number > 255){
            number = 255;
            f.setText(Integer.toString(number));
        }
        return number;
    }

    public static void main(String[] args) {
        CE203_2017_EX1 pickColor = new CE203_2017_EX1();
        pickColor.setVisible(true);
    }
}


