package harry.potter.controller.datasource;

import static harry.potter.controller.datasource.DatabaseConstants.COLUMN_HOUSE_ID;
import static harry.potter.controller.datasource.DatabaseConstants.COLUMN_HOUSE_NAME;
import static harry.potter.controller.datasource.DatabaseConstants.TABLE_HOUSE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HouseDatasource {

    DBConnector connector = new DBConnector();

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
