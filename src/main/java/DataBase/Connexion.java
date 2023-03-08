package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    public static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/user/Desktop/MBACbyte/sqlite.db";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
