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

    public Student addStudent(Integer age, String character, String name) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Student student = null;
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
            student = getStudentsByName(name);

            connector.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return student;
    }

    public List<Student> listStudents() {

        List<Student> students = new ArrayList<>();
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
                Integer id = rs.getInt(COLUMN_STUDENT_ID);
                String character = rs.getString(COLUMN_STUDENT_CHARACTER).toString();
                String name = rs.getString(COLUMN_STUDENT_NAME);
                Integer age = rs.getInt(COLUMN_STUDENT_AGE);
                Integer house_id = rs.getInt(COLUMN_STUDENT_HOUSE_ID);

                students.add(new Student(age, character, name, house_id, id));
            }
            connector.closeConnection(conn, stmt, rs, preparedStatement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return students;
    }

    public Student getStudentsByName(String studentName) {

        Student student = null;
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = connector.getConnection();
            String selectSql = "SELECT * FROM student WHERE name = '" + studentName + "'";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectSql);
            while (rs.next()) {
                Integer studentId = rs.getInt(COLUMN_STUDENT_ID);
                String character = rs.getString(COLUMN_STUDENT_CHARACTER);
                String name = rs.getString(COLUMN_STUDENT_NAME);
                Integer age = rs.getInt(COLUMN_STUDENT_AGE);
                Integer house_id = rs.getInt(COLUMN_STUDENT_HOUSE_ID);

                student = new Student(age, name, character, house_id, studentId);
            }

            connector.closeConnection(conn, stmt, rs, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, stmt);
        }
        return student;
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

    public Student changeCharacter(String findedName, String newCharacter) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Student student = null;

        try {
            conn = connector.getConnection();

            String updateCharacterSql
                    = String.format("UPDATE %s SET %s = ? WHERE %s = ?",
                    TABLE_STUDENT, COLUMN_STUDENT_CHARACTER, COLUMN_STUDENT_NAME);

            preparedStatement = conn.prepareStatement(updateCharacterSql);
            preparedStatement.setString(1, newCharacter);
            preparedStatement.setString(2, findedName);
            preparedStatement.executeUpdate();
            student = getStudentsByName(findedName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return student;
    }

    public Student addStudentToHouse(String studentName, Integer houseId) {

        Student student = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();

            String updateCharacterSql = String.format("UPDATE %s SET %s = ? WHERE %s = ?",
                    TABLE_STUDENT, COLUMN_STUDENT_HOUSE_ID, COLUMN_STUDENT_NAME);

            preparedStatement = conn.prepareStatement(updateCharacterSql);
            preparedStatement.setInt(1, houseId);
            preparedStatement.setString(2, studentName);
            preparedStatement.executeUpdate();
            student = getStudentsByName(studentName);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return student;
    }

    public Student updateStudent(String studentName, Integer age, String characterName, Integer houseId) {

        Student student = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = connector.getConnection();

            student = getStudentsByName(studentName);


            if (studentName == null) {
                studentName = student.getName();
            }
            if (age == null) {
                age = student.getAge();
            }
            if (characterName == null) {
                characterName = student.getCharacter();
            }
            if (houseId == null) {
                houseId = student.getHouseId();
            }

            String updateCharacterSql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ? WHERE %s = ?",
                    TABLE_STUDENT, COLUMN_STUDENT_AGE, COLUMN_STUDENT_HOUSE_ID, COLUMN_STUDENT_CHARACTER, COLUMN_STUDENT_NAME);

            preparedStatement = conn.prepareStatement(updateCharacterSql);
            preparedStatement.setInt(1, age);
            preparedStatement.setInt(2, houseId);
            preparedStatement.setString(3, characterName);
            preparedStatement.setString(4, studentName);

            preparedStatement.executeUpdate();
            student = getStudentsByName(studentName);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.closeConnection(conn, preparedStatement);
        }
        return student;
    }

}
