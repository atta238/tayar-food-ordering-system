package com.example.demo.controllers.Admin;

import com.example.demo.Main;
import com.example.demo.Models.*;
import com.example.demo.controllers.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class firstpageadmin implements Initializable {
    public Button adddelivery_btn;
    public Button addrest_btn;
    public Button addadmin_btn;
    public Text el7taelso8nna;
    public TableView<Resturant> viewrest_table;
    public TableColumn<Resturant,String> namerest_column;
    public TableColumn<Resturant,String> gover_column;
    public TableColumn<Resturant,String> area_column;

    public ObservableList<Resturant> allrest = FXCollections.observableArrayList();
    public Label norest_lbl;
    public Label name_admin_lbl;
    public Button logout_btn;

    public void getAllrest() {
        for (Governorate idx : Main.capitals) {
            for (Area idx2 : idx.getArea_list()) {
                allrest.addAll(idx2.getResturantlist());
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name_admin_lbl.setText(Main.moderators.get(Main.adminidx).getF_name().toUpperCase());
        allrest=FXCollections.observableArrayList();
        getAllrest();
        if (allrest.isEmpty()) {
            norest_lbl.setVisible(true);
            viewrest_table.setVisible(false);
            el7taelso8nna.setVisible(false);
        }
        else {
            norest_lbl.setVisible(false);
            viewrest_table.setVisible(true);
            el7taelso8nna.setVisible(true);
            namerest_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_name()));
            gover_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_Governorate()));
            area_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_area()));
            viewrest_table.setItems(allrest);
        }
        viewrest_table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                if (viewrest_table.getSelectionModel().getSelectedItem() != null) {
                    open_rest();
                }
            }
        });
        addadmin_btn.setOnAction(e -> addadminpage());
        addrest_btn.setOnAction(e -> addrestpage());
        adddelivery_btn.setOnAction(event -> addtayarpage());
        logout_btn.setOnAction(event -> logout());
    }
    public void open_rest() {
        updaterest.set_rest(viewrest_table.getSelectionModel().getSelectedItem());
        Model.getInstance().getViewFactory().Show_updateresWindow();
    }
    public void addadminpage() {
        Model.getInstance().getViewFactory().Show_addadminWindow();
    }
    public void addrestpage() {
        Model.getInstance().getViewFactory().Show_addRestWindow();
    }
    public void addtayarpage() {
        Model.getInstance().getViewFactory().Show_addTayarWindow();
    }
    public void logout() {
        Model.getInstance().getViewFactory().ShowLoginWindow();
    }
}
