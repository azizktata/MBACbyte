package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {


    public void deleteCandidat(int id) {
        String sql = "DELETE FROM candidat WHERE id = ?";
        String sqlReclamation= "DELETE FROM reclamation WHERE candidatId = ?";
        String sqlAvis= "DELETE FROM avis WHERE candidatId = ?";

        try (Connection conn = Connexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             /*PreparedStatement pstmt1 = conn.prepareStatement(sql);
             PreparedStatement pstmt2 = conn.prepareStatement(sql);*/
        ) {

            // set the corresponding param
            pstmt.setInt(1, id);
           // pstmt1.setInt(1, id);
            //pstmt2.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
           // pstmt1.executeUpdate();
            //pstmt2.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }





    public void deleteReclamation(int id) {
        String sql = "DELETE FROM reclamation WHERE id = ?";

        try (Connection conn = Connexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            // set the corresponding param
            pstmt.setInt(1, id);

            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }








    public void deleteAvis(int id) {
        String sql = "DELETE FROM avis WHERE id = ?";

        try (Connection conn = Connexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            // set the corresponding param
            pstmt.setInt(1, id);

            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAct(int id) {
        String sql = "DELETE FROM activite WHERE id = ?";

        try {Connection conn = Connexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setInt(1, id);

            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
