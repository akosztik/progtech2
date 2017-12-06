package harry.potter.controller.service;

import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.House;

import java.util.List;

public class HouseService {

    HouseDatasource hd = new HouseDatasource();

    public void addHouse(House house) {
        hd.addHouse(house.getCrest(), house.getName());
    }
    public List<House> listHouses() {
        List<House> houses = hd.listHouses();
        System.out.println(houses.get(0).getName());
        return houses;
    }

}
