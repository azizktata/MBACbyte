package Avis;

import java.util.Objects;

public class Avis {
    private int id;
    private int note;
    private int candidatId;


    public Avis(int id, int note, int candidatId) {
        this.id = id;
        this.note = note;
        this.candidatId = candidatId;
    }

    public Avis(int note, int candidatId) {
        this.note = note;
        this.candidatId = candidatId;
    }


    public Avis() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(int candidatId) {
        this.candidatId = candidatId;
    }


    @Override
    public String toString() {
        return "Avis{" +
                "id=" + id +
                ", note=" + note +
                ", candidatId=" + candidatId +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        Avis avis = (Avis) o;
        return id == avis.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
