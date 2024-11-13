package journal;

import library.Subject;

public class MySubject implements Subject{
    private String nameSub;

    public MySubject(String nameSub) {
        this.nameSub = nameSub;
    }
    


    @Override
    public String getName() {
        return nameSub;
    }

 
    @Override
    public void setName(String name) {
        nameSub = name;
    }

    @Override
    public String toString() {
        return nameSub;
    }
    
}
