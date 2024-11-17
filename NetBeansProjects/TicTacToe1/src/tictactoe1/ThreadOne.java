package tictactoe1;

public class ThreadOne implements Runnable{
    public Monitor mon;
    public Thread self;
    public int num;

    public ThreadOne(Monitor mon, int num) {
        self = new Thread(this);
        this.mon = mon;
        this.num = num;
    }
    
    

    @Override
    public void run() {
        for (int i = 0; i < TicTacToe1.x; i++) {
            synchronized(mon){
                
                while(mon.x != num){
                    try{
                        mon.wait();
                    }catch(InterruptedException ex){}
                }
                
                if(mon.x != TicTacToe1.count){
                    System.out.print(mon.x + " - ");
                    mon.x++;
                }
                else {
                    System.out.println(mon.x);
                    mon.x = 1;
                }
                
                mon.notifyAll();
            }
        }
    }
}
