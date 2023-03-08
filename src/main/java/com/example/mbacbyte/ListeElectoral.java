package com.example.mbacbyte;

import java.util.ArrayList;
import java.util.Objects;

public class ListeElectoral {

    private int id ;
    private String nom;
    private ArrayList<Candidat> candidats;
    private int score;


    public ListeElectoral(String nom) {
        this.nom = nom;
    }


    public ListeElectoral() {
    }


    public ListeElectoral(int id, String nom, ArrayList<Candidat> candidats, int score) {
        this.id = id;
        this.nom = nom;
        this.candidats = candidats;
        this.score = score;
    }

    public ListeElectoral(int id, String nom,  int score) {
        this.id = id;
        this.nom = nom;
        this.score = score;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(ArrayList<Candidat> candidats) {
        this.candidats = candidats;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "ListeElectoral{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", candidats=" + candidats.toString() +
                ", score=" + score +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        ListeElectoral that = (ListeElectoral) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
