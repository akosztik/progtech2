package harry.potter.controller.service;

import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.datasource.StudentDatasource;

public class StudentService {


    public void setStrudentHouse(String studentName, String houseName) {
        HouseDatasource hd = new HouseDatasource();
        StudentDatasource sd = new StudentDatasource();

        Integer houseId = hd.getHouseIdByName(houseName);
        sd.addStudentToHouse(studentName, houseId);

    }
}
