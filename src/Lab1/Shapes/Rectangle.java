package Lab1.Shapes;

/**
 * Created by petri on 10/16/2017.
 */
public class Rectangle extends Shape {
    protected int lengthX, lengthY, widthX, widthY;


    public Rectangle (int lengthX,int lengthY, int widthX, int widthY){
        this.name = "Rectangle";
        this.lengthX = lengthX;
        this.widthX = widthX;
        this.lengthY = lengthY;
        this.widthY = widthY;

    }

    public void draw() {

        System.out.println("This is a rectangle with length("+lengthX+","+ lengthY + ")" + "and width("+widthX+ "," + widthY + ")");
    }
}
