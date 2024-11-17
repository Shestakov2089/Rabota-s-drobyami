package office;

public class Manager implements Runnable{
    public Thread self;
    public ManMonitor mon;
    public WorMonitor monw;

    public Manager(ManMonitor mon, WorMonitor monw) {
        this.mon = mon;
        this.monw = monw;
        self = new Thread(this);
    }
    

    @Override
    public void run() {
        for (int i = 0; ; i++) {
            if(i == Office.x)
                break;
            synchronized (mon) {
                try {
                   mon.wait(); 
                } catch(InterruptedException ex) {}  
            }
            
            System.out.println(" - " + (i + 1));
            
            synchronized (monw) {
                monw.reset();
                monw.notifyAll();
            }
        }
    }

}
