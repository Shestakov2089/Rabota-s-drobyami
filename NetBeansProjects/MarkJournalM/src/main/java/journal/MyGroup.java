
package journal;

import java.util.ArrayList;
import library.Group;
import library.Mark;
import library.Student;
import library.Subject;


public class MyGroup implements Group {
    private int name1;
    private String name2;
    private ArrayList<Student> students;
 

    public MyGroup(int name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
        students = new ArrayList<>();
    }
    
   
    @Override
    public String toString() {
        return name1 + "-" + name2;
    }

    @Override
    public void addStudent(Student stud) {
        students.add(stud);
    }

    @Override
    public Student getStudent(String surname) {
        for (Student student : students) {
            if(student.getSurname().equals(surname)) return student;
        }
        return null;
    }

    @Override
    public Student getStudent(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public ArrayList<String> createStringJournalBySubject(Subject s) {
        ArrayList<String> st = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.getSurname());
            sb.append(" ");
            sb.append(student.getName());
            sb.append(":");
            for (Mark mark : student.getAllMarksBySubject(s)) {
                sb.append(" ");
                sb.append(mark.getValue());
            }
            st.add(sb.toString());
            sb.setLength(0);
        }
        return st;
    }

    @Override
    public String getNameGroup() {
        return name1+name2;
    }

    
}
