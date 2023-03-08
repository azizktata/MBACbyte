package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateReclamation {

    public void updateReclamation(int id) {
        String sql = "UPDATE reclamation SET etat = ? \n"
                + "WHERE id = ?";

        try (
                Connection conn = Connexion.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, "traitée");
            pstmt.setInt(2, id);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

