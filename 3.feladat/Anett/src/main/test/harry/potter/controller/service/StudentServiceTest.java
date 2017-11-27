package harry.potter.controller.service;

import harry.potter.controller.datasource.HouseDatasource;
import harry.potter.controller.datasource.StudentDatasource;
import harry.potter.model.House;
import harry.potter.model.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Struct;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    private StudentService testObject = null;
    private StudentDatasource sd = null;
    private HouseDatasource hd = null;


    @Before
    public void init() {
        sd = mock(StudentDatasource.class);
        hd = mock(HouseDatasource.class);
        testObject = new StudentService(hd, sd);
    }

    @Test
    public void addStudentToHouse() {

        // WHEN
        Student student = new Student(1, "Bela");

        House house = new House(2, "Griffendel", "Lion");
        Student excepted = new Student(20, "CHARACTER", "Harry Potter", house.getId());

        when(hd.getHouseIdByName(anyString())).thenReturn(house.getId());
        when(sd.addStudentToHouse(anyString(), anyInt())).thenReturn(excepted);

        // THEN
        Student actual = testObject.setStudentHouse(excepted.getName(), house.getName());

        // ASSERT
        assertEquals(excepted, actual);
    }

}
