package harry.potter.controller.datasource;

public class DatabaseConstants {

    public static final String DATABASE_NAME = "harry_potter";
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/" + DATABASE_NAME;
    public static final String USER = "root";
    public static final String PASS = "root";

    public static final String TABLE_HOUSE = "house";
    public static final String COLUMN_HOUSE_ID = "id";
    public static final String COLUMN_HOUSE_CREST = "crest";
    public static final String COLUMN_HOUSE_NAME = "name";

    public static final String TABLE_STUDENT = "student";
    public static final String COLUMN_STUDENT_ID = "id";
    public static final String COLUMN_STUDENT_CHARACTER = "character_name";
    public static final String COLUMN_STUDENT_NAME = "name";
    public static final String COLUMN_STUDENT_AGE = "age";
    public static final String COLUMN_STUDENT_HOUSE_ID = "house_id";

    public static final String TABLE_CREATURE = "creature";
    public static final String COLUMN_CREATURE_ID = "id";
    public static final String COLUMN_CREATURE_CHARACTER = "character_name";
    public static final String COLUMN_CREATURE_NAME = "name";
    public static final String COLUMN_CREATURE_FIRST_MATE = "firstMate";

    public static final String TABLE_CHARACTER = "karakter";
    public static final String COLUMN_CHARACTER_ID = "id";
    public static final String COLUMN_CHARACTER_NAME = "name";
}
