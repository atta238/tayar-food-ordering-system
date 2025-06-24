package com.example.demo.controllers.Admin;

import com.example.demo.Main;
import com.example.demo.Models.*;
import com.example.demo.controllers.Model;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class updaterest implements Initializable {
    public Button undo_btn;
    public Button add_categ_btn;
    public Label RestaurantName_lbl;
    public Label Governate_lbl;
    public Label Area_lbl;
    public TableView<String> viewcate_table;
    public TableColumn<String,String> Categories_column;
    public TableView<Items> viewitems_table;
    public TableColumn<Items,String> item_column;
    public TableColumn<Items,Double> price_column;
    public TableColumn<Items,String> type_column;
    public Button remov_categ_btn;
    public TextField add_catogery_fild;
    public TextField add_type_fild;
    public TextField add_price_fild;
    public TextField add_itemname_fild;
    public TextField remove_itemname_fild;
    public Button add_item_btn;
    public Button remov_item_btn;

    static Resturant resturant;
    public Label noitems_lbl;
    public Label nocateg_lbl;
    public Text el7taelso8nna;
    public TextField remo_catogery_fild1;
    public Label errorcateg_lbl;
    public Label add_categ_lbl;
    public Label error_remo_item_lbl;
    public Label error_add_item_lbl;
    public Button remov_rest_btn;

    int rest_idx;
    int gov_idx;
    int area_idx;

    public static void set_rest(Resturant rest){
        resturant=rest;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gov_idx=Governorate.get_index(resturant.get_Governorate().toLowerCase());
        area_idx=Area.get_index(resturant.get_area().toLowerCase(),gov_idx);
        rest_idx=Resturant.get_index(resturant.get_name().toLowerCase(), gov_idx,area_idx);
        RestaurantName_lbl.setText(resturant.get_name().toUpperCase());
        Governate_lbl.setText(resturant.get_Governorate());
        Area_lbl.setText(resturant.get_area());
        if (resturant.getCategory().isEmpty()){
            viewcate_table.setVisible(false);
            nocateg_lbl.setVisible(true);
            remov_categ_btn.setDisable(true);
            remo_catogery_fild1.setDisable(true);
        }
        if (resturant.getFood_items().isEmpty()){
            viewitems_table.setVisible(false);
            noitems_lbl.setVisible(true);
            remov_item_btn.setDisable(true);
            remove_itemname_fild.setDisable(true);
            el7taelso8nna.setVisible(false);
        }

        if (!resturant.getFood_items().isEmpty()){
            viewitems_table.setVisible(true);
            noitems_lbl.setVisible(false);
            remov_item_btn.setDisable(false);
            remove_itemname_fild.setDisable(false);
            el7taelso8nna.setVisible(true);
            item_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
            price_column.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
            type_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
            viewitems_table.setItems(FXCollections.observableArrayList(resturant.getFood_items()));
        }
        if (!resturant.getCategory().isEmpty()){
            viewcate_table.setVisible(true);
            nocateg_lbl.setVisible(false);
            remov_categ_btn.setDisable(false);
            remo_catogery_fild1.setDisable(false);
            Categories_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
            viewcate_table.setItems(FXCollections.observableArrayList(resturant.getCategory()));
        }
        undo_btn.setOnAction(event -> undo());
        remov_categ_btn.setOnAction(event -> remove_categ());
        add_categ_btn.setOnAction(event -> add_categ());
        remov_item_btn.setOnAction(event -> remove_item());
        add_item_btn.setOnAction(event -> add_item());
        remov_rest_btn.setOnAction(event -> remove_rest());
    }



    public void undo() {
        Model.getInstance().getViewFactory().Show_firstpageadmin();
    }
    public void remove_rest(){
        Main.moderators.get(Main.adminidx).Remove_Resturant(rest_idx,area_idx,gov_idx);
        Model.getInstance().getViewFactory().Show_firstpageadmin();
    }
    public void remove_categ() {
        if (remo_catogery_fild1.getText().isEmpty()){
            errorcateg_lbl.setVisible(true);
        }
        else {
            errorcateg_lbl.setVisible(false);
            if(Main.capitals.get(gov_idx).getArea_list().get(area_idx).getResturantlist().get(rest_idx).Remove_category(remo_catogery_fild1.getText().toLowerCase())==0){
                errorcateg_lbl.setVisible(true);
            }
            else {
                errorcateg_lbl.setVisible(false);
                resturant = Main.capitals.get(gov_idx).getArea_list().get(area_idx).getResturantlist().get(rest_idx);
                remo_catogery_fild1.setText("");
                viewcate_table.refresh();
                if (resturant.getCategory().isEmpty()) {
                    viewcate_table.setVisible(false);
                    nocateg_lbl.setVisible(true);
                    remov_categ_btn.setDisable(true);
                    remo_catogery_fild1.setDisable(true);
                }
                else{
                    viewcate_table.setVisible(true);
                    nocateg_lbl.setVisible(false);
                    remov_categ_btn.setDisable(false);
                    remo_catogery_fild1.setDisable(false);
                    Categories_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
                    viewcate_table.setItems(FXCollections.observableArrayList(resturant.getCategory()));
                }
            }
        }
    }
    public void add_categ() {
        if (add_catogery_fild.getText().isEmpty()){
            add_categ_lbl.setVisible(true);
        }
        else {
            add_categ_lbl.setVisible(false);
            Main.capitals.get(gov_idx).getArea_list().get(area_idx).getResturantlist().get(rest_idx).add_category(add_catogery_fild.getText().toLowerCase());
            resturant=Main.capitals.get(gov_idx).getArea_list().get(area_idx).getResturantlist().get(rest_idx);
            add_catogery_fild.setText("");
            if (!resturant.getCategory().isEmpty()){
                viewcate_table.setVisible(true);
                nocateg_lbl.setVisible(false);
                remov_categ_btn.setDisable(false);
                remo_catogery_fild1.setDisable(false);
                Categories_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
                viewcate_table.setItems(FXCollections.observableArrayList(resturant.getCategory()));
            }
        }
    }
    public void remove_item(){
        if (remove_itemname_fild.getText().isEmpty()){
         error_remo_item_lbl.setVisible(true);
         error_add_item_lbl.setVisible(false);
        }
        else {
            error_add_item_lbl.setVisible(false);
            error_remo_item_lbl.setVisible(false);
            if(Main.capitals.get(gov_idx).getArea_list().get(area_idx).getResturantlist().get(rest_idx).RemoveItem(remove_itemname_fild.getText().toLowerCase())==0){
                error_remo_item_lbl.setVisible(true);
                error_add_item_lbl.setVisible(false);
            }
            else {
                error_add_item_lbl.setVisible(false);
                error_remo_item_lbl.setVisible(false);
                remove_itemname_fild.setText("");
                resturant = Main.capitals.get(gov_idx).getArea_list().get(area_idx).getResturantlist().get(rest_idx);
                if (resturant.getFood_items().isEmpty()) {
                    viewitems_table.setVisible(false);
                    noitems_lbl.setVisible(true);
                    remov_item_btn.setDisable(true);
                    remove_itemname_fild.setDisable(true);
                    el7taelso8nna.setVisible(false);
                }
                else {
                    viewitems_table.setVisible(true);
                    noitems_lbl.setVisible(false);
                    remov_item_btn.setDisable(false);
                    remove_itemname_fild.setDisable(false);
                    el7taelso8nna.setVisible(true);
                    item_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
                    price_column.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
                    type_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
                    viewitems_table.setItems(FXCollections.observableArrayList(resturant.getFood_items()));
                }
            }
        }
    }
    public void add_item(){
        if (add_itemname_fild.getText().isEmpty()  || add_type_fild.getText().isEmpty()  || add_price_fild.getText().isEmpty()){
            error_add_item_lbl.setVisible(true);
            error_remo_item_lbl.setVisible(false);
        }
        else {
            try {
                error_add_item_lbl.setVisible(false);
                error_remo_item_lbl.setVisible(false);
                Main.capitals.get(gov_idx).getArea_list().get(area_idx).getResturantlist().get(rest_idx).AddItem(add_itemname_fild.getText().toLowerCase(), Double.parseDouble(add_price_fild.getText()), add_type_fild.getText().toLowerCase());
                resturant = Main.capitals.get(gov_idx).getArea_list().get(area_idx).getResturantlist().get(rest_idx);
                add_itemname_fild.setText("");
                add_price_fild.setText("");
                add_type_fild.setText("");
                if (!resturant.getFood_items().isEmpty()) {
                    viewitems_table.setVisible(true);
                    noitems_lbl.setVisible(false);
                    remov_item_btn.setDisable(false);
                    remove_itemname_fild.setDisable(false);
                    el7taelso8nna.setVisible(true);
                    item_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
                    price_column.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
                    type_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
                    viewitems_table.setItems(FXCollections.observableArrayList(resturant.getFood_items()));
                }
            }
            catch (NumberFormatException e) {
                error_add_item_lbl.setVisible(true);
                error_remo_item_lbl.setVisible(false);
            }
        }
    }
}
