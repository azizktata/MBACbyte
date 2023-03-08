package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateListeElectoral {
    public void updateScore(int id,int score) {
        String sql = "UPDATE listeElectoral SET score = ? \n"
                + "WHERE id = ?";

        try (
                Connection conn = Connexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, score);
            pstmt.setInt(2, id);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
