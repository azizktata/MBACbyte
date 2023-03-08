package com.example.mbacbyte;

import DataBase.Insert;
import DataBase.Select;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CandidatViewController {
    @FXML
    private Button btn_search;

    @FXML
    private TextField txt_candidatID;

    @FXML
    private TextField txt_Sujet;

    @FXML
    private TextArea txt_description;

    @FXML
    private Button btn_submit;

    @FXML
    private Button btn_back;

    @FXML
    private TableView<Candidat> table_candidat;

    @FXML
    private TableColumn<Candidat, Integer> col_cd_id;

    @FXML
    private TableColumn<Candidat, String> col_cd_nom;

    @FXML
    private TableColumn<Candidat, String> col_cd_prenom;

    @FXML
    private TableColumn<Candidat, String> col_cd_date;

    @FXML
    private TableColumn<Candidat, String> col_cd_photo;

    @FXML
    private TableColumn<Candidat, String> col_cd_fb;

    @FXML
    private TableColumn<Candidat, String> col_cd_twitt;

    @FXML
    private TableColumn<Candidat, Integer> col_cd_score;

    @FXML
    private TableColumn<Candidat, Integer> col_cd_listeid;

    @FXML
    private TableColumn<Candidat, String> col_cd_position;

    @FXML
    private TableColumn<Candidat, Integer> col_cd_moyavis;

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

    ObservableList<Candidat> listC;
    ObservableList<Activite> listA;

    @FXML
    private void initialize ()
    {
        //liaison tableau a la base de donneee
        col_cd_id.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("id"));
        col_cd_nom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("nom"));
        col_cd_prenom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("prenom"));
        col_cd_date.setCellValueFactory(new PropertyValueFactory<Candidat,String>("date"));
        col_cd_photo.setCellValueFactory(new PropertyValueFactory<Candidat,String>("photo"));
        col_cd_fb.setCellValueFactory(new PropertyValueFactory<Candidat,String>("facebook"));
        col_cd_twitt.setCellValueFactory(new PropertyValueFactory<Candidat,String>("twitter"));
        col_cd_score.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("score"));
        col_cd_listeid.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("listeElectoral"));
        col_cd_position.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Position"));
        col_cd_moyavis.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("moyenneAvis"));


        col_Act_id.setCellValueFactory(new PropertyValueFactory<Activite,Integer>("id"));
        col_Act_candidaid.setCellValueFactory(new PropertyValueFactory<Activite,Integer>("candidatId"));
        col_Act_duree.setCellValueFactory(new PropertyValueFactory<Activite,String>("duree"));
        col_Act_type.setCellValueFactory(new PropertyValueFactory<Activite,String>("type"));
        col_Act_typesupp.setCellValueFactory(new PropertyValueFactory<Activite,String>("typeDeSupport"));



        Select select = new Select();
        listA = select.selectAllActivites();
        table_activite.setItems(listA);
        listC = select.selectAllCandidats();
        table_candidat.setItems(listC);

    }

    private void SearchCandidatById()
    {
        ObservableList<Candidat> CanData = FXCollections.observableArrayList();
        Select select = new Select();
        CanData.add(select.selectcandidatByID(Integer.parseInt(txt_candidatID.getText())));
        table_candidat.setItems(CanData);

    }
    private void SearchActiviteByCandidatId()
    {
        ObservableList<Activite> ActData = FXCollections.observableArrayList();
        Select select = new Select();
        ActData = select.selectActivite(Integer.parseInt(txt_candidatID.getText()));
        table_activite.setItems(ActData);

    }

    @FXML
    void OnBackMenuClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        Stage window = (Stage) btn_back.getScene().getWindow();
        window.setTitle("Welcome Menu");
        window.setScene(new Scene(root , 595.0, 362.0));
    }



    @FXML
    void OnSubmitRecClick(ActionEvent event) {

        Reclamation reclamation=new Reclamation(txt_Sujet.getText(),txt_description.getText(),Integer.parseInt(txt_candidatID.getText()));
        Insert insert=new Insert();
        insert.insertReclamation(reclamation);


    }
    @FXML
    void OnSearchClick(ActionEvent event) {
        SearchCandidatById();
        SearchActiviteByCandidatId();
    }

}
