package harry.potter.controller.service;

import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.House;

public class HouseService {
    HouseDatasource hd;

    public void addHouse(House house) {
        hd = new HouseDatasource();
        hd.addHouse(house.getCrest(),house.getName());

    }


}
