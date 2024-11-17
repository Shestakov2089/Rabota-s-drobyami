package tictactoe1;

public class TicTacToe1 {
    public static final int x = 3;
    public static final int count = 3;
    
    public static void main(String[] args) throws InterruptedException {
        Monitor mon = new Monitor();
        mon.x = 1;
        ThreadOne[] threads = new ThreadOne[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new ThreadOne(mon,i+1);
        }
        
        for (int i = 0; i < count; i++) {
            threads[i].self.start();
        }
        
        for (int i = 0; i < count; i++) {
            threads[i].self.join();
        }
    }
}
