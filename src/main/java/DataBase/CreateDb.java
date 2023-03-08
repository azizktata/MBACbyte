package DataBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class CreateDb {
    public static void createNewDatabase() {

        Connection conn = Connexion.connect();
        if(conn==null){
            String url = "jdbc:sqlite:C:/Users/HP/Desktop/MBACbyte/sqlite.db";

            try {

                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("The driver name is " + meta.getDriverName());
                    System.out.println("A new database has been created.");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }

}
