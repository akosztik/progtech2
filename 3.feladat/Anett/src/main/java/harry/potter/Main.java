/**
 * <h1> Magiaugyi nyilvantarto rendszer</h1>
 * A magiaugyi nyilvantarto egy program melynek a fo funkcioi:
 * adatbevitel, modositas, es szures.
 *<p>
 * @author  Kosztik Anett
 * @version 1.0
 * @since   2017-11-28
 * </p>
 */

package harry.potter;

import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.Student;
import harry.potter.view.MainWindow;

import java.util.List;

public class Main {

    private static StudentDatasource test = new StudentDatasource();
    /**
     * elindítja a programot. A fomenut es a keretet peldanyositja.
     */
    public static void main(String[] args) {

        MainWindow startup= new MainWindow();

//        test.addStudent(2, "SSSS", "AAAA");
//        Main.listStudents();
//        test.changeCharacter("AAAA", "WWWWW");
//        Main.listStudents();
    }

//    private static void listStudents() {
//
//        List<Student> students = test.listStudents();
//        for (Student student : students) {
//            System.out.println(" ID: " + student.getId() + " AGE: " + student.getAge() +
//                    " NAME: " + student.getName() + " Character:" + student.getCharacter().toString());
//        }
//    }
}
