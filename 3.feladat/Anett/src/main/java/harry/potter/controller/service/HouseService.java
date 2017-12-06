package harry.potter.controller.service;

import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.House;
import harry.potter.model.Student;

import java.util.List;

public class HouseService {

    HouseDatasource hd = new HouseDatasource();

    /**
     * Ezekkel a metodussal a HouseDatasource metodusanak adjuk at a house nevet, cimeret .
     * parametere: a house, a House osztaly egy peldanya.
     */

    public void addHouse(House house) {
        hd.addHouse(house.getCrest(), house.getName());
    }


    public Integer getHouseIdByName(String houseName) {
        return  hd.getHouseIdByName(houseName);
    }

    public List<House> listStudents() {
        return hd.listHouses();
    }

}
