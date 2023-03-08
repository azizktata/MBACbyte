package com.example.mbacbyte;

import Admin.Admin;
import Admin.ListeAdmins;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginController {
    @FXML
    private Button btn_login;

    @FXML
    private TextField txt_admin;

    @FXML
    private TextField txt_password;
    @FXML
    private Button btn_bck_menu;

    @FXML
    void OnBckClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        Stage window = (Stage) btn_bck_menu.getScene().getWindow();
        window.setTitle("Welcome Menu");
        window.setScene(new Scene(root , 595.0, 362.0));

    }

    public boolean  CheckAdminList()
    {

        ListeAdmins LAdmin = new ListeAdmins();
        Admin A = new Admin("aziz","aziz");
        Admin B = new Admin("iheb","iheb");
        Admin C = new Admin("ibrahim","ibrahim");
        Admin D = new Admin("amine","amine");

        LAdmin.AddAdmin(A,B,C,D);
        for(Admin Ad : LAdmin.getLAdmin() )
        {
            if(Ad.getUsename().equals(txt_admin.getText()) && Ad.getPassword().equals(txt_password.getText()) )
            {
                return true;
            }
        }
        return false;
    }
    @FXML
    void OnLoginClick(ActionEvent event) throws IOException {
        if(CheckAdminList())
        {
            Parent root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
            Stage window = (Stage) btn_login.getScene().getWindow();
            window.setTitle("Admin View");
            window.setScene(new Scene(root , 993.0, 678.0));
        }

    }


}
