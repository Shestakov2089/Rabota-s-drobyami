
package racionalchis;

import java.util.Arrays;



public class RacionalChis {


    public static void main(String[] args) {
 
          
        Fraction f1 = new Fraction(4, 16);          
        Fraction f2 = new Fraction(1, 4);
        Fraction f3 = new Fraction(1, 5);
        Fraction f5 = f1.addTo(f2).addTo(new Fraction(1, 2));//addTo(f1);
        
        System.out.println(f1);
          
        Fraction[] fs = {f1,f2,f3,(new Fraction (-3,4))};
          
        Arrays.sort(fs);
        for (Fraction f : fs) {
            System.out.println(f);   
        }
          

    }
    
}
