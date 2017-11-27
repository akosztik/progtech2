package harry.potter.controller.service;

import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.House;

public class HouseService {

    HouseDatasource hd = new HouseDatasource();

    public void addHouse(House house) {
        hd.addHouse(house.getCrest(), house.getName());
    }


}
