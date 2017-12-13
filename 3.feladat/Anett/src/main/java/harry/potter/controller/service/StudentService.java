package harry.potter.controller.service;

import harry.potter.model.Character;
import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.Creature;
import harry.potter.model.Student;

import java.awt.event.ActionEvent;
import java.util.List;

public class StudentService {

    private HouseDatasource hd = null;
    private StudentDatasource sd = null;

    /**
     * Ezzel a konstruktorral peldanyositjuk a StudentService-t.
     */
    public StudentService() {
        hd = new HouseDatasource();
        sd = new StudentDatasource();
    }

    public StudentService(HouseDatasource hd, StudentDatasource sd) {
        this.hd = hd;
        this.sd = sd;
    }

    /**
     * Ezekkel a metodussal a StudentDatasource metodusanak adjuk at a student eletkorat, karakteret, nevet .
     * parametere: a student, a Student osztaly egy peldanya.
     */

    public Student addStudent(Student student) {
        return sd.addStudent(student.getAge(), student.getCharacter(), student.getName());
    }

    /**
     * Ezzel a metodussal a StudentDatasource metodusanak adjuk at a student nevet .
     * parametere: a student neve.
     * visszater egy tanulo peldannyal.
     */
    public Student getStudentsByName(String studentName) {
        return sd.getStudentsByName(studentName);
    }
    /**
     * Ezzel a metodussal a StudentDatasource azonos nevu metodusat hivjuk meg.
     * visszater egy tanulo listaval.
     */
    public List<Student> listStudents() {
        return sd.listStudents();
    }
    /**
     * Ezzel a metodussal a StudentDatasource azonos nevu metodusat hivjuk meg.
     * parameterei:tanulo neve(string),haz neve(string)
     * visszater egy tanulo peldannyal.
     */
    public Student addStudentToHouse(String studentName, String houseName) {
        Integer houseId = hd.getHouseIdByName(houseName);
        return sd.addStudentToHouse(studentName, houseId);
    }

    /**
     * Ezekkel a metodussal a HouseDatasourde metodusanak adjuk at a student nevet, house idjet .
     * parametere: a student neve es a haz neve , 2 db karakterlanc.
     */

    public Student setStudentHouse(String studentName, String houseName) {

        Integer houseId = hd.getHouseIdByName(houseName);
        return sd.addStudentToHouse(studentName, houseId);
    }
    /**
     * Ezzel a metodussal listabol string arrayt allitunk elo.
     * parametere: ArrayList
     */
    public String[] toArray(List<Student> studentList){
        String[] list=new String[studentList.size()];
        for (int i =0;i<studentList.size();i++ ){
            list[i]=studentList.get(i).getName();
        }
        return list;
    }


    public Student updateStudent(String studentName, Integer age, String characterName, String houseName) {
        Integer houseId = hd.getHouseIdByName(houseName);
        return sd.updateStudent(studentName, age, characterName, houseId);
    }



}
