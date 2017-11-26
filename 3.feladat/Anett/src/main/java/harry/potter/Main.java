package harry.potter;

import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.Student;
import harry.potter.view.MainWindow;

import java.util.List;

public class Main {

    //private static StudentDatasource test = new StudentDatasource();

    public static void main(String[] args) {

        MainWindow startup= new MainWindow();

        //test.addStudent(2, "SSSS", "AAAA");
        //Main.listStudents();
        //test.changeCharacter("AAAA", "WWWWW");
        //Main.listStudents();
    }

    /*private static void listStudents() {

        List<Student> students = test.listStudents();
        for (Student student : students) {
            System.out.println(" ID: " + student.getId() + " AGE: " + student.getAge() +
                    " NAME: " + student.getName() + " Character:" + student.getCharacter().toString());
        }
    }*/
}
