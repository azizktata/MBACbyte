package com.example.mbacbyte;

import DataBase.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminViewController {
    @FXML
    private TextField txt_candidatID;

    @FXML
    private TextField txt_typeactivite;

    @FXML
    private TextField txt_typesupport;

    @FXML
    private TextField txt_duree;

    @FXML
    private TextField txt_listeid;

    @FXML
    private TextField txt_position;

    @FXML
    private TextField txt_twitt;

    @FXML
    private TextField txt_fb;

    @FXML
    private TextField txt_photo;

    @FXML
    private TextField txt_date;

    @FXML
    private TextField txt_prenom;

    @FXML
    private TextField txt_nom;

    @FXML
    private TextField txt_idreclamation;


    @FXML
    private Button btn_Delete;

    @FXML
    private Button btn_Add;

    @FXML
    private Button btn_Addcdt;

    @FXML
    private Button btn_Update;
    @FXML
    private Button btn_Updatecreclamation;

    @FXML
    private Button btn_Updatecdt;

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_refresh;

    @FXML
    private TableView<Candidat> table_candidat;

    @FXML
    private TableColumn<Candidat, Integer> col_id;

    @FXML
    private TableColumn<Candidat, String> col_nom;

    @FXML
    private TableColumn<Candidat, String> col_prenom;

    @FXML
    private TableColumn<Candidat, String> col_date;

    @FXML
    private TableColumn<Candidat, String> col_photo;

    @FXML
    private TableColumn<Candidat, String> col_fb;

    @FXML
    private TableColumn<Candidat, String> col_twitt;

    @FXML
    private TableColumn<Candidat, Integer> col_score;

    @FXML
    private TableColumn<Candidat, Integer> col_listeid;

    @FXML
    private TableColumn<Candidat, Integer> col_mdp;

    @FXML
    private TableColumn<Candidat, String> col_position;
    @FXML
    private TableView<Activite> table_activite;

    @FXML
    private TableColumn<Activite, Integer> col_Act_id;



    @FXML
    private TableColumn<Activite, Integer> col_Act_candidaid;

    @FXML
    private TableColumn<Activite, String> col_Act_duree;

    @FXML
    private TableColumn<Activite, String> col_Act_typesupp;

    @FXML
    private TableColumn<Activite, String> col_Act_type;

    @FXML
    private TableView<ListeElectoral> table_listeElectorale;

    @FXML
    private TableColumn<ListeElectoral, Integer> col_list_id;

    @FXML
    private TableColumn<ListeElectoral, String> col_namelist;

    @FXML
    private TableColumn<ListeElectoral, Integer> col_list_score;

    @FXML
    private TableColumn<Reclamation, Integer> cola_id;
    @FXML
    private TableColumn<Reclamation, Integer> cola_idcandidat;

    @FXML
    private TableColumn<Reclamation, String> cola_sujet;

    @FXML
    private TableColumn<Reclamation, String> cola_description;

    @FXML
    private TableColumn<Reclamation, String> cola_etat;

    @FXML
    private TableView<Reclamation> table_reclamation;


    @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_Password;

    ObservableList<Candidat> listC;
    ObservableList<Activite> listA;
    ObservableList<ListeElectoral> listL;
    ObservableList<Reclamation> listD;


    @FXML
    private void initialize ()
    {
        //liaison tableau a la base de donneee
        col_id.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("prenom"));
        col_date.setCellValueFactory(new PropertyValueFactory<Candidat,String>("date"));
        col_photo.setCellValueFactory(new PropertyValueFactory<Candidat,String>("photo"));
        col_fb.setCellValueFactory(new PropertyValueFactory<Candidat,String>("facebook"));
        col_twitt.setCellValueFactory(new PropertyValueFactory<Candidat,String>("twitter"));
        col_score.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("score"));
        col_listeid.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("listeElectoral"));
        col_position.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Position"));
        col_mdp.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("motDePasse"));


        col_Act_id.setCellValueFactory(new PropertyValueFactory<Activite,Integer>("id"));
        col_Act_candidaid.setCellValueFactory(new PropertyValueFactory<Activite,Integer>("candidatId"));
        col_Act_duree.setCellValueFactory(new PropertyValueFactory<Activite,String>("duree"));
        col_Act_type.setCellValueFactory(new PropertyValueFactory<Activite,String>("type"));
        col_Act_typesupp.setCellValueFactory(new PropertyValueFactory<Activite,String>("typeDeSupport"));


        col_list_id.setCellValueFactory(new PropertyValueFactory<ListeElectoral,Integer>("id"));
        col_namelist.setCellValueFactory(new PropertyValueFactory<ListeElectoral,String>("nom"));
        col_list_score.setCellValueFactory(new PropertyValueFactory<ListeElectoral,Integer>("score"));

        cola_id.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("id"));
        cola_idcandidat.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("candidatId"));
        cola_description.setCellValueFactory((new PropertyValueFactory<Reclamation,String>("description")));
        cola_sujet.setCellValueFactory((new PropertyValueFactory<Reclamation,String>("sujet")));
        cola_etat.setCellValueFactory((new PropertyValueFactory<Reclamation,String>("etat")));




        Select select = new Select();
        listA = select.selectAllActivites();
        table_activite.setItems(listA);
        listC = select.selectAllCandidats();
        table_candidat.setItems(listC);
        listL = select.selectListesElectorals();
        table_listeElectorale.setItems(listL);
        listD=select.selectReclamations1();
        table_reclamation.setItems(listD);

    }



    @FXML
    void OnBackClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLoginView.fxml"));
        Stage window = (Stage) btn_back.getScene().getWindow();
        window.setTitle("Admin View");
        window.setScene(new Scene(root , 469.0, 374.0));
    }

    public int Coefscorelist(String S)
    {
        int coef=0;
        switch (S)
        {
            case "TeteListe":
                coef+=3;
                break;
            case "MembreImportant":
                coef+=2;
                break;
            case "Membre":
                coef+=1;
                break;
        }
        return coef;
    }

    public int score(String S)
    {
        int sc=0;
        switch (S)
        {
            case "Politique":
                sc+=5;
                break;
            case "Scientifique":
                sc+=4;
                break;
            case "Econimique":
                sc+=3;
                break;
            case "Social":
                sc+=2;
                break;
            case "Humanitaire":
                sc+=1;
                break;
        }
        return sc;
    }

    @FXML
    void OnAddClick(ActionEvent event) {
        int score=0;
        Insert insert = new Insert();
        Select select = new Select();
        UpdateCandidat update = new UpdateCandidat();
        Activite A1 = new Activite(txt_typeactivite.getText(), txt_duree.getText(),txt_typesupport.getText(),Integer.parseInt(txt_candidatID.getText()));
        insert.insertActivite(A1);
        score=select.selectscore(Integer.parseInt(txt_candidatID.getText()))+score(txt_typeactivite.getText());
        update.updateScore(Integer.parseInt(txt_candidatID.getText()),score);
        listA.add(A1);
        table_activite.setItems(listA);


    }

    @FXML
    void OnUpdateClick(ActionEvent event) {
        int res=0;
        //ObservableList<Activite> listAct;
        UpdateCandidat update = new UpdateCandidat();
        Select select = new Select();
        //Candidat C1 = new Candidat();
        Activite A1 = new Activite(Integer.parseInt(txt_candidatID.getText()),txt_typeactivite.getText(), txt_duree.getText(),txt_typesupport.getText());
        update.updateAct(A1);
        /*C1 = select.selectcandidatByID(A1.getCandidatId());
        listAct = select.selectActivite(A1.getCandidatId());
        for(Activite A:listAct)
        {
            res+=score(A.getType());
        }
        update.updateScore(A1.getCandidatId(),res);*/
        listA = select.selectAllActivites();
        table_activite.setItems(listA);
        //listC = select.selectAllCandidats();
        //table_candidat.setItems(listC);

    }@FXML
    void OnUpdaterecClick(ActionEvent event) {
        //ObservableList<Activite> listAct;
        UpdateReclamation update = new UpdateReclamation();
        Select select = new Select();


        update.updateReclamation(Integer.parseInt(txt_idreclamation.getText()));

        listD = select.selectReclamations1();
        table_reclamation.setItems(listD);


    }

    @FXML
    void OnUpdatecdtClick(ActionEvent event) {
        ObservableList<Candidat> CoData= FXCollections.observableArrayList();
        UpdateCandidat update = new UpdateCandidat();
        Select select = new Select();
        Candidat C1 = new Candidat(txt_nom.getText(),txt_prenom.getText(),"123",txt_date.getText(),txt_photo.getText(),txt_fb.getText(),txt_twitt.getText(),Integer.parseInt(txt_listeid.getText()),txt_position.getText());
        C1.setId(Integer.parseInt(txt_candidatID.getText()));
        update.updateCand(C1);
        listC = select.selectAllCandidats();
        table_candidat.setItems(listC);
        /*Select select = new Select();
        CoData = select.selectAllCandidats();
        table_candidat.setItems(CoData);*/
    }
    @FXML
    void OnAddCdtClick(ActionEvent event) {
        Candidat C1 = new Candidat(txt_nom.getText(),txt_prenom.getText(),txt_Password.getText(),txt_date.getText(),txt_photo.getText(),txt_fb.getText(),txt_twitt.getText(),Integer.parseInt(txt_listeid.getText()),txt_position.getText(),txt_username.getText());
        C1.setId(Integer.parseInt(txt_candidatID.getText()));
        Insert insert = new Insert();
        insert.insertCandidat(C1);
        listC.add(C1);
        table_candidat.setItems(listC);

    }

    @FXML
    void OnDeleteClick(ActionEvent event) {
        Delete delete = new Delete();
        Select select = new Select();
        delete.deleteAct(Integer.parseInt(txt_candidatID.getText()));
        listA = select.selectAllActivites();
        table_activite.setItems(listA);
    }

    @FXML
    void OnDeletecdtClick(ActionEvent event) {
        Delete delete = new Delete();
        Select select = new Select();
        delete.deleteCandidat(Integer.parseInt(txt_candidatID.getText()));
        listC = select.selectAllCandidats();
        table_candidat.setItems(listC);
    }

    @FXML
    void OnRefreshClick(ActionEvent event){
        int score=0;
        int score2=0;
        ObservableList<Candidat> listCand;
        ObservableList<Candidat> listCand2;
        Select select = new Select();
        UpdateListeElectoral update = new UpdateListeElectoral();
        listCand=select.selectCandidatByListeId(1);
        listCand2=select.selectCandidatByListeId(2);
        for(Candidat C : listCand)
        {
            score+=(Coefscorelist(C.getPosition())*C.getScore());
        }
        for(Candidat C : listCand2)
        {
            score2+=(Coefscorelist(C.getPosition())*C.getScore());
        }
        update.updateScore(1,score);
        update.updateScore(2,score2);
        listC= select.selectAllCandidats();
        listA= select.selectAllActivites();
        listL= select.selectListesElectorals();
        table_candidat.setItems(listC);
        table_activite.setItems(listA);
        table_listeElectorale.setItems(listL);
    }

}