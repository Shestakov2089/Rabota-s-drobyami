package journal;

import java.util.ArrayList;
import java.util.stream.Collectors;
import library.Mark;
import library.Student;
import library.Subject;


public class MyStudent implements Student{
    private String name;
    private String surname;
    private MyGroup group;
    ArrayList<MyMark> marks;
    

    public MyStudent(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.marks = new ArrayList();
    }

    public MyStudent(String name, String surname, ArrayList<MyMark> marks) {
        this.name = name;
        this.surname = surname;
        this.marks = marks;
    }
    
    

    @Override
    public String toString() {
        return name + ", " + surname + " [" + printMarks() + "]";
    }
    
    private String printMarks(){
        return marks.stream().map(Object::toString)
                        .collect(Collectors.joining(", "));
    }

    @Override
    public ArrayList<Mark> getAllMarksBySubject(Subject sub) {
        ArrayList<Mark> ms = new ArrayList<>();
        for (MyMark mark : marks) {
            if (mark.getSubjectName().equals(sub.getName())){
                ms.add(mark);
            }
        }
        return ms;
    }
    
    
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public ArrayList<Mark> getAllMarksByStudent() {
        ArrayList<Mark> mst = new ArrayList<>();
        for (MyMark mark : marks) {
            mst.add(mark);
        }
        return mst;
    }
 
}
