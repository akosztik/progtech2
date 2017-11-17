package hu.valdar.progtech.backend.db;

import hu.valdar.progtech.backend.db.connection.DBConnectionSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseSetup {

    public static void main(String[] args){
        try (Scanner scanner = new Scanner(new File("src/db.sql"));
             Connection connection = DBConnectionSource.getInstance().getConnection();
             Statement stmt = connection.createStatement()) {
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String sql = scanner.next().trim();
                if (sql.equals("")) {
                    continue;
                }
                System.out.print(sql.replaceAll("\\s+", " "));
                System.out.print(": ");
                if (!sql.toUpperCase().startsWith("SELECT")) {
                    try {
                        stmt.execute(sql);
                        System.out.println("OK");
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Az sql file nem talalhato! :" + ex.getMessage());
        } catch (SQLException ex) {
            System.err.println("Hiba tortent az SQL kapcsolat soran: " + ex.getMessage());
        }
    }

}
