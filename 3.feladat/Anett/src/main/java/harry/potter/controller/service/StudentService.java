package harry.potter.controller.service;

import harry.potter.model.Character;
import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.Student;

import java.awt.event.ActionEvent;
import java.util.List;

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


    public Student addStudent(Student student) {
        return sd.addStudent(student.getAge(), student.getCharacter(), student.getName());
    }


    public Student getStudentsByName(String studentName) {
        return sd.getStudentsByName(studentName);
    }

    public List<Student> listStudents() {
        return sd.listStudents();
    }

    public Student addStudentToHouse(String studentName, String houseName) {
        Integer houseId = hd.getHouseIdByName(houseName);
        return sd.addStudentToHouse(studentName, houseId);
    }


    public Student updateStudent(String studentName, Integer age, String characterName, String houseName) {
        Integer houseId = hd.getHouseIdByName(houseName);
        return sd.updateStudent(studentName, age, characterName, houseId);
    }


}
