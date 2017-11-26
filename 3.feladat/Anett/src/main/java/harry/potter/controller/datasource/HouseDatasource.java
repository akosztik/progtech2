package harry.potter.controller.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static harry.potter.controller.datasource.DatabaseConstants.*;

public class HouseDatasource {

    DBConnector connector = new DBConnector();

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
    public Integer getHouseIdByName(String houseName) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();
            String selectSql = "SELECT " + COLUMN_HOUSE_ID +
                    " FROM " + TABLE_HOUSE +
                    " WHERE " + COLUMN_HOUSE_NAME + " = ?";

            preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setString(1, houseName);
            ResultSet rs = preparedStatement.executeQuery(selectSql);

            if (rs.first()) {
                return rs.getInt( 1);
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
