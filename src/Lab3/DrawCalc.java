package Lab3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawCalc extends JFrame{
    JPanel one, two;
    Square sq;
    Circle circle;
    JButton set, calcArea, set2, calcArea2;
    JTextArea myTextArea;
    String area = "0";


    DrawCalc(JPanel one, JPanel two, Square sq, Circle circle){
        this.one = one;
        this.two = two;
        this.sq = sq;
        this.circle = circle;


        ButtonHandler bh1 = new ButtonHandler(this, 1);
        ButtonHandler bh2 = new ButtonHandler(this, 2);
        ButtonHandler bh3 = new ButtonHandler(this, 3);
        ButtonHandler bh4 = new ButtonHandler(this, 4);


        myTextArea = new JTextArea(area,1,1 );
        set = new JButton("set(Square)");
        calcArea = new JButton("calc area(Square)");
        set2 = new JButton("set(Circle)");
        calcArea2 = new JButton("calc area (Circle)");

        two.add(myTextArea);
        two.add(set);
        two.add(calcArea);
        two.add(set2);
        two.add(calcArea2);

        set.addActionListener(bh1);
        calcArea.addActionListener(bh2);
        set2.addActionListener(bh3);
        calcArea2.addActionListener(bh4);

        add(one, BorderLayout.CENTER);
        add(two, BorderLayout.PAGE_END);
        setSize(800,600);

    }
    class ButtonHandler implements ActionListener {
        DrawCalc theApp;
        int action;

        ButtonHandler (DrawCalc theApp, int action){
            this.theApp = theApp;
            this.action = action;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == theApp.set){
                Integer no = Integer.parseInt(myTextArea.getText());
                sq.sideLength = no;
            }
            else if(e.getSource() == theApp.calcArea){
                area = Integer.toString(sq.sideLength * sq.sideLength);
                myTextArea.setText(area);
            }
            else if (e.getSource() == theApp.set2){
                Integer no = Integer.parseInt(myTextArea.getText());
                circle.radius = no;
            }
            else if(e.getSource() == theApp.calcArea2){
                area = Integer.toString(Integer.valueOf((int)(Math.PI * (circle.radius * circle.radius))));
                myTextArea.setText(area);
            }
        }
    }

    public static void main(String[] args) {
        Tongue tongue = new Tongue();
        JPanel squareCircle = new JPanel() {

            public void paintComponent(Graphics graph) {
                Square.paint(graph);
                Circle.paint(graph);
                tongue.paint(graph);
            }
        };
        DrawCalc progr = new DrawCalc(squareCircle, new JPanel(), new Square(450,50,0), new Circle(250,50, 1));
        progr.setVisible(true);
    }
}
