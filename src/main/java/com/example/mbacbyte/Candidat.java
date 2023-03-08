package com.example.mbacbyte;

import java.util.ArrayList;
import java.util.Objects;

public class Candidat {
    private int id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private String date;
    private String photo;
    private String nomPartie;
    private ArrayList<Activite> activites;
    private String facebook;
    private String twitter;
    private int score=0;
    private ArrayList<Integer> avis = new ArrayList<>();
    private int listeElectoral;
    private String Position;
    private int moyenneAvis=0;
    ArrayList<Reclamation> reclamations;



    private String username;

    public Candidat(int id, String nom, String prenom, String motDePasse, String date, String photo, String nomPartie, String facebook, String twitter, int listeElctoral, String position, int score,int moyenneAvis,String username) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.date = date;
        this.photo = photo;
        this.nomPartie = nomPartie;
        this.facebook = facebook;
        this.twitter = twitter;
        this.score=score;
        this.listeElectoral = listeElectoral;
        Position = position;
        this.moyenneAvis=moyenneAvis;
        this.username=username;

    }

    public Candidat( String nom, String prenom, String motDePasse, String date, String photo,  String facebook, String twitter, int listeElectoral, String position, String username) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.date = date;
        this.photo = photo;
        this.facebook = facebook;
        this.twitter = twitter;
        this.listeElectoral = listeElectoral;
        Position = position;
        this.username=username;

    }

    public Candidat( String nom, String prenom, String motDePasse, String date, String photo,  String facebook, String twitter, int listeElectoral, String position) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.date = date;
        this.photo = photo;
        this.facebook = facebook;
        this.twitter = twitter;
        this.listeElectoral = listeElectoral;
        Position = position;

    }



    public Candidat() {
    }


    public Candidat(int id, String nom, String prenom, String motDePasse, String date, String photo, String nomPartie, ArrayList<Activite> activites,
                    String facebook, String twitter, int score,  int listeElectoral,
                    String position, int moyenneAvis, ArrayList<Reclamation>reclamations) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.date = date;
        this.photo = photo;
        this.nomPartie = nomPartie;
        this.activites = activites;
        this.facebook = facebook;
        this.twitter = twitter;
        this.score = score;
        this.avis = avis;
        this.listeElectoral = listeElectoral;
        Position = position;
        this.moyenneAvis = moyenneAvis;
        this.reclamations=reclamations;
    }


    public void addavis(int i)
    {
        this.avis.add(i);
        setAvis(avis);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }


    public ArrayList<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(ArrayList<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNomPartie() {
        return nomPartie;
    }

    public void setNomPartie(String nomPartie) {
        this.nomPartie = nomPartie;
    }

    public ArrayList<Activite> getActivites() {
        return activites;
    }

    public void setActivites(ArrayList<Activite> activites) {
        this.activites = activites;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Integer> getAvis() {
        return avis;
    }

    public void setAvis(ArrayList<Integer> avis) {
        this.avis = avis;
    }

    public int getListeElectoral() {
        return listeElectoral;
    }

    public void setListeElectoral(int listeElectoral) {
        this.listeElectoral = listeElectoral;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public int getMoyenneAvis() {
        return moyenneAvis;
    }

    public void setMoyenneAvis(int moyenneAvis) {
        this.moyenneAvis = moyenneAvis;
    }






    @Override
    public String toString() {
        return "Candidat{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", date='" + date + '\'' +
                ", photo='" + photo + '\'' +
                ", nomPartie='" + nomPartie + '\'' +
              //  ", activites=" + activites.toString() +
                ", facebook='" + facebook + '\'' +
                ", twitter='" + twitter + '\'' +
                ", score=" + score +
               // ", avis=" + avis.toString() +
                ", listeElectoral=" + listeElectoral +
                ", Position='" + Position + '\'' +
                ", moyenneAvis=" + moyenneAvis +
              //  ", reclamations=" + reclamations.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        Candidat candidat = (Candidat) o;
        return id == candidat.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
