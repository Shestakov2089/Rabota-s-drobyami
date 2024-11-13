
package ru.specialist.markjournalm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import journal.MyMark;
import journal.MySubject;
import library.Group;
import library.Mark;
import library.Student;
import library.Subject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Support {
    public static ArrayList<MyMark> generateMarks(int n, MySubject[] subject) {
        ArrayList<MyMark> result = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 1; i <= n; i++) {
            result.add(new MyMark(rnd.nextInt(4)+2,subject[rnd.nextInt(subject.length)]));//subject[rnd.nextInt(subject.length)].getSubjectName()));
            
        }
        return result;
    }
    
    public static void generateExcelJournal(Group g, Subject s) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(s.getName());
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Cтудент");
        row.createCell(1).setCellValue("Оценка");
        
        int i = 1;
        int j;
        int max = 0;
        for (Student student : g.getStudents()) {
            Row tmpRow = sheet.createRow(i);
            tmpRow.createCell(0).setCellValue(student.getSurname() + " " + student.getName());
            j = 1;
            for (Mark mark : student.getAllMarksBySubject(s)) {
                tmpRow.createCell(j).setCellValue(mark.getValue());
                j++;
                if(max < j){
                    max = j;
                }
            }
            i++;
        }
//        int firstRow = 0;
//        int lastRow = 0;
//        int firstCol = 1;
//        int lastCol = max-1;
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, max-1));
        workbook.write(new FileOutputStream(g.getNameGroup() + " " + s.getName() + ".xlsx"));
        workbook.close();
    }
}

 