
package racionalchis;

public class Fraction implements Comparable<Fraction>{
    private int whole, chis, znam, nod;

    public Fraction() {
        this(0,1);
    }
    
    public Fraction(int chis, int znam) {
        this.chis = chis;
        this.znam = znam;
        makeShort();
        nod();
        
    }
   

    public int getChis() {
        return chis;
    }

    public void setChis(int chis) {
        this.chis = chis;
        makeShort();
        
    }

    public int getZnam() {
        return znam;
    }

    public void setZnam(int znam) {
        this.znam = znam;
        makeShort();
       
    }
    
    public Fraction addTo(Fraction f) {
        return new Fraction(chis * f.znam + znam * f.chis, znam * f.znam);
    }
    
    @Override
    public int compareTo(Fraction o) {
        if (chis * o.znam > o.chis * znam) {
            return 1;
        } 
        if (chis * o.znam < o.chis * znam) {
            return -1;
        }
        return 0;
         
    }
    
    
    
    private int nod() {
        int tmp, a = chis, b = znam;
        if (a < b){
            tmp = a;
            a = b;
            b = tmp;
        }
        while ((a % b) !=0) {
            a = a % b;
            tmp = a;
            a = b;
            b = tmp;
        }
        return b;
    }
    
   
    
    private void makeShort() {
        int nod = nod();
        chis = chis/nod;
        znam = znam/nod;
    }

    @Override
    public String toString(){
//        whole = chis/znam;
//        if (whole != 0)
//            return whole + " " + chis/znam + "/" + znam;
//        else
        return chis + "/" + znam;
          
    }
  
}
