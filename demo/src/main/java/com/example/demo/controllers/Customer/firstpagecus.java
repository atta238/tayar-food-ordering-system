package com.example.demo.controllers.Customer;

import com.example.demo.Main;
import com.example.demo.Models.Customer;
import com.example.demo.Models.Governorate;
import com.example.demo.controllers.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class firstpagecus implements Initializable {
    public Button placeorder_btn;
    public Button myorders_btn;
    public Button changegov_btn;
    public ChoiceBox<String> gov_changeselector;
    public Button logout_btn;
    public Label loaction_sucsses_lbl;

    ObservableList<String> gov=FXCollections.observableArrayList();
    public void add_gov(){
        for(Governorate idx: Main.capitals){
            gov.add(idx.getName().toLowerCase());
        }
        gov_changeselector.setItems(gov);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_gov();
        changegov_btn.setOnAction(event -> showchange());
        placeorder_btn.setOnAction(event -> createorderview());
        myorders_btn.setOnAction(event -> onmyorder());
        logout_btn.setOnAction(event -> logout());
        gov_changeselector.setOnAction(event -> change_gov());
    }


    public void change_gov(){
        try {
            Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).setGovernorate(gov_changeselector.getSelectionModel().getSelectedItem().toLowerCase());
            Customer temp = Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx);
            Main.capitals.get(Main.governoridx).getCustomers().remove(Main.customeridx);
            Main.governoridx = Governorate.get_index(gov_changeselector.getSelectionModel().getSelectedItem().toLowerCase());
            Main.capitals.get(Main.governoridx).getCustomers().add(temp);
            Main.customeridx = Main.capitals.get(Main.governoridx).getCustomers().size()-1;
            loaction_sucsses_lbl.setVisible(true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }




    public void showchange() {
        changegov_btn.setDisable(true);
        gov_changeselector.setVisible(true);
        gov_changeselector.getSelectionModel().clearSelection();
    }
    public void createorderview() {
        Model.getInstance().getViewFactory().ShowCreateorderView();
    }
    public void onmyorder() {
        Model.getInstance().getViewFactory().ShowViewordersView();
    }
    public void logout() {
        Model.getInstance().getViewFactory().ShowLoginWindow();
    }
}
