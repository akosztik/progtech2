package harry.potter.datasource;

import harry.potter.datasource.helper.DBConnector;
import harry.potter.datasource.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static harry.potter.datasource.DatabaseConstants.*;

public class StudentDatasource {

    DBConnector connector = new DBConnector();

    public void addStrudent(Integer age, String character, String name) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = connector.getConnection();

            String sql = "INSERT INTO " +
                    TABLE_STUDENT +
                    " (" + COLUMN_STUDENT_CHARACTER +
                    ", " + COLUMN_STUDENT_NAME +
                    ", " + COLUMN_STUDENT_AGE +
                    ") VALUES (?,?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, character);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);

            preparedStatement.executeUpdate();
            connector.closeConnection(conn, stmt);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, stmt);
        }
    }

    public List<Student> listStudents() {

        List<Student> strudents = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = connector.getConnection();

            String selectSql = "SELECT " + COLUMN_STUDENT_CHARACTER +
                    ", " + COLUMN_STUDENT_ID +
                    ", " + COLUMN_STUDENT_CHARACTER +
                    ", " + COLUMN_STUDENT_NAME +
                    ", " + COLUMN_STUDENT_AGE +
                    " FROM " + TABLE_STUDENT;

            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            ResultSet rs = preparedStatement.executeQuery(selectSql);

            while (rs.next()) {
                Long id = rs.getLong(COLUMN_STUDENT_ID);
                String character = rs.getCharacterStream(COLUMN_STUDENT_CHARACTER).toString();
                String name = rs.getString(COLUMN_STUDENT_NAME);
                Integer age = rs.getInt(COLUMN_STUDENT_AGE);

                strudents.add(new Student(id, age, character, name));
            }
            connector.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, stmt);
        }
        return strudents;
    }

    public void changeCharacter(String findedName, String newCharacter) {
        Connection conn = null;
        try {
            conn = connector.getConnection();

            String updateCharacterSql
                    = String.format("UPDATE %s SET %s = ? WHERE %s = ?",
                    TABLE_STUDENT, COLUMN_STUDENT_CHARACTER, COLUMN_STUDENT_NAME);

            PreparedStatement preparedStatement = conn.prepareStatement(updateCharacterSql);
            preparedStatement.setString(1, newCharacter);
            preparedStatement.setString(2, findedName);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn);
        }
    }

}
