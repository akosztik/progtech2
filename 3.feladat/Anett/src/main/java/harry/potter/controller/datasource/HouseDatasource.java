package harry.potter.controller.datasource;

import harry.potter.model.House;
import harry.potter.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static harry.potter.controller.datasource.DatabaseConstants.*;

public class HouseDatasource {

    DBConnector connector = new DBConnector();

    /**.
     * Ezekkel a metodussal a DB Connection-on keresztul sql parancsot adunk ki,
     * hogy a hazunkat beszurja a tablaba.
     * parametere: a haz neve, cimere.
     */

    public void addHouse(String crest, String name) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO " +
                    TABLE_HOUSE +
                    " (" + COLUMN_HOUSE_CREST +
                    ", " + COLUMN_HOUSE_NAME +
                    ") VALUES (?,?)";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, crest);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();
            connector.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
    }

    /**.
     * Ezzel a metodussal a DB Connection-on keresztul sql parancsot adunk ki,
     * hogy a tablaban levo osszes hazat kilistazzuk.
     * visszateresi ertek: arraylist.
     */

    public List<House> listHouses() {

        List<House> houses = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement stmt = null;

        try {
            conn = connector.getConnection();

            String selectSql = "SELECT " + COLUMN_HOUSE_ID +
                    ", " + COLUMN_HOUSE_NAME +
                    ", " + COLUMN_HOUSE_CREST +
                    " FROM " + TABLE_HOUSE;

            preparedStatement = conn.prepareStatement(selectSql);
            ResultSet rs = preparedStatement.executeQuery(selectSql);

            while (rs.next()) {
                Integer id = rs.getInt(COLUMN_HOUSE_ID);
                String name = rs.getString(COLUMN_HOUSE_NAME);
                String crest = rs.getString(COLUMN_HOUSE_CREST);

                House house = new House(id, name, crest);
                System.out.println("..............."+house.getName());
                houses.add(house);
            }
            connector.closeConnection(conn, stmt, rs, preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return houses;
    }
    /**.
     * Ezzel a metodussal a DB Connection-on keresztul sql parancsot adunk ki,
     * hogy a haz id -jet nev alapjan megkapjuk.
     * parametere: a haz neve.
     */
    public Integer getHouseIdByName(String houseName) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();
            String selectSql = "SELECT " + COLUMN_HOUSE_ID + " FROM " +
                    TABLE_HOUSE + " WHERE " + COLUMN_HOUSE_NAME + " ='" + houseName + "'";
            preparedStatement = conn.prepareStatement(selectSql);

            ResultSet rs = preparedStatement.executeQuery(selectSql);
            if (rs.first()) {
                return rs.getInt(COLUMN_HOUSE_ID);
            }
            connector.closeConnection(conn, null, rs, preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return -1;
    }

}
