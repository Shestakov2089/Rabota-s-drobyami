
package library;

import java.util.ArrayList;

public interface Student {
    public ArrayList<Mark> getAllMarksBySubject(Subject sub);
    
    public ArrayList<Mark> getAllMarksByStudent();
    
    public String getName();
    
    public String getSurname();
}
