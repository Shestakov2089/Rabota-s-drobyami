package office;

public class Worker implements Runnable{
    public Thread self;
    public WorMonitor monw;
    public int num;
    public int[] worker;
    public ManMonitor mon;

    public Worker(ManMonitor mon, WorMonitor monw, int num) {
        this.monw = monw;
        this.num = num;
        this.mon = mon;
        self = new Thread (this);
        
        
    }

    @Override
    public void run() {
        for (int i = 0;; i++) {
            if (i == Office.x)
                break;
            synchronized (monw){
                while(monw.works[num] == true){
                    try{
                        monw.wait();
                    } catch(InterruptedException ex) {}
                }
            }
            
            System.out.print(num + " ");
            
            synchronized (monw) {
                monw.works[num] = true;    
                if(monw.checkComplete()){
                    synchronized (mon) {
                        mon.notify();
                    }
                    try{
                        monw.wait();
                    } catch(InterruptedException ex) {}
                }
                monw.notifyAll();
            }
            
        }
    }
    
}
