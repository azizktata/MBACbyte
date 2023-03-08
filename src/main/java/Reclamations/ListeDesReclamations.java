package Reclamations;

import com.example.mbacbyte.Reclamation;

import java.util.ArrayList;

public class ListeDesReclamations {

    private ArrayList<Reclamation> reclamations ;

    public ListeDesReclamations(ArrayList<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }


    public ListeDesReclamations() {
        this.reclamations=new ArrayList<Reclamation>();
    }


    public ArrayList<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(ArrayList<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }
}
