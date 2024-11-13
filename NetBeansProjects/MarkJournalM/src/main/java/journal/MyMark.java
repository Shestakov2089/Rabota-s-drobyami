
package journal;

import library.Mark;
import library.Subject;


public class MyMark implements Mark{
    private int value;
    private Subject sub;

    public MyMark(int value, MySubject sub) {
        this.value = value;
        this.sub = sub;
    }
    
    public String getSubjectName(){
        return sub.getName();
    }

    @Override
    public String toString() {
        return sub + ": " + value;
    }

    @Override
    public int getValue() {
        return value;
    }
    
}
