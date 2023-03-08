package DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    public void createCandidat() {


        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS candidat (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " nom text NOT NULL,\n"
                + " prenom text NOT NULL,\n"
                + " datenaissance text NOT NULL,\n"
                + " photo text NOT NULL,\n"
                + " nomPartie text ,\n"
                + " facebook text NOT NULL,\n"
                + " twitter text NOT NULL,\n"
                + " motDePasse text NOT NULL,\n"
                + " position text NOT NULL,\n"
                + " score integer,\n"
                + " moyenneAvis integer,\n"
                + " username text unique,\n"
                + " listeElectoralId integer NOT NULL,\n"
                + "FOREIGN KEY(listeElectoralId) REFERENCES listeElectoral(id)\n"
                + ");";

        try{
            Connection conn = Connexion.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


        public void createListeElectoral() {


            // SQL statement for creating a new table
            String sql = "CREATE TABLE IF NOT EXISTS listeElectoral (\n"
                    + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " nom text NOT NULL,\n"
                    + " score integer\n"
                    + ");";

            try{
                Connection conn = Connexion.connect();
                Statement stmt = conn.createStatement();
                stmt.execute(sql);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    public void createActivite() {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS activite (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " type text NOT NULL,\n"
                + " duree text NOT NULL,\n"
                + " support text ,\n"
                + "candidatId integer NOT NULL,\n"
                + "TypeDeSupport text NOT NULL,\n"
                + "FOREIGN KEY(candidatId) REFERENCES candidat(id)\n"
                + ");";

        try{
            Connection conn = Connexion.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void createAvis() {


        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS avis (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " note integer NOT NULL,\n"
                + "candidatId integer NOT NULL,\n"
                + "FOREIGN KEY(candidatId) REFERENCES candidat(id)\n"
                + ");";

        try{
            Connection conn = Connexion.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




    public void createReclamation() {


        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS reclamation (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " sujet text NOT NULL,\n"
                + " description text NOT NULL,\n"
                + "candidatId integer NOT NULL,\n"
                + "etat text NOT NULL,\n"
                + "FOREIGN KEY(candidatId) REFERENCES candidat(id)\n"
                + ");";

        try{
            Connection conn = Connexion.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void createAllTables(){
        createListeElectoral();
        createCandidat();
        createActivite();
        createAvis();
        createReclamation();
    }

}
