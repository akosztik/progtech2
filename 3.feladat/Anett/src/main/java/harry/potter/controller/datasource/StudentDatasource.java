package harry.potter.controller.datasource;

import harry.potter.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static harry.potter.controller.datasource.DatabaseConstants.*;

public class StudentDatasource {

    DBConnector connector = new DBConnector();

    public void addStrudent(Integer age, String character, String name) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO " +
                    TABLE_STUDENT +
                    " (" + COLUMN_STUDENT_CHARACTER +
                    ", " + COLUMN_STUDENT_NAME +
                    ", " + COLUMN_STUDENT_AGE +
                    ") VALUES (?,?,?)";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, character);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);

            preparedStatement.executeUpdate();
            connector.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
    }

    public List<Student> listStudents() {

        List<Student> strudents = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement stmt = null;

        try {
            conn = connector.getConnection();

            String selectSql = "SELECT " + COLUMN_STUDENT_CHARACTER +
                    ", " + COLUMN_STUDENT_ID +
                    ", " + COLUMN_STUDENT_NAME +
                    ", " + COLUMN_STUDENT_AGE +
                    ", " + COLUMN_STUDENT_HOUSE_ID +
                    " FROM " + TABLE_STUDENT;

            preparedStatement = conn.prepareStatement(selectSql);
            ResultSet rs = preparedStatement.executeQuery(selectSql);

            while (rs.next()) {
                Long id = rs.getLong(COLUMN_STUDENT_ID);
                String character = rs.getCharacterStream(COLUMN_STUDENT_CHARACTER).toString();
                String name = rs.getString(COLUMN_STUDENT_NAME);
                Integer age = rs.getInt(COLUMN_STUDENT_AGE);

                strudents.add(new Student(id, age, character, name));
            }
            connector.closeConnection(conn, stmt, rs, preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return strudents;
    }

    public Integer numberOfStudentsByHouseName(Integer houseId) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement stmt = null;

        try {
            conn = connector.getConnection();
            String selectSql = "SELECT count(*) AS total" +
                    " FROM " + TABLE_STUDENT +
                    " WHERE " + COLUMN_STUDENT_HOUSE_ID + " = ?";

            preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, houseId);
            ResultSet rs = preparedStatement.executeQuery(selectSql);

            if (rs.first()) {
                return rs.getInt("total");
            }
            connector.closeConnection(conn, stmt, rs, preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return 0;
    }

    public void changeCharacter(String findedName, String newCharacter) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();

            String updateCharacterSql
                    = String.format("UPDATE %s SET %s = ? WHERE %s = ?",
                    TABLE_STUDENT, COLUMN_STUDENT_CHARACTER, COLUMN_STUDENT_NAME);

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
    public void addStudentToHouse(String studentName, Integer houseId) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();

            String updateCharacterSql
                    = String.format("UPDATE %s SET %s = ? WHERE %s = ?",
                    TABLE_STUDENT, COLUMN_STUDENT_HOUSE_ID, COLUMN_STUDENT_NAME);

            preparedStatement = conn.prepareStatement(updateCharacterSql);
            preparedStatement.setInt(1, houseId);
            preparedStatement.setString(2, studentName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
    }

}
