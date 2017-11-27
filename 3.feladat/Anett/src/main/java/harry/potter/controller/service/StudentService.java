package harry.potter.controller.service;

import harry.potter.model.Character;
import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.Student;

import java.awt.event.ActionEvent;

public class StudentService {

    private HouseDatasource hd = null;
    private StudentDatasource sd = null;

    public StudentService() {
        hd = new HouseDatasource();
        sd = new StudentDatasource();
    }


    public StudentService(HouseDatasource hd, StudentDatasource sd) {
        this.hd = hd;
        this.sd = sd;
    }


    public void addStudent(Student student) {
        sd.addStudent(student.getAge(), student.getCharacter(), student.getName());

    }

    public Student setStudentHouse(String studentName, String houseName) {
        Integer houseId = hd.getHouseIdByName(houseName);
        return sd.addStudentToHouse(studentName, houseId);
    }


}
