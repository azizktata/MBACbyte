package com.example.mbacbyte;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button Admin_btn;

    @FXML
    private Button Candidat_btn;

    @FXML
    private Button Elect_btn;

    @FXML
    void OnAdminClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLoginView.fxml"));
        Stage window = (Stage) Admin_btn.getScene().getWindow();
        window.setTitle("Admin Login");
        window.setScene(new Scene(root , 469.0, 374.0));
    }

    @FXML
    void OnCandidaClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CandidatLoginView.fxml"));
        Stage window = (Stage) Candidat_btn.getScene().getWindow();
        window.setTitle("Candidat Login");
        window.setScene(new Scene(root , 469.0, 374.0));
    }

    @FXML
    void OnElectClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ElecteurView.fxml"));
        Stage window = (Stage) Elect_btn.getScene().getWindow();
        window.setTitle("Electeur View");
        window.setScene(new Scene(root , 764.0, 409.0));
    }

}
