package Lab9;


public class Customer implements Runnable{
    private Thread th;
    private String tName;

    Customer(String name){
        tName = name;
        System.out.println("Creating " + tName);
    }
    @Override
    public void run() {
        System.out.println("Running " + tName);
        for (int i = 5; i>0; i--){
            System.out.println("Thread " + tName + ", " + i);
        }

    }
    public void start(){
        System.out.println("Starting " +tName);
        if (th == null) {
            th = new Thread (this, tName);
            th.start();
        }
    }
}
