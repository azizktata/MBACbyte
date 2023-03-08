package com.example.mbacbyte;

import DataBase.Select;
import DataBase.UpdateCandidat;
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

public class ElecteurView2Controller {

    @FXML
    private Button btn_return;

    @FXML
    private TableView<Candidat> table_listcandidats;

    @FXML
    private TableColumn<Candidat, Integer> col_cand_id;

    @FXML
    private TableColumn<Candidat, String > col_cand_nom;

    @FXML
    private TableColumn<Candidat, String> col_cand_prenom;

    @FXML
    private TableColumn<Candidat, String> col_cand_date;

    @FXML
    private TableColumn<Candidat, String> col_cand_position;

    @FXML
    private TableColumn<Candidat, Integer> col_cand_score;

    @FXML
    private TextField txt_note;

    @FXML
    private TextField txt_id_candidat;

    @FXML
    private Button btn_submit_note;

    @FXML
    private TableView<Activite> table_listeactivite;

    @FXML
    private TableColumn<Activite, Integer> col_act_candid;

    @FXML
    private TableColumn<Activite, String > col_act_type;

    @FXML
    private TableColumn<Activite, String> col_act_duree;

    @FXML
    private TableColumn<Activite, String> col_act_typesupport;

    @FXML
    private TextField txt_le_id;

    @FXML
    private RadioButton btn_voir;

    ObservableList<Candidat> listC;
    @FXML
    private void initialize ()
    {
        col_cand_id.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("id"));
        col_cand_nom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("nom"));
        col_cand_prenom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("prenom"));
        col_cand_date.setCellValueFactory(new PropertyValueFactory<Candidat,String>("date"));
        col_cand_position.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Position"));
        col_cand_score.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("score"));


        col_act_candid.setCellValueFactory(new PropertyValueFactory<Activite,Integer>("candidatId"));
        col_act_duree.setCellValueFactory(new PropertyValueFactory<Activite,String>("duree"));
        col_act_type.setCellValueFactory(new PropertyValueFactory<Activite,String>("type"));
        col_act_typesupport.setCellValueFactory(new PropertyValueFactory<Activite,String>("typeDeSupport"));


        Select select = new Select();
        listC = select.selectAllCandidats();
        table_listcandidats.setItems(listC);
    }

    private void Afficher()
    {
        ObservableList<Candidat> ConData = FXCollections.observableArrayList();
        Select select = new Select();
        ConData = select.selectCandidatByListeId(Integer.parseInt(txt_le_id.getText()));
        table_listcandidats.setItems(ConData);

        ObservableList<Activite> ActData = FXCollections.observableArrayList();
        ActData = select.selectActivitesByListeId(Integer.parseInt(txt_le_id.getText()));
        table_listeactivite.setItems(ActData);
    }

    @FXML
    void OnReturnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ElecteurView.fxml"));
        Stage window = (Stage) btn_return.getScene().getWindow();
        window.setTitle("Electeur View");
        window.setScene(new Scene(root , 764.0, 409.0));
    }

    @FXML
    void OnSubmitNoteClick(ActionEvent event) {
        int res=0;
        Candidat C1 = new Candidat();
        Select select = new Select();
        UpdateCandidat update = new UpdateCandidat();
        C1= select.selectcandidatByID(Integer.parseInt(txt_id_candidat.getText()));
        C1.addavis(Integer.parseInt(txt_note.getText()));

        for( int i : C1.getAvis())
        {
            res+=i;
        }
        C1.setMoyenneAvis(res+C1.getMoyenneAvis());
        update.updateAvis(Integer.parseInt(txt_id_candidat.getText()),C1.getMoyenneAvis());


    }
    @FXML
    void OnVoirClick(ActionEvent event) {
        Afficher();
    }

}

