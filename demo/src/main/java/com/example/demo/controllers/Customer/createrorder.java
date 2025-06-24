package com.example.demo.controllers.Customer;

import com.example.demo.Main;
import com.example.demo.Models.Area;
import com.example.demo.controllers.Model;
import com.example.demo.Models.Resturant;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class createrorder implements Initializable {
    public Button undo_btn;
    public TableView<Resturant> viewrestaurant_table;
    public TableColumn<Resturant,String> Governorate_column;
    public TableColumn<Resturant,String> namerest_column;
    public TableColumn<Resturant,String> area_column;
    public Label norest_lbl;
    public Text el7taelso8nna;
    public ChoiceBox<String> area_selector1;
    public ChoiceBox<String> category_selector1;
    public Button clear_btn;


    public ObservableList<String> areas=FXCollections.observableArrayList();
    public Set<String> categories1 = new LinkedHashSet<>();
    public ObservableList<String> categories=FXCollections.observableArrayList();
    public ObservableList<Resturant> Restaurants=FXCollections.observableArrayList();

    int idx_area;


    public  void get_array_of_areas() {
        for (Area idx : Main.capitals.get(Main.governoridx).getArea_list()) {
            areas.add(idx.getName().toLowerCase());
        }
    }

    public void get_index_area(String area) {
        for (Area i:Main.capitals.get(Main.governoridx).getArea_list()) {
            if (i.getName().equals(area)) {
                idx_area = Main.capitals.get(Main.governoridx).getArea_list().indexOf(i);
                break;
            }
        }
    }


    public  void get_array_of_categories() {
        for (Resturant idx : Main.capitals.get(Main.governoridx).getArea_list().get(idx_area).getResturantlist()) {
            categories1.addAll(idx.getCategory());
        }
    }



    public void get_allrestaurants() {
        for (Area idx : Main.capitals.get(Main.governoridx).getArea_list()) {
            Restaurants.addAll(idx.getResturantlist());
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        get_array_of_areas();
        get_allrestaurants();
        norest_lbl.setVisible(false);
        if(Restaurants.isEmpty() || Restaurants==null){
            norest_lbl.setVisible(true);
            el7taelso8nna.setVisible(false);
            viewrestaurant_table.setVisible(false);
        }
        clear_btn.setDisable(true);
        Governorate_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_Governorate()));
        namerest_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_name()));
        area_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_area()));
        viewrestaurant_table.setItems(Restaurants);
        area_selector1.setItems(areas);
        category_selector1.setDisable(true);
        undo_btn.setOnAction(event -> to_undo());
        area_selector1.setOnAction(event -> tofindarea());
        category_selector1.setOnAction(event -> tofindcateg());
        clear_btn.setOnAction(event -> clearfilter());
        viewrestaurant_table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                if (viewrestaurant_table.getSelectionModel().getSelectedItem() != null) {
                    open_rest();
                }
            }
        });
    }


public void open_rest() {
        restaurantview.set_rest(viewrestaurant_table.getSelectionModel().getSelectedItem());
        Model.getInstance().getViewFactory().Show_specific_rest();
}







    public void tofindarea() {
        clear_btn.setDisable(false);
        get_index_area(area_selector1.getSelectionModel().getSelectedItem());
        category_selector1.getSelectionModel().clearSelection();
        categories1=new LinkedHashSet<>();
        Restaurants=FXCollections.observableArrayList(Main.capitals.get(Main.governoridx).getArea_list().get(idx_area).getResturantlist());
        if(Restaurants==null || Restaurants.isEmpty()){
            category_selector1.setDisable(true);
            Restaurants=FXCollections.observableArrayList();
            clear_btn.setDisable(true);
        }
        if (!Restaurants.isEmpty()) {
            norest_lbl.setVisible(false);
            el7taelso8nna.setVisible(true);
            viewrestaurant_table.setVisible(true);
            get_array_of_categories();
            if (categories1.isEmpty()){
                category_selector1.setDisable(true);
                clear_btn.setDisable(true);
            }
            else {
                categories=FXCollections.observableArrayList(categories1);
                category_selector1.setDisable(false);
                category_selector1.setItems(categories);
            }
            Governorate_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_Governorate()));
            namerest_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_name()));
            area_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_area()));
            viewrestaurant_table.setItems(Restaurants);
        }
        else {
            norest_lbl.setVisible(true);
            el7taelso8nna.setVisible(false);
            viewrestaurant_table.setVisible(false);
        }
    }


    public void tofindcateg() {
        Restaurants=Area.search_category(Main.governoridx,idx_area,category_selector1.getSelectionModel().getSelectedItem());
        if(Restaurants==null || Restaurants.isEmpty()){
            Restaurants=FXCollections.observableArrayList();
            clear_btn.setDisable(true);
        }
        if (!Restaurants.isEmpty()) {
            norest_lbl.setVisible(false);
            el7taelso8nna.setVisible(true);
            viewrestaurant_table.setVisible(true);
            Governorate_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_Governorate()));
            namerest_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_name()));
            area_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_area()));
            viewrestaurant_table.setItems(Restaurants);
        }
        else {
            norest_lbl.setVisible(true);
            el7taelso8nna.setVisible(false);
            viewrestaurant_table.setVisible(false);
        }
    }






    public void clearfilter() {
        category_selector1.getSelectionModel().clearSelection();
        area_selector1.getSelectionModel().clearSelection();
        Restaurants=FXCollections.observableArrayList();
        get_allrestaurants();
        Governorate_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_Governorate()));
        namerest_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_name()));
        area_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get_area()));
        viewrestaurant_table.setItems(Restaurants);
        viewrestaurant_table.setVisible(true);
        norest_lbl.setVisible(false);
        category_selector1.setDisable(true);
    }





    public void to_undo() {
        category_selector1.getSelectionModel().clearSelection();
        area_selector1.getSelectionModel().clearSelection();
        Model.getInstance().getViewFactory().ShowfirstcusWindow();
    }
}
