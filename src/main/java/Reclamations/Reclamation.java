package Reclamations;



import java.util.Objects;

public class Reclamation {
    private int id;
    private String sujet;
    private String description;
    private int candidatId;
    private String etat;





    public Reclamation(int id, String sujet, String description, int candidatId, String etat) {
        this.id = id;
        this.sujet = sujet;
        this.description = description;
        this.candidatId = candidatId;
        this.etat = etat;
    }

    public Reclamation(String sujet, String description, int candidatId) {
        this.sujet = sujet;
        this.description = description;
        this.candidatId = candidatId;

    }


    public Reclamation() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(int candidatId) {
        this.candidatId = candidatId;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


    @Override
    public String toString() {
        return "Reclamation{" +
                "id=" + id +
                ", sujet='" + sujet + '\'' +
                ", description='" + description + '\'' +
                ", candidatId=" + candidatId +
                ", etat=" + etat +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        Reclamation that = (Reclamation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}