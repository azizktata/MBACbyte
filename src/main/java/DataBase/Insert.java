package DataBase;

import com.example.mbacbyte.Activite;
import Avis.Avis;
import com.example.mbacbyte.Candidat;
import com.example.mbacbyte.ListeElectoral;
import com.example.mbacbyte.Reclamation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

    public void insertCandidat(Candidat candidat) {
        String sql = "INSERT INTO candidat(nom, prenom, datenaissance, photo, nomPartie, facebook, twitter, motDePasse, position, score, moyenneAvis,username,listeElectoralId) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try{
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, candidat.getNom());
            pstmt.setString(2, candidat.getPrenom());
            pstmt.setString(3, candidat.getDate());
            pstmt.setString(4, candidat.getPhoto());
            pstmt.setString(5, candidat.getNomPartie());
            pstmt.setString(6, candidat.getFacebook());
            pstmt.setString(7, candidat.getTwitter());
            pstmt.setString(8, candidat.getMotDePasse());
            pstmt.setString(9, candidat.getPosition());
            pstmt.setInt(10, 0);
            pstmt.setInt(11, 0);
            pstmt.setString(12, candidat.getUsername());
            pstmt.setInt(13, candidat.getListeElectoral());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void insertListeElectoral( ListeElectoral listeElectoral) {
        String sql = "INSERT INTO listeElectoral(nom, score) VALUES(?,?)";

        try{
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, listeElectoral.getNom());
            pstmt.setInt(2, 0);

            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void insertActivite(Activite activite) {
        String sql = "INSERT INTO activite(type, duree, candidatId, typeDeSupport) VALUES(?,?,?,?)";

        try{
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, activite.getType());
            pstmt.setString(2, activite.getDuree());
            pstmt.setInt(3, activite.getCandidatId());
            pstmt.setString(4, activite.getTypeDeSupport());


            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }






    public void insertAvis(Avis avis) {
        String sql = "INSERT INTO avis(note,candidatId) VALUES(?,?)";

        try{
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, avis.getNote());
            pstmt.setInt(2, avis.getCandidatId());


            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }







    public void insertReclamation(Reclamation reclamation) {
        String sql = "INSERT INTO reclamation(sujet, description, candidatId, etat) VALUES(?,?,?,?)";

        try{
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reclamation.getSujet());
            pstmt.setString(2, reclamation.getDescription());
            pstmt.setString(4, "non traitée");
            pstmt.setInt(3, reclamation.getCandidatId());


            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
