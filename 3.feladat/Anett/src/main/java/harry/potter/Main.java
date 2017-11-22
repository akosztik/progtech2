package harry.potter;

import harry.potter.datasource.StudentDatasource;
import harry.potter.datasource.model.Student;

import java.util.List;

public class Main {

    private static StudentDatasource test = new StudentDatasource();

    public static void main(String[] args) {

        test.addStrudent(1, "CharValami", "Bela");
        Main.listStudents();
        test.changeCharacter("Bela", "CharValami2");
        Main.listStudents();
    }

    private static void listStudents() {
        List<Student> students = test.listStudents();
        for (Student student : students) {
            System.out.println(" ID: " + student.getId() + " AGE: " + student.getAge() +
                    " NAME: " + student.getName() + " Character:" + student.getCharacter().toString());
        }
    }
}
