package office;

public class WorMonitor {
    public boolean [] works;
    
    public boolean checkComplete(){
        for (boolean work : works) {
            if(work == false)
                return false;
        }
        return true;
    }
    
    public void reset(){
        for (int i = 0; i < works.length; i++) {
            works[i] = false;
        }
    }
}

