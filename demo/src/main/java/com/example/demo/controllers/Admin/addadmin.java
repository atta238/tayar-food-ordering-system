package com.example.demo.controllers.Admin;

import com.example.demo.Main;
import com.example.demo.controllers.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class addadmin implements Initializable {
    public TextField firstname_fild;
    public TextField email_fild;
    public PasswordField pass_fild;
    public TextField phonenum_fild;
    public Label Error_lbl;
    public Button addadmin_btn;
    public Label success_lbl;
    public Button undo_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addadmin_btn.setOnAction(e -> add_admin());
        undo_btn.setOnAction(e -> undo());
    }
    public void add_admin() {
        try {
            int check = Main.moderators.get(Main.adminidx).Register(firstname_fild.getText().toLowerCase(), email_fild.getText().toLowerCase(), pass_fild.getText(), phonenum_fild.getText());
            if (check == 1) {
                Error_lbl.setVisible(false);
                success_lbl.setVisible(true);
                firstname_fild.clear();
                email_fild.clear();
                pass_fild.clear();
                phonenum_fild.clear();
            }
            else {
                Error_lbl.setVisible(true);
            }
        }
        catch (Exception e) {
            success_lbl.setVisible(false);
            Error_lbl.setVisible(true);
        }
    }
    public void undo() {
        success_lbl.setVisible(false);
        Error_lbl.setVisible(false);
        Model.getInstance().getViewFactory().Show_firstpageadmin();
    }
}
