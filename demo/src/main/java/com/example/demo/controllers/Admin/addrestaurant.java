package com.example.demo.controllers.Admin;

import com.example.demo.Main;
import com.example.demo.Models.*;
import com.example.demo.controllers.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class addrestaurant implements Initializable {
    public Button undo_btn;
    public TextField catogery_fild;
    public ChoiceBox<String> gov_selector;
    public ChoiceBox<String> area_selector;
    public Button addrestaurant_btn;
    public Label Error_lbl;
    public TextField restname_fild1;
    public TextField price_fild;
    public TextField itemname_fild;
    public Button additem_btn;
    public Button addcategory_btn1;
    public TextField type_fild;
    public Label success_lbl;
    public Label Error_lbl2;
    public Label Error_lbl3;
    public Label success_lbl2;
    public Label success_lbl3;
    static ObservableList<String> areas= FXCollections.observableArrayList();
    static ObservableList<String> govs=FXCollections.observableArrayList();
    int idx_gov;
    int idx_area;
    int idx_rest;

    public void get_array_of_gov() {
        for( Governorate idx : Main.capitals){
            govs.add(idx.getName());
        }
    }
    public void get_array_of_areas(ObservableList<Area> areas1) {
        for (Area idx : areas1) {
            areas.add(idx.getName());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        govs=FXCollections.observableArrayList();
        areas=FXCollections.observableArrayList();
        get_array_of_gov();
        type_fild.clear();
        gov_selector.setItems(govs);
        area_selector.setDisable(true);
        addrestaurant_btn.setOnAction(e -> addrest());
        gov_selector.setOnAction(event -> open_area_select());
        undo_btn.setOnAction(event -> undo());
        addcategory_btn1.setOnAction(event -> addcateg());
        additem_btn.setOnAction(event -> additem());
    }


    public void addrest() {
        itemname_fild.clear();
        price_fild.clear();
        type_fild.clear();
        catogery_fild.clear();
        Error_lbl2.setVisible(false);
        Error_lbl3.setVisible(false);
        success_lbl2.setVisible(false);
        success_lbl3.setVisible(false);
        if (gov_selector.getValue() == null || area_selector.getValue() == null || restname_fild1.getText().isEmpty()) {
            success_lbl.setVisible(false);
            Error_lbl.setVisible(true);
        }
        else {
            try {
                idx_area = Area.get_index(area_selector.getSelectionModel().getSelectedItem().toLowerCase(), idx_gov);
                Main.moderators.get(Main.adminidx).Add_Resturant(restname_fild1.getText().toLowerCase().toLowerCase(),area_selector.getSelectionModel().getSelectedItem().toLowerCase(),gov_selector.getSelectionModel().getSelectedItem().toLowerCase());
                    Error_lbl.setVisible(false);
                    success_lbl.setVisible(true);
                    catogery_fild.setDisable(false);
                    addcategory_btn1.setDisable(false);
                    itemname_fild.setDisable(false);
                    price_fild.setDisable(false);
                    type_fild.setDisable(false);
                    additem_btn.setDisable(false);
                    restname_fild1.clear();
                    gov_selector.getSelectionModel().clearSelection();
                    area_selector.getSelectionModel().clearSelection();
                    area_selector.setDisable(true);
                }
            catch (Exception e) {
                success_lbl.setVisible(false);
                Error_lbl.setVisible(true);
            }
        }
        idx_rest=Main.capitals.get(idx_gov).getArea_list().get(idx_area).getResturantlist().size()-1;
    }


    public void addcateg() {
        success_lbl.setVisible(false);
        Error_lbl.setVisible(false);
        success_lbl3.setVisible(false);
        Error_lbl3.setVisible(false);

        if (catogery_fild.getText().isEmpty()) {
            success_lbl2.setVisible(false);
            Error_lbl2.setVisible(true);
        }
        else {
            success_lbl2.setVisible(true);
            Error_lbl2.setVisible(false);
            Main.capitals.get(idx_gov).getArea_list().get(idx_area).getResturantlist().get(idx_rest).add_category(catogery_fild.getText().toLowerCase());
            catogery_fild.clear();
        }
    }
    public void additem() {
        success_lbl.setVisible(false);
        Error_lbl.setVisible(false);
        success_lbl2.setVisible(false);
        Error_lbl2.setVisible(false);
        if (itemname_fild.getText().isEmpty() || type_fild.getText().isEmpty() || price_fild.getText().isEmpty()) {
            Error_lbl3.setVisible(true);
            success_lbl3.setVisible(false);
        }
        else {
            try {
                Main.capitals.get(idx_gov).getArea_list().get(idx_area).getResturantlist().get(idx_rest).AddItem(itemname_fild.getText().toLowerCase(), Double.parseDouble(price_fild.getText()), type_fild.getText().toLowerCase());
                Error_lbl3.setVisible(false);
                success_lbl3.setVisible(true);
                itemname_fild.clear();
                type_fild.clear();
                price_fild.clear();
            }
            catch (NumberFormatException e) {
                success_lbl3.setVisible(false);
                Error_lbl3.setVisible(true);
            }
        }
    }








    public void open_area_select() {
        areas=FXCollections.observableArrayList();
        area_selector.setDisable(false);
        if(gov_selector.getValue()!=null) {
            idx_gov=Governorate.get_index(gov_selector.getSelectionModel().getSelectedItem().toLowerCase());
            get_array_of_areas(FXCollections.observableArrayList(Main.capitals.get(idx_gov).getArea_list()));
            area_selector.setItems(areas);
        }
    }

    public void undo() {
        gov_selector.getSelectionModel().clearSelection();
        area_selector.getSelectionModel().clearSelection();
        success_lbl.setVisible(false);
        Error_lbl.setVisible(false);
        success_lbl2.setVisible(false);
        success_lbl3.setVisible(false);
        Error_lbl2.setVisible(false);
        Error_lbl3.setVisible(false);
        Model.getInstance().getViewFactory().Show_firstpageadmin();
    }

}
