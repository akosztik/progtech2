package harry.potter.controller.service;

import harry.potter.model.Character;
import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.Student;

import java.awt.event.ActionEvent;

public class StudentService {
    HouseDatasource hd;
    StudentDatasource sd;


    public void addStudent(Student student) {
        sd = new StudentDatasource();
        sd.addStudent(student.getAge(),student.getCharacter(),student.getName());

    }
    public void setStudentHouse(String studentName, String houseName) {
        HouseDatasource hd = new HouseDatasource();
        StudentDatasource sd = new StudentDatasource();

        Integer houseId = hd.getHouseIdByName(houseName);
        sd.addStudentToHouse(studentName, houseId);

    }


}
