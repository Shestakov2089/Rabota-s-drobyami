
package ru.specialist.markjournalm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import journal.MyGroup;
import journal.MyStudent;
import journal.MySubject;
import library.JournalUtility;
import library.StudentException;
import static ru.specialist.markjournalm.Support.generateMarks;



public class MarkJournalM {

    public static void main(String[] args) throws Exception {
        MySubject[] subject = {
            new MySubject("Математика"),
            new MySubject("Информатика"),
            new MySubject("Русский язык"),
            new MySubject("Физика")
        };
       
        MyGroup g1 = new MyGroup(1, "fiz");

        g1.addStudent(new MyStudent("Anatoliy","Shestakov", generateMarks(30,subject)));
        g1.addStudent(new MyStudent("Dmitriy","Polyaev", generateMarks(25,subject)));
        g1.addStudent(new MyStudent("Anna","Ivanova", generateMarks(20,subject)));
        g1.addStudent(new MyStudent("Lena","Ivanova", generateMarks(15,subject)));
        
        MyGroup g2 = new MyGroup(2, "it");
        
        g2.addStudent(new MyStudent("Nadya","Hlopkova", generateMarks(38,subject)));
        g2.addStudent(new MyStudent("Yura","Popov", generateMarks(26,subject)));
        g2.addStudent(new MyStudent("Vika","Bobkova", generateMarks(25,subject)));
        g2.addStudent(new MyStudent("Liza","Zubkova", generateMarks(24,subject)));

        System.out.println("Все оценки студента Polyaev: " + g1.getStudent("Polyaev").getAllMarksByStudent());
        System.out.println("Средняя оценка студента Polyaev по всем предметам: " + JournalUtility.takeAverageMarkByStudent(g1.getStudent("Polyaev")));
        System.out.println("Средняя оценка группы " + g1 + " по предмету :" + JournalUtility.takeAverageMarkBySubject(g1.getStudents(),subject[1]));
        System.out.println(g1.getStudent("Polyaev").getAllMarksBySubject(subject[1]));
        
        try{
        System.out.println("Имя студента " + JournalUtility.takeNameBySurname(g1.getStudents(), "Ivanova"));
        } catch (StudentException s){
           System.out.println("Такого студента нет");
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(g1.toString() + subject[0].getName() + ".txt"));
        for (String s : g1.createStringJournalBySubject(subject[0])) {
            writer.write(s);
            writer.newLine();
        }
        writer.close();
        
        writer = new BufferedWriter(new FileWriter(g2.toString() + subject[0].getName() + ".txt"));
        for (String s : g2.createStringJournalBySubject(subject[0])) {
            writer.write(s);
            writer.newLine();
        }
        writer.close();
        
        Support.generateExcelJournal(g1, subject[0]);
        
        
        
       
        
        
    }
}
