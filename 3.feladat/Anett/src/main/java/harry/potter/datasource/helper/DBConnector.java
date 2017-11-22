package harry.potter.datasource.helper;

import java.sql.*;

import static harry.potter.datasource.DatabaseConstants.*;

public class DBConnector {


    public static void closeConnection(Connection conn) {
        closeConnection(conn, null);
    }

    public static void closeConnection(Connection conn, Statement stmt) {
        closeConnection(conn, stmt, null);
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
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
            System.out.println("Goodbye!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
