package harry.potter.controller.datasource;

import harry.potter.model.Creature;
import harry.potter.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static harry.potter.controller.datasource.DatabaseConstants.*;

public class CreatureDatasource {

    DBConnector connector = new DBConnector();

    /**.
     * Ezekkel a metodussal a DB Connection-on keresztul sql parancsot adunk ki,
     * hogy a creatureunket beszurja a tablaba.
     * parametere: a leny neve, karaktere.
     */

    public void addCreature(String name,String character) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO " +
                    TABLE_CREATURE +
                    " (" + COLUMN_CREATURE_NAME +
                    ", " + COLUMN_CREATURE_CHARACTER +
                    ") VALUES (?,?)";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, character);

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
     * hogy az osszes lenyt lekerdezze. ArrayListtel ter vissza.
     */

    public List<Creature> listCreatures() {

        List<Creature> creatures = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement stmt = null;

        try {
            conn = connector.getConnection();

            String selectSql = "SELECT " + COLUMN_CREATURE_CHARACTER +
                    ", " + COLUMN_CREATURE_ID +
                    ", " + COLUMN_CREATURE_NAME +
                    " FROM " + TABLE_CREATURE;

            preparedStatement = conn.prepareStatement(selectSql);
            ResultSet rs = preparedStatement.executeQuery(selectSql);

            while (rs.next()) {
                Integer id = rs.getInt(COLUMN_CREATURE_ID);
                String character = rs.getCharacterStream(COLUMN_CREATURE_CHARACTER).toString();
                String name = rs.getString(COLUMN_CREATURE_NAME);

                creatures.add(new Creature(id,character, name));
            }
            connector.closeConnection(conn, stmt, rs, preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return creatures;
    }

    public void changeCharacter(String findedName, String newCharacter) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();

            String updateCharacterSql
                    = String.format("UPDATE %s SET %s = ? WHERE %s = ?",
                    TABLE_CREATURE, COLUMN_CREATURE_CHARACTER, COLUMN_CREATURE_NAME);

            preparedStatement = conn.prepareStatement(updateCharacterSql);
            preparedStatement.setString(1, newCharacter);
            preparedStatement.setString(2, findedName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
    }

    public Creature getCreatureByName(String findedName) {
        Creature creature = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement stmt = null;

        try {
            conn = connector.getConnection();

            String selectSql = "SELECT " + COLUMN_CREATURE_CHARACTER +
                    ", " + COLUMN_CREATURE_ID +
                    ", " + COLUMN_CREATURE_NAME +
                    ", " + COLUMN_CREATURE_FIRST_MET +
                    " FROM " + TABLE_CREATURE +
                    " WHERE " + COLUMN_CREATURE_NAME +
                    " = ?";

            preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setString(1, findedName);
            ResultSet rs = preparedStatement.executeQuery(selectSql);

            if (rs.first()) {
                Integer id = rs.getInt(COLUMN_CREATURE_ID);
                String character = rs.getCharacterStream(COLUMN_CREATURE_CHARACTER).toString();
                String name = rs.getString(COLUMN_CREATURE_NAME);
                Date firstMet = rs.getDate(COLUMN_CREATURE_FIRST_MET);

                creature = new Creature(id,character, name);
            }
            connector.closeConnection(conn, stmt, rs, preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return creature;
    }
    public Creature updateCreature(String creatureName,  String firstMet) {

        Creature creature = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();

            creature = getCreatureByName(creatureName);


            if (creatureName == null) {
                creatureName = creature.getName();
            }
            if (firstMet == null) {
                firstMet = creature.getFirstMate();
            }

            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date parsed = format.parse(firstMet);
            java.sql.Date firstMetDate = new java.sql.Date(parsed.getTime());

            String updateCharacterSql = String.format("UPDATE %s SET %s = ? WHERE %s = ?",
                    TABLE_CREATURE, COLUMN_CREATURE_FIRST_MET, COLUMN_STUDENT_NAME);

            preparedStatement = conn.prepareStatement(updateCharacterSql);
            preparedStatement.setDate(1, firstMetDate);
            preparedStatement.setString(2, creatureName);

            preparedStatement.executeUpdate();
            creature = getCreatureByName(creatureName);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return creature;
    }

}
