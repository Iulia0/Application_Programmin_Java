package Lab9;

public class Test {
    public static void main(String[] args) {
        wManager r1 = new wManager("Thread_A");
        Customer r2 = new Customer( "Thread_B" );
        Ex1 s =  new Ex1(r2, r1);
        Test t = new  Test();
        s.setVisible(true);
        r1.start();
        r2.start();
        }
    }
