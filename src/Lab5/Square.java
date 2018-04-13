package Lab5;

/**
 * Created by petri on 11/12/2017.
 */
public class Square implements Comparable<Square> {
    int l;

    Square(int l){
        this.l = l;
    }
    public int area(){
        return l*l;
    }

    @Override
    public int compareTo(Square other) {
        return Double.compare(this.area(),other.area());
    }
}
