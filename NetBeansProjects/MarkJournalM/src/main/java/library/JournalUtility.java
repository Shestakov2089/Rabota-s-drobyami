
package library;

import java.util.ArrayList;


public class JournalUtility {
    private JournalUtility() {
    }
    
    /** 
     * метод вычисляющий среднюю оценку по средней оценке всех студентов по заданному предмету 
     * @param studs - коллекция стундентов
     * @param s - предмет
     * @return значение средней оценки
     * @since Journal 1.0
     * @
     */
    public static double takeAverageMarkBySubject(ArrayList<? extends Student> studs,Subject s){
        double sum = 0;
        int count = 0;
        for (Student stud : studs) {
            if (takeAverageMarkBySubject(stud, s) == 0) count++;
            sum = sum + takeAverageMarkBySubject(stud, s);    
        }
        if (sum == 0) return 0;
        return sum/(studs.size()-count);
    }
    
    public static double takeAverageMarkBySubject(Student stud, Subject s){
        ArrayList<Mark> m = stud.getAllMarksBySubject(s);
        if(m.isEmpty()) return 0;
        double sum = 0;
        for (Mark mark : m) {
            sum = sum + mark.getValue(); 
        }
        return sum/m.size();
    } 
    
    public static ArrayList<String> takeNameBySurname(ArrayList<? extends Student> studs, String surname) throws StudentException{ 
        ArrayList<String> st = new ArrayList<>();    
        for (Student stud : studs) {
            if (stud.getSurname().equals(surname)){
                st.add(stud.getName());
            }
        }
        if(st.isEmpty()) throw new StudentException(surname);

        return st ;
    }
    
    public static double takeAverageMarkByStudent(Student studs){
        ArrayList<Mark> ms = studs.getAllMarksByStudent();
        if(ms.isEmpty()) return 0;
        double sum = 0;
        for (Mark mark : ms) {
            sum = sum + mark.getValue();
        }
    
        return sum/ms.size();
    }
}
