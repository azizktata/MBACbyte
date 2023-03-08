package DataBase;
import com.example.mbacbyte.Activite;
import Avis.Avis;
import com.example.mbacbyte.Candidat;
import com.example.mbacbyte.ListeElectoral;
import com.example.mbacbyte.Reclamation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class Select {


    public ArrayList<Avis> selectAvis(int candidatId) {
        String sql = "SELECT * FROM avis \n"
                + "WHERE candidatId= ?";

        ArrayList<Avis> avisList = new ArrayList<Avis>();

        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, candidatId);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                Avis avis = new Avis(rs.getInt("id"), rs.getInt("note"), rs.getInt("candidatId"));
                avisList.add(avis);

            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return avisList;
    }

    public int selectscore(int id) {
        String sql = "SELECT score FROM candidat \n"
                + "WHERE id= ?";
        int sc = 0;

        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            sc = rs.getInt("score");

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sc;
    }


    public ObservableList<Reclamation> selectReclamations(int candidatId) {
        String sql = "SELECT * FROM reclamation \n"
                + "WHERE candidatId= ?";

        ObservableList<Reclamation> reclamationList = FXCollections.observableArrayList();

        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, candidatId);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                Reclamation reclamation = new Reclamation(rs.getInt("id"), rs.getString("sujet"), rs.getString("description"), rs.getInt("candidatId"), rs.getString("etat"));
                reclamationList.add(reclamation);

            }
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return reclamationList;
    }

    public ObservableList<Reclamation> selectReclamations1() {
        String sql = "SELECT * FROM reclamation ";

        ObservableList<Reclamation> reclamationList = FXCollections.observableArrayList();

        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                Reclamation reclamation = new Reclamation(Integer.parseInt(rs.getString("id")), rs.getString("sujet"), rs.getString("description"), Integer.parseInt(rs.getString("candidatId")), rs.getString("etat"));
                reclamationList.add(reclamation);

            }
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return reclamationList;
    }


    public ObservableList<Activite> selectActivite(int candidatId) {
        String sql = "SELECT * FROM activite \n"
                + "WHERE candidatId= ?";

        ObservableList<Activite> activites = FXCollections.observableArrayList();

        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, candidatId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                // loop through the result set

                Activite activite = new Activite(rs.getInt("id"), rs.getString("type"), rs.getString("duree"), rs.getString("typeDeSupport"), rs.getInt("candidatId"));
                activites.add(activite);
            }
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return activites;
    }

    public ObservableList<Activite> selectAllActivites() {
        String sql = "SELECT * FROM activite ";

        ObservableList<Activite> activites = FXCollections.observableArrayList();

        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                Activite activite = new Activite(rs.getInt("id"), rs.getString("type"), rs.getString("duree"), rs.getString("typeDeSupport"), rs.getInt("candidatId"));
                activites.add(activite);

            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return activites;
    }

    public ObservableList<Activite> selectActivitesByListeId(int id) {
        String sql = "SELECT candidatId, duree, support, type FROM activite A, candidat C, listeElectoral L WHERE L.id=C.listeElectoralId= ? AND A.id=C.id  ";

        ObservableList<Activite> activites = FXCollections.observableArrayList();

        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                Activite activite = new Activite(rs.getString("type"), rs.getString("duree"), rs.getString("support"), rs.getInt("candidatId"));
                activites.add(activite);

            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return activites;
    }


    public ObservableList<Candidat> selectAllCandidats() {
        String sql = "SELECT * FROM candidat";
        ObservableList<Candidat> candidats = FXCollections.observableArrayList();

        try {
            Connection conn = Connexion.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {

                Candidat candidat = new Candidat(Integer.parseInt(rs.getString("id")), rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("motDePasse"), rs.getString("datenaissance"), rs.getString("photo"),
                        rs.getString("nomPartie"), rs.getString("facebook"), rs.getString("twitter"),
                        Integer.parseInt(rs.getString("listeElectoralid")), rs.getString("position"), Integer.parseInt(rs.getString("score")), Integer.parseInt(rs.getString("moyenneAvis")), rs.getString("username"));

                candidats.add(candidat);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return candidats;
    }


    public int selectLastId() {
        String sql = "SELECT MAX(id) FROM Candidat";
        int id = 0;

        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            id = Integer.parseInt(rs.getString(id));
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;

    }

    public int selectLastIdAct() {
        String sql = "SELECT MAX(id) FROM Activite";
        int id = 0;

        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            id = Integer.parseInt(rs.getString(id));
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;

    }

    public Candidat selectcandidatByID(int id) {
        String sql = "SELECT * FROM candidat \n"
                + "WHERE id = ?";
        Candidat C = new Candidat();

        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set


            Candidat candidat = new Candidat(Integer.parseInt(rs.getString("id")), rs.getString("nom"), rs.getString("prenom"),
                    rs.getString("motDePasse"), rs.getString("datenaissance"), rs.getString("photo"),
                    rs.getString("nomPartie"), rs.getString("facebook"), rs.getString("twitter"),
                    Integer.parseInt(rs.getString("listeElectoralid")), rs.getString("position"), Integer.parseInt(rs.getString("score")), Integer.parseInt(rs.getString("moyenneAvis")), rs.getString("username"));

            C = candidat;

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return C;

    }

    public ObservableList<Candidat> selectCandidatByListeId(int id) {
        String sql = "SELECT * FROM candidat \n"
                + "WHERE listeElectoralId = ?";
        ObservableList<Candidat> candidats = FXCollections.observableArrayList();

        try {

            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();


            // loop through the result set
            while (rs.next()) {


                Candidat candidat = new Candidat(Integer.parseInt(rs.getString("id")), rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("motDePasse"), rs.getString("datenaissance"), rs.getString("photo"),
                        rs.getString("nomPartie"), rs.getString("facebook"), rs.getString("twitter"),
                        Integer.parseInt(rs.getString("listeElectoralid")), rs.getString("position"), Integer.parseInt(rs.getString("score")), Integer.parseInt(rs.getString("moyenneAvis")), rs.getString("username"));


                candidats.add(candidat);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return candidats;
    }


    public ArrayList<Candidat> selectCandidatByListeElectoralId(int id) {
        String sql = "SELECT * FROM candidat \n"
                + "WHERE listeElectoralId = ?";
        ArrayList<Candidat> candidats = new ArrayList<Candidat>();

        try {

            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();


            // loop through the result set
            while (rs.next()) {


                //ArrayList<Avis>avisList= new ArrayList<Avis>();
                // avisList=selectAvis(rs.getInt("id"));

                ArrayList<Activite> activites = new ArrayList<Activite>();
                // activites=selectActivite(rs.getInt("id"));

                ArrayList<Reclamation> reclamations = new ArrayList<Reclamation>();
                //  reclamations=selectReclamations(rs.getInt("id"));


                Candidat candidat = new Candidat(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("motDePasse"), rs.getString("datenaissance"), rs.getString("photo"),
                        rs.getString("nomPartie"), activites, rs.getString("facebook"), rs.getString("twitter"),
                        rs.getInt("score"), rs.getInt("listeElectoralId"), rs.getString("position"),
                        rs.getInt("moyenneAvis"), reclamations);


                candidats.add(candidat);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return candidats;
    }

    public ObservableList<ListeElectoral> selectListesElectorals() {
        String sql = "SELECT * FROM listeElectoral";
        ObservableList<ListeElectoral> listeElectorals = FXCollections.observableArrayList();

        try {
            Connection conn = Connexion.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {

                ListeElectoral listeElectoral = new ListeElectoral(rs.getInt("id"), rs.getString("nom"), rs.getInt("score"));


                listeElectorals.add(listeElectoral);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return listeElectorals;
    }


    public ArrayList<ListeElectoral> selectAllListesElectorals() {
        String sql = "SELECT * FROM listeElectoral";
        ArrayList<ListeElectoral> listeElectorals = new ArrayList<ListeElectoral>();

        try {
            Connection conn = Connexion.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {


                ArrayList<Candidat> candidats = new ArrayList<Candidat>();
                candidats = selectCandidatByListeElectoralId(rs.getInt("id"));


                ListeElectoral listeElectoral = new ListeElectoral(rs.getInt("id"), rs.getString("nom"), candidats, rs.getInt("score"));


                listeElectorals.add(listeElectoral);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return listeElectorals;
    }

    public boolean login(String username, String password) {
        String sql = "SELECT * FROM candidat \n"
                + "WHERE username= ? AND motDePasse=?";
        boolean test = false;
        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                test = true;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return test;
    }

    public ArrayList<Reclamation> selectAllReclamations() {
        String sql = "SELECT * FROM reclamation";

        ArrayList<Reclamation> reclamationList = new ArrayList<Reclamation>();

        try {
            Connection conn = Connexion.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                Reclamation reclamation = new Reclamation(rs.getInt("id"), rs.getString("sujet"), rs.getString("description"), rs.getInt("candidatId"), rs.getString("etat"));
                reclamationList.add(reclamation);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return reclamationList;

    }

    public ArrayList<Candidat> selectAllCandidats1() {
        String sql = "SELECT * FROM candidat";
        ArrayList<Candidat> candidats = new ArrayList<Candidat>();

        try (Connection conn = Connexion.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {


                ArrayList<Avis> avisList = new ArrayList<Avis>();
                avisList = selectAvis(rs.getInt("id"));

                ArrayList<Activite> activites = new ArrayList<Activite>();
                // activites=selectActivite(rs.getInt("id"));

                ArrayList<Reclamation> reclamations = new ArrayList<Reclamation>();
                //reclamations=selectReclamations(rs.getInt("id"));


                Candidat candidat = new Candidat(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("motDePasse"), rs.getString("datenaissance"), rs.getString("photo"),
                        rs.getString("nomPartie"), rs.getString("facebook"), rs.getString("twitter")
                        , rs.getInt("listeElectoralId"), rs.getString("position"), rs.getInt("score"),
                        rs.getInt("moyenneAvis"), rs.getString("username"));


                candidats.add(candidat);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
return candidats;
    }
}

