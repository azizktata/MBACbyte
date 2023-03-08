package com.example.mbacbyte;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("MenuView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 595.0, 362.0);
        stage.setTitle("Welcome Menu");
        stage.setScene(scene);
        stage.show();
    }

 /*  public static void main(String[] args) {
        //launch();
        //creation de la base de donnés

        DataBase.CreateDb.createNewDatabase();

        //creation des tables
        CreateTables createTables=new CreateTables();
        createTables.createAllTables();
        Select select = new Select();
        //select.selectAllCandidats();

        Insert insert= new Insert();

        ListeElectoral tunis1= new ListeElectoral("tunis1");
        ListeElectoral tunis2= new ListeElectoral("tunis2");
        ListeElectoral sfax= new ListeElectoral("sfax");
        ListeElectoral bizerte= new ListeElectoral("bizerte");

        ListeElectoral gabes= new ListeElectoral("gabes");
        ListeElectoral sousse= new ListeElectoral("sousse");
        ListeElectoral nabeul1= new ListeElectoral("nabeul1");
        ListeElectoral nabeul2= new ListeElectoral("nabeul2");
        ListeElectoral kairouan= new ListeElectoral("kairouan");



        insert.insertListeElectoral(tunis1);
        insert.insertListeElectoral(tunis2);
        insert.insertListeElectoral(sfax);
        insert.insertListeElectoral(nabeul2);
        insert.insertListeElectoral(gabes);
        insert.insertListeElectoral(sousse);
        insert.insertListeElectoral(nabeul1);
        insert.insertListeElectoral(kairouan);
        insert.insertListeElectoral(bizerte);



       Select select=new Select();
       ArrayList<Reclamation> reclamations =new ArrayList<Reclamation>();
       reclamations=select.selectAllReclamations();
       for(Reclamation reclamation:reclamations)
       {reclamation.toString();}
       ArrayList<Candidat> candidats =new ArrayList<Candidat>();
       candidats=select.selectAllCandidats1();
       for(Candidat reclamation:candidats)
       {reclamation.toString();}
    }*/

    }

