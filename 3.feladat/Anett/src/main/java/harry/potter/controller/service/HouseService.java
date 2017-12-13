package harry.potter.controller.service;

import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.House;
import harry.potter.model.Student;

import java.util.List;

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

    /**
     * Ezzel a metodussal HouseDatasource
     * azonos nevu metodusat hivjuk meg es arrayListet kapunk.
     */
    public List<House> listHouses() {
        List<House> houses = hd.listHouses();
        System.out.println(houses.get(0).getName());
        return houses;
    }
    /**
     * Ezzel a metodussal a HouseDatasource getHouseIdByName metodusat
     * hivjuk meg mely egy integert ad vissza.
     * parameterei egy string.
     */
    public Integer getHouseIdByName(String houseName) {
        return  hd.getHouseIdByName(houseName);
    }

    public List<House> listStudents() {
        return hd.listHouses();
    }

}
