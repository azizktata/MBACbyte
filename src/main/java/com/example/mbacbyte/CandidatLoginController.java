package com.example.mbacbyte;

import DataBase.Select;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CandidatLoginController {
    public int id_candidat=0;

    @FXML
    private Button btn_login_candidat;

    @FXML
    private TextField txt_candiat_username;

    @FXML
    private PasswordField txt_candiat_password;
    @FXML
    private Button btn_bck_menu;

    @FXML
    void OnBckClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        Stage window = (Stage) btn_bck_menu.getScene().getWindow();
        window.setTitle("Welcome Menu");
        window.setScene(new Scene(root , 595.0, 362.0));
    }

    public boolean CheckCandidat()
    {
       String username=txt_candiat_username.getText();
       String password=txt_candiat_password.getText();

        Select select=new Select();
        return select.login(username,password);

    }

    @FXML
    void OnLoginCanidiatClick(ActionEvent event) throws IOException {
        if(CheckCandidat())
        {
            Parent root = FXMLLoader.load(getClass().getResource("CandidatView.fxml"));
            Stage window = (Stage) btn_login_candidat.getScene().getWindow();
            window.setTitle("Candidat View");
            window.setScene(new Scene(root , 950.0, 570.0));
        }

    }

}
