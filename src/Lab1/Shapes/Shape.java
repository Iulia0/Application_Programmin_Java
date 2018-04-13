package Lab1.Shapes;

/**
 * Created by petri on 10/16/2017.
 */
public abstract class Shape {

    protected String name="shape";
    protected String color="black";

    public void printName() {
        System.out.println("I am a "+color+" "+name);
    }

    public abstract void draw();
}