package com.example.mbacbyte;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

//import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ElecteurViewController {

    @FXML
    private TableView<ListeElectoral> table_listeElectorale;

    @FXML
    private TableColumn<ListeElectoral, Integer> col_le_id;

    @FXML
    private TableColumn<ListeElectoral, String> col_le_nomliste;

    @FXML
    private TableColumn<ListeElectoral, Integer> col_le_score;

    @FXML
    private TableView<Candidat> tab_cdt_2;

    @FXML
    private TableColumn<Candidat, String> col_cd_nom;

    @FXML
    private TableColumn<Candidat, String> col_cd_prenom;

    @FXML
    private TableColumn<Candidat, String > col_cd_position;

    @FXML
    private TableColumn<Candidat, Integer> col_cd_score;

    @FXML
    private TextField txt_le_id;

    @FXML
    private Button btn_afficher;

    @FXML
    private Button btn_back;

    ObservableList<ListeElectoral> listL;

    @FXML
    private void initialize ()
    {
        col_le_id.setCellValueFactory(new PropertyValueFactory<ListeElectoral,Integer>("id"));
        col_le_nomliste.setCellValueFactory(new PropertyValueFactory<ListeElectoral,String>("nom"));
        col_le_score.setCellValueFactory(new PropertyValueFactory<ListeElectoral,Integer>("score"));

        col_cd_nom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("nom"));
        col_cd_prenom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("prenom"));
        col_cd_position.setCellValueFactory(new PropertyValueFactory<Candidat,String>("Position"));
        col_cd_score.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("score"));

        Select select = new Select();
        listL = select.selectListesElectorals();
        table_listeElectorale.setItems(listL);
    }

    private void AfficherCandidats()
    {
        ObservableList<Candidat> ConData = FXCollections.observableArrayList();
        Select select = new Select();
        ConData = select.selectCandidatByListeId(Integer.parseInt(txt_le_id.getText()));
        tab_cdt_2.setItems(ConData);
    }

    @FXML
    void OnNoterClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ElecteurView2.fxml"));
        Stage window = (Stage) btn_afficher.getScene().getWindow();
        window.setTitle("Electeur View");
        window.setScene(new Scene(root , 764.0, 409.0));
    }

    @FXML
    void OnBackClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        Stage window = (Stage) btn_back.getScene().getWindow();
        window.setTitle("Welcome Menu");
        window.setScene(new Scene(root , 595.0, 362.0));

    }

    @FXML
    void OnAfficherClick(ActionEvent event) throws IOException {
        AfficherCandidats();
    }

    @FXML
    void OnViewclick(ActionEvent event) {
        ArrayList<ListeElectoral> listeElectorals=new ArrayList<ListeElectoral>();
        Select select = new Select();
        listeElectorals=select.selectAllListesElectorals();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(ListeElectoral listeElectorale:listeElectorals){
            dataset.addValue(listeElectorale.getScore(), listeElectorale.getNom(), "");}



        JFreeChart chart = ChartFactory.createBarChart("Score par liste", "Listes electoral", "Score", dataset, PlotOrientation.VERTICAL, true, true,false);

        CategoryPlot plot = chart.getCategoryPlot();
        //plot.setRangeGridlinePaint(Color.yellow);
        ChartFrame chartFrame = new ChartFrame("Listes Electorales", chart, false);
        chartFrame.setVisible(true);
        chartFrame.setSize(500,650);


    }

    public void OnViewclick2(ActionEvent actionEvent) {
        ArrayList<Candidat> listeElectorals=new ArrayList<Candidat>();
        Select select = new Select();
        listeElectorals=select.selectCandidatByListeElectoralId(Integer.parseInt(txt_le_id.getText()));
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Candidat listeElectorale:listeElectorals){
            dataset.addValue(listeElectorale.getScore(), listeElectorale.getNom(), "");}



        JFreeChart chart = ChartFactory.createBarChart("Score des candidats par liste", "Candidat", "Score", dataset, PlotOrientation.HORIZONTAL, true, true,false);

        CategoryPlot plot = chart.getCategoryPlot();
        //plot.setRangeGridlinePaint(Color.yellow);
        ChartFrame chartFrame = new ChartFrame("Listes Electorales", chart, false);
        chartFrame.setVisible(true);
        chartFrame.setSize(500,650);


    }
}
