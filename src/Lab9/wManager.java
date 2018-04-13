package Lab9;

public class wManager implements Runnable {
    private Thread th;
    private String tName;
    Ex1 s;

    wManager(String name){
        tName = name;
    }
    @Override
    public void run() {
        try {
        for (int i = 5; i>0; i--){
            System.out.println("Thread " + tName + ", " + i);
        }
        synchronized (s){
        }
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s.add("cv");
        s.add("cvgfh");
        s.add("cvg");
        s.add("cvfff");
        s.add("cvffgh");
    }
    public void start(){
        System.out.println("Starting " +tName);
        if (th == null) {
            th = new Thread (this, tName);
            th.start();
        }
    }
}
