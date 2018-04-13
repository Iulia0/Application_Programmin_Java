package Lab9;

import Lab1.Employees.Manager;
import javafx.scene.shape.CubicCurveTo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ex1<T> extends JFrame{
    wManager manager;
    Customer customer;
    JTextField first, second;
    JButton add,remove;
    JPanel b, c;
    private T t;
    ArrayList<String> stock;
    ButtonHandler but;
    Ex1(Customer cust, wManager man){
        this.customer = cust;
        this.manager=man;
        manager = new wManager("s");
        customer = new Customer("sd");
        but = new ButtonHandler();
        first = new JTextField(5);
        first.setEditable(true);
        second = new JTextField(5);
        second.setEditable(true);
        add = new JButton("Add");
        add.addActionListener(but);
        remove = new JButton("Remove");
        remove.addActionListener(but);
        stock = new ArrayList<>();
        b = new JPanel();
        c = new JPanel();
        c.add(first);
        c.add(second);
        b.add(remove);
        b.add(add);

        add(BorderLayout.CENTER, c);
        add(BorderLayout.NORTH, b);
        setSize(800, 600);
    }
    public ArrayList<String> get(){
        return this.stock;
    }
    public void set (T t1){
        this.t = t1;
    }
    public void add(T t){
        stock.add((String) t);
    }
    public void remove(T t){
        stock.remove(t);
    }
    class ButtonHandler implements ActionListener{
        ButtonHandler() {

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == add){
                manager.start();
                manager.run();
            }
            else if (e.getSource()== remove){
                customer.start();
                customer.run();

            }
        }
    }

}
