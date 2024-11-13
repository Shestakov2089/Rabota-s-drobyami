
package library;

import java.util.ArrayList;


public interface Group {
   public void addStudent(Student stud);
   
   public Student getStudent(String surname);
   
   public Student getStudent(int id);
   
   public ArrayList<Student> getStudents();
   
   public ArrayList<String> createStringJournalBySubject(Subject s);
   
   public String getNameGroup();
   
}
