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

import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.service.HouseService;
import harry.potter.controller.service.StudentService;
import harry.potter.model.House;
import harry.potter.model.Student;
import harry.potter.view.MainWindow;

import java.util.List;

public class Main {


    private static HouseService houseService = new HouseService();

    private static StudentService studentService = new StudentService();


    /**
     * elindítja a programot. A fomenut es a keretet peldanyositja.
     */

    public static void main(String[] args) {
        MainWindow startup = new MainWindow();

        testDatabaseNotUse();
    }

    private static void testDatabaseNotUse() {
        Student student1 = new Student(31, "char 1", "Juci");
        Student student2 = new Student(21, "char 2", "Joozsi");
        Student student3 = new Student(28, "char 3", "Kata");

        Student s1 = studentService.addStudent(student1);
        Student s2 = studentService.addStudent(student2);
        Student s3 = studentService.addStudent(student3);

        Student keresettDiak = studentService.getStudentsByName("Juci");

        System.out.println(keresettDiak);

        Student shouse =  studentService.addStudentToHouse("bela","sanyi haza");
        Student updatedStudent = studentService.updateStudent("Kata", 25, "VALAMI CHARACTER 1", "iiii");

        Main.listStudents();
        Main.listHouses();
    }


    private static void listStudents() {
        List<Student> students = studentService.listStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void listHouses() {
        List<House> houses = houseService.listStudents();
        for (House house : houses) {
            System.out.println(house);
        }
    }
}
