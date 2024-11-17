package office;

public class Office {
    public static int x = 10;
    public static int count = 10;
    
    public static void main(String[] args) throws InterruptedException {
        WorMonitor monw = new WorMonitor();
        monw.works = new boolean[count];
        
        ManMonitor mon = new ManMonitor();
        
        Manager manager = new Manager(mon, monw);
        manager.self.start();
       
        Worker[] workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(mon,monw,i);
        }
        
        for (int i = 0; i < count; i++) {
            workers[i].self.start();
        }
        
        manager.self.join();
        
    } 
}
