package harry.potter.controller.datasource;

import java.sql.*;

import harry.potter.controller.datasource.DatabaseConstants;

public class DBConnector {


    public static void closeConnection(Connection conn) {
        closeConnection(conn, null);
    }

    public static void closeConnection(Connection conn, PreparedStatement preparedStatement) {
        closeConnection(conn, null, null, preparedStatement);
    }

    public static void closeConnection(Connection conn, Statement stmt) {
        closeConnection(conn, stmt, null, null);
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs, PreparedStatement preparedStatement) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            System.out.println("Goodbye!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(DatabaseConstants.JDBC_DRIVER);
            System.out.println("Connecting to database...");
            return DriverManager.getConnection(DatabaseConstants.DB_URL, DatabaseConstants.USER, DatabaseConstants.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
