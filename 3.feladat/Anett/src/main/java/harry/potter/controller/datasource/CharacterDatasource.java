package harry.potter.controller.datasource;

import harry.potter.model.Character;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import static harry.potter.controller.datasource.DatabaseConstants.*;

public class CharacterDatasource {

    DBConnector connector = new DBConnector();

    /**.
     * Ezekkel a metodussal a DB Connection-on keresztul sql parancsot adunk ki,
     * hogy a characterunket beszurja a tablaba.
     * parametere: a character neve.
     */

    public void addCharacter(String name) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO " +
                    TABLE_CHARACTER +
                    " (" + COLUMN_CHARACTER_NAME +
                    ") VALUES (?)";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();
            connector.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
    }

    /**.
     * Ezekkel a metodussal a DB Connection-on keresztul sql parancsot adunk ki,
     * hogy az osszes karaktert lekerdezze. ArrayListtel ter vissza.
     */

    public List<Character> listCharacters() {

        List<Character> characters = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement stmt = null;

        try {
            conn = connector.getConnection();

            String selectSql = "SELECT "  + COLUMN_CHARACTER_ID +
                    " FROM " + TABLE_CHARACTER;

            preparedStatement = conn.prepareStatement(selectSql);
            ResultSet rs = preparedStatement.executeQuery(selectSql);

            while (rs.next()) {
                String name = rs.getString(COLUMN_CREATURE_NAME);

                characters.add(new Character(name));
            }
            connector.closeConnection(conn, stmt, rs, preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return characters;
    }
}

