package DataBase;

import com.example.mbacbyte.Activite;
import com.example.mbacbyte.Candidat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCandidat {
    public void updateScore(int id,int score) {
        String sql = "UPDATE candidat SET score = ? \n"
                + "WHERE id = ?";

        try {
                Connection conn = Connexion.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setInt(2, id);
            pstmt.setInt(1, score);

            // update
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }





    public void updateAvis(int id,int moyenneAvis) {
        String sql = "UPDATE candidat SET moyenneAvis = ? \n"
                + "WHERE id = ?";

        try {
                Connection conn = Connexion.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setInt(2, id);
            pstmt.setInt(1, moyenneAvis);

            // update
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




    public void updateAll(Candidat candidat) {
        String sql = "UPDATE candidat SET score = ? ,\n"
                    +"SET nom = ? ,\n"
                    +"SET prenom = ? ,\n"
                    +"SET datenaissance = ? ,\n"
                    +"SET photo = ? ,\n"
                    +"SET nomPartie = ? ,\n"
                    +"SET facebook = ? ,\n"
                    +"SET twitter = ? ,\n"
                    +"SET motDePasse = ? ,\n"
                    +"SET position = ? ,\n"
                    +"SET moyenneAvis = ? \n"
                + "WHERE id = ?";

        try {
                Connection conn = Connexion.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setInt(1, candidat.getScore());
            pstmt.setString(2, candidat.getNom());
            pstmt.setString(3, candidat.getPrenom());
            pstmt.setString(4, candidat.getDate());
            pstmt.setString(5, candidat.getPhoto());
            pstmt.setString(6, candidat.getNomPartie());
            pstmt.setString(7, candidat.getFacebook());
            pstmt.setString(8, candidat.getTwitter());
            pstmt.setString(9, candidat.getMotDePasse());
            pstmt.setString(10, candidat.getPosition());
            pstmt.setInt(11, candidat.getMoyenneAvis());
            pstmt.setInt(12, candidat.getId());


            // update
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCand(Candidat candidat) {
        String sql = "UPDATE candidat SET nom = ? ,"
                +" prenom = ? ,"
                +" datenaissance = ? ,"
                +" photo = ? ,"
                +" facebook = ? ,"
                +" twitter = ? ,"
                +" position = ? "
                + "WHERE id = ?";

        try {
                Connection conn = Connexion.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, candidat.getNom());
            pstmt.setString(2, candidat.getPrenom());
            pstmt.setString(3, candidat.getDate());
            pstmt.setString(4, candidat.getPhoto());
            pstmt.setString(5, candidat.getFacebook());
            pstmt.setString(6, candidat.getTwitter());
            pstmt.setString(7, candidat.getPosition());
            pstmt.setInt(8, candidat.getId());


            // update
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAct(Activite activite) {
        String sql = "UPDATE activite SET type = ? ,\n"
                +" duree = ? ,\n"
                +" typeDeSupport = ? \n"
                + "WHERE id = ?";

        try {
                Connection conn = Connexion.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, activite.getType());
            pstmt.setString(2, activite.getDuree());
            pstmt.setString(3, activite.getTypeDeSupport());
            pstmt.setInt(4, activite.getId());


            // update
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
