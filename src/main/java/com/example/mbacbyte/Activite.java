package com.example.mbacbyte;

import java.util.Objects;

public class Activite {
    private int id;
    private String type;
    private String duree;
    private String support;
    private String typeDeSupport;
    private int candidatId;


    public Activite(int id, String type, String duree,  String typeDeSupport, int candidatId) {
        this.id = id;
        this.type = type;
        this.duree = duree;
        this.typeDeSupport = typeDeSupport;
        this.candidatId = candidatId;
    }

    public Activite(int id, String type, String duree,  String typeDeSupport) {
        this.id = id;
        this.type = type;
        this.duree = duree;
        this.typeDeSupport = typeDeSupport;
    }

    public Activite( String type, String duree,  String typeDeSupport, int candidatId) {
        this.type = type;
        this.duree = duree;
        this.typeDeSupport = typeDeSupport;
        this.candidatId = candidatId;
    }

    public Activite(String type, String duree, String support, String typeDeSupport, int candidatId) {
        this.duree = duree;
        this.type=type;
        this.support = support;
        this.typeDeSupport = typeDeSupport;
        this.candidatId = candidatId;
    }


    public Activite() {
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getTypeDeSupport() {
        return typeDeSupport;
    }

    public void setTypeDeSupport(String typeDeSupport) {
        this.typeDeSupport = typeDeSupport;
    }

    public int getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(int candidatId) {
        this.candidatId = candidatId;
    }


    @Override
    public String toString() {
        return "Activite{" +
                "id=" + id +
                ", duree='" + duree + '\'' +
                ", support='" + support + '\'' +
                ", typeDeSupport=" + typeDeSupport +
                ", candidatId=" + candidatId +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activite activite = (Activite) o;
        return id == activite.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
