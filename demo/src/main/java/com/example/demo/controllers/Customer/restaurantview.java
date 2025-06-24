package com.example.demo.controllers.Customer;

import com.example.demo.Main;
import com.example.demo.controllers.Model;
import com.example.demo.Models.Resturant;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class restaurantview implements Initializable {
    public Button undo_btn;
    public Label RestaurantName_lbl;
    public Label Governate_lbl;
    public Label Catogery_lbl;
    public TextField QTY_fild1;
    public TextField QTY_fild2;
    public TextField QTY_fild3;
    public TextField QTY_fild5;
    public TextField QTY_fild4;
    public TextField QTY_fild6;
    public TextField QTY_fild7;
    public TextField QTY_fild8;
    public Label itemname_lbl1;
    public Label itemname_lbl2;
    public Label itemname_lbl3;
    public Label itemname_lbl4;
    public Label itemname_lbl5;
    public Label itemname_lbl6;
    public Label itemname_lbl7;
    public Label itemname_lbl8;
    public Label price_lbl1;
    public Label price_lbl2;
    public Label price_lbl3;
    public Label price_lbl4;
    public Label price_lbl5;
    public Label price_lbl6;
    public Label price_lbl7;
    public Label price_lbl8;
    public Button confirm_btn;
    public Label totalp_lbl;
    public TextField address_fild;

    static Resturant resturant;
    public Label nomenu_lbl;
    public Button Add_btn;
    public Button cancel_btn;
    public Text text1_lbl;
    public Text text2_lbl;
    public Text text3_lbl;
    public Label error_lbl;
    public Label success_lbl;
    public Label error_lbl1;
    public Label type1_lbl;
    public Label type2_lbl;
    public Label type3_lbl;
    public Label type4_lbl;
    public Label type5_lbl;
    public Label type6_lbl;
    public Label type7_lbl;
    public Label type8_lbl;
    public Label error_number_lbl;

    double total=0;

    public static void set_rest(Resturant rest){
        resturant=rest;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nomenu_lbl.setVisible(true);
        RestaurantName_lbl.setText(resturant.get_name().toUpperCase());
        Governate_lbl.setText(resturant.get_Governorate()+" , "+resturant.get_area());
        if (!resturant.getCategory().isEmpty()) {
            Catogery_lbl.setText(resturant.getCategory().get(0));
        }
        else {
            Catogery_lbl.setText("");
        }
        totalp_lbl.setVisible(false);
        confirm_btn.setVisible(false);
        cancel_btn.setVisible(false);
        totalp_lbl.setVisible(false);
        text1_lbl.setVisible(false);
        text2_lbl.setVisible(false);
        text3_lbl.setVisible(false);
        address_fild.setText("");
        address_fild.setVisible(false);
        Add_btn.setVisible(false);
        for (int i=0;i<resturant.getFood_items().size();i++){
            if (i==0){
                Add_btn.setVisible(true);
                itemname_lbl1.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl1.setVisible(true);
                price_lbl1.setText(resturant.getFood_items().get(i).getPrice()+"$");
                price_lbl1.setVisible(true);
                QTY_fild1.setVisible(true);
                type1_lbl.setText(resturant.getFood_items().get(i).getType());
                type1_lbl.setVisible(true);
                nomenu_lbl.setVisible(false);
            }
            if(i==1){
                itemname_lbl2.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl2.setVisible(true);
                price_lbl2.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type2_lbl.setText(resturant.getFood_items().get(i).getType());
                type2_lbl.setVisible(true);
                price_lbl2.setVisible(true);
                QTY_fild2.setVisible(true);
            }
            if(i==2){
                itemname_lbl3.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl3.setVisible(true);
                price_lbl3.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type3_lbl.setText(resturant.getFood_items().get(i).getType());
                type3_lbl.setVisible(true);
                price_lbl3.setVisible(true);
                QTY_fild3.setVisible(true);
            }
            if(i==3){
                itemname_lbl4.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl4.setVisible(true);
                price_lbl4.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type4_lbl.setText(resturant.getFood_items().get(i).getType());
                type4_lbl.setVisible(true);
                price_lbl4.setVisible(true);
                QTY_fild4.setVisible(true);
            }
            if(i==4){
                itemname_lbl5.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl5.setVisible(true);
                price_lbl5.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type5_lbl.setText(resturant.getFood_items().get(i).getType());
                type5_lbl.setVisible(true);
                price_lbl5.setVisible(true);
                QTY_fild5.setVisible(true);
            }
            if(i==5){
                itemname_lbl6.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl6.setVisible(true);
                price_lbl6.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type6_lbl.setText(resturant.getFood_items().get(i).getType());
                type6_lbl.setVisible(true);
                price_lbl6.setVisible(true);
                QTY_fild6.setVisible(true);
            }
            if(i==6){
                itemname_lbl7.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl7.setVisible(true);
                price_lbl7.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type7_lbl.setText(resturant.getFood_items().get(i).getType());
                type7_lbl.setVisible(true);
                price_lbl7.setVisible(true);
                QTY_fild7.setVisible(true);
            }
            if(i==7){
                itemname_lbl8.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl8.setVisible(true);
                price_lbl8.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type8_lbl.setText(resturant.getFood_items().get(i).getType());
                type8_lbl.setVisible(true);
                price_lbl8.setVisible(true);
                QTY_fild8.setVisible(true);
            }
        }

        cancel_btn.setOnAction(event -> clear_order());
        confirm_btn.setOnAction(event -> confirm_order());
        Add_btn.setOnAction(event -> addorder());
        undo_btn.setOnAction(event -> undo());
    }


    public void undo(){
        Model.getInstance().getViewFactory().ShowCreateorderView();
    }


    public void clear_order(){
        text1_lbl.setVisible(false);
        text2_lbl.setVisible(false);
        text3_lbl.setVisible(false);
        address_fild.setVisible(false);
        cancel_btn.setVisible(false);
        confirm_btn.setVisible(false);
        totalp_lbl.setVisible(false);
        QTY_fild1.setDisable(false);
        QTY_fild2.setDisable(false);
        QTY_fild3.setDisable(false);
        QTY_fild4.setDisable(false);
        QTY_fild5.setDisable(false);
        QTY_fild6.setDisable(false);
        QTY_fild7.setDisable(false);
        QTY_fild8.setDisable(false);
        Add_btn.setDisable(false);
        total=0;
        totalp_lbl.setText("0");
        address_fild.setText("");
        error_lbl.setVisible(false);
        success_lbl.setVisible(false);
        error_lbl1.setVisible(false);
        error_number_lbl.setVisible(false);
    }

    public void confirm_order(){
        if (address_fild.getText().isEmpty()){
         error_lbl.setVisible(true);
         success_lbl.setVisible(false);
         error_lbl1.setVisible(false);
         error_number_lbl.setVisible(false);
        }
        else if (total==0){
            error_lbl1.setVisible(true);
            error_lbl.setVisible(false);
            success_lbl.setVisible(false);
            error_number_lbl.setVisible(false);
        }
        else{
            int order_idx=Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).CreateOrder(resturant.get_Governorate().toLowerCase(),resturant.get_area().toLowerCase(),resturant.get_name().toLowerCase(),total,address_fild.getText().toLowerCase());
            if (!QTY_fild1.getText().equals("0")){
                Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(order_idx).AddItem(itemname_lbl1.getText().toLowerCase(),Integer.parseInt(QTY_fild1.getText()),Double.parseDouble(price_lbl1.getText().substring(0,price_lbl1.getText().length()-1)),type1_lbl.getText().toLowerCase());
            }
            if (!QTY_fild2.getText().equals("0")){
                Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(order_idx).AddItem(itemname_lbl2.getText().toLowerCase(),Integer.parseInt(QTY_fild2.getText()),Double.parseDouble(price_lbl2.getText().substring(0,price_lbl2.getText().length()-1)),type2_lbl.getText().toLowerCase());
            }
            if (!QTY_fild3.getText().equals("0")){
                Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(order_idx).AddItem(itemname_lbl3.getText().toLowerCase(),Integer.parseInt(QTY_fild3.getText()),Double.parseDouble(price_lbl3.getText().substring(0,price_lbl3.getText().length()-1)),type3_lbl.getText().toLowerCase());
            }
            if (!QTY_fild4.getText().equals("0")){
                Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(order_idx).AddItem(itemname_lbl4.getText().toLowerCase(),Integer.parseInt(QTY_fild4.getText()),Double.parseDouble(price_lbl4.getText().substring(0,price_lbl4.getText().length()-1)),type4_lbl.getText().toLowerCase());
            }
            if (!QTY_fild5.getText().equals("0")){
                Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(order_idx).AddItem(itemname_lbl5.getText().toLowerCase(),Integer.parseInt(QTY_fild5.getText()),Double.parseDouble(price_lbl5.getText().substring(0,price_lbl5.getText().length()-1)),type5_lbl.getText().toLowerCase());
            }
            if (!QTY_fild6.getText().equals("0")){
                Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(order_idx).AddItem(itemname_lbl6.getText().toLowerCase(),Integer.parseInt(QTY_fild6.getText()),Double.parseDouble(price_lbl6.getText().substring(0,price_lbl6.getText().length()-1)),type6_lbl.getText().toLowerCase());
            }
            if (!QTY_fild7.getText().equals("0")){
                Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(order_idx).AddItem(itemname_lbl7.getText().toLowerCase(),Integer.parseInt(QTY_fild7.getText()),Double.parseDouble(price_lbl7.getText().substring(0,price_lbl7.getText().length()-1)),type7_lbl.getText().toLowerCase());
            }
            if (!QTY_fild8.getText().equals("0")){
                Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(order_idx).AddItem(itemname_lbl8.getText().toLowerCase(),Integer.parseInt(QTY_fild8.getText()),Double.parseDouble(price_lbl8.getText().substring(0,price_lbl8.getText().length()-1)),type8_lbl.getText().toLowerCase());
            }
            success_lbl.setVisible(true);
            error_lbl.setVisible(false);
            error_lbl1.setVisible(false);
            error_number_lbl.setVisible(false);
            Model.getInstance().getViewFactory().ShowViewordersView();
        }
    }


    public void addorder() {

        for (int i = 0; i < resturant.getFood_items().size(); i++) {
            if (i==0) {
                try {
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild1.getText());
                    text1_lbl.setVisible(true);
                    text2_lbl.setVisible(true);
                    text3_lbl.setVisible(true);
                    cancel_btn.setVisible(true);
                    confirm_btn.setVisible(true);
                    totalp_lbl.setVisible(true);
                    address_fild.setVisible(true);
                    QTY_fild1.setDisable(true);
                    QTY_fild2.setDisable(true);
                    QTY_fild3.setDisable(true);
                    QTY_fild4.setDisable(true);
                    QTY_fild5.setDisable(true);
                    QTY_fild6.setDisable(true);
                    QTY_fild7.setDisable(true);
                    QTY_fild8.setDisable(true);
                    Add_btn.setDisable(true);
                    error_number_lbl.setVisible(false);
                }
                catch (NumberFormatException e) {
                 error_number_lbl.setVisible(true);
                 Add_btn.setDisable(false);
                    text1_lbl.setVisible(false);
                    text2_lbl.setVisible(false);
                    text3_lbl.setVisible(false);
                    cancel_btn.setVisible(false);
                    confirm_btn.setVisible(false);
                    totalp_lbl.setVisible(false);
                    address_fild.setVisible(false);
                    QTY_fild1.setDisable(false);
                    QTY_fild2.setDisable(false);
                    QTY_fild3.setDisable(false);
                    QTY_fild4.setDisable(false);
                    QTY_fild5.setDisable(false);
                    QTY_fild6.setDisable(false);
                    QTY_fild7.setDisable(false);
                    QTY_fild8.setDisable(false);
                }
            }
            if (i==1) {
                try {
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild2.getText());
                    text1_lbl.setVisible(true);
                    text2_lbl.setVisible(true);
                    text3_lbl.setVisible(true);
                    cancel_btn.setVisible(true);
                    confirm_btn.setVisible(true);
                    totalp_lbl.setVisible(true);
                    address_fild.setVisible(true);
                    QTY_fild1.setDisable(true);
                    QTY_fild2.setDisable(true);
                    QTY_fild3.setDisable(true);
                    QTY_fild4.setDisable(true);
                    QTY_fild5.setDisable(true);
                    QTY_fild6.setDisable(true);
                    QTY_fild7.setDisable(true);
                    QTY_fild8.setDisable(true);
                    Add_btn.setDisable(true);
                    error_number_lbl.setVisible(false);
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                    Add_btn.setDisable(false);
                    text1_lbl.setVisible(false);
                    text2_lbl.setVisible(false);
                    text3_lbl.setVisible(false);
                    cancel_btn.setVisible(false);
                    confirm_btn.setVisible(false);
                    totalp_lbl.setVisible(false);
                    address_fild.setVisible(false);
                    QTY_fild1.setDisable(false);
                    QTY_fild2.setDisable(false);
                    QTY_fild3.setDisable(false);
                    QTY_fild4.setDisable(false);
                    QTY_fild5.setDisable(false);
                    QTY_fild6.setDisable(false);
                    QTY_fild7.setDisable(false);
                    QTY_fild8.setDisable(false);
                }
            }
            if (i==2) {
                try {
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild3.getText());
                    text1_lbl.setVisible(true);
                    text2_lbl.setVisible(true);
                    text3_lbl.setVisible(true);
                    cancel_btn.setVisible(true);
                    confirm_btn.setVisible(true);
                    totalp_lbl.setVisible(true);
                    address_fild.setVisible(true);
                    QTY_fild1.setDisable(true);
                    QTY_fild2.setDisable(true);
                    QTY_fild3.setDisable(true);
                    QTY_fild4.setDisable(true);
                    QTY_fild5.setDisable(true);
                    QTY_fild6.setDisable(true);
                    QTY_fild7.setDisable(true);
                    QTY_fild8.setDisable(true);
                    Add_btn.setDisable(true);
                    error_number_lbl.setVisible(false);
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                    Add_btn.setDisable(false);
                    text1_lbl.setVisible(false);
                    text2_lbl.setVisible(false);
                    text3_lbl.setVisible(false);
                    cancel_btn.setVisible(false);
                    confirm_btn.setVisible(false);
                    totalp_lbl.setVisible(false);
                    address_fild.setVisible(false);
                    QTY_fild1.setDisable(false);
                    QTY_fild2.setDisable(false);
                    QTY_fild3.setDisable(false);
                    QTY_fild4.setDisable(false);
                    QTY_fild5.setDisable(false);
                    QTY_fild6.setDisable(false);
                    QTY_fild7.setDisable(false);
                    QTY_fild8.setDisable(false);
                }
            }
            if (i==3) {
                try {
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild4.getText());
                    text1_lbl.setVisible(true);
                    text2_lbl.setVisible(true);
                    text3_lbl.setVisible(true);
                    cancel_btn.setVisible(true);
                    confirm_btn.setVisible(true);
                    totalp_lbl.setVisible(true);
                    address_fild.setVisible(true);
                    QTY_fild1.setDisable(true);
                    QTY_fild2.setDisable(true);
                    QTY_fild3.setDisable(true);
                    QTY_fild4.setDisable(true);
                    QTY_fild5.setDisable(true);
                    QTY_fild6.setDisable(true);
                    QTY_fild7.setDisable(true);
                    QTY_fild8.setDisable(true);
                    Add_btn.setDisable(true);
                    error_number_lbl.setVisible(false);
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                    Add_btn.setDisable(false);
                    text1_lbl.setVisible(false);
                    text2_lbl.setVisible(false);
                    text3_lbl.setVisible(false);
                    cancel_btn.setVisible(false);
                    confirm_btn.setVisible(false);
                    totalp_lbl.setVisible(false);
                    address_fild.setVisible(false);
                    QTY_fild1.setDisable(false);
                    QTY_fild2.setDisable(false);
                    QTY_fild3.setDisable(false);
                    QTY_fild4.setDisable(false);
                    QTY_fild5.setDisable(false);
                    QTY_fild6.setDisable(false);
                    QTY_fild7.setDisable(false);
                    QTY_fild8.setDisable(false);
                }
            }
            if (i==4) {
                try {
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild5.getText());
                    text1_lbl.setVisible(true);
                    text2_lbl.setVisible(true);
                    text3_lbl.setVisible(true);
                    cancel_btn.setVisible(true);
                    confirm_btn.setVisible(true);
                    totalp_lbl.setVisible(true);
                    address_fild.setVisible(true);
                    QTY_fild1.setDisable(true);
                    QTY_fild2.setDisable(true);
                    QTY_fild3.setDisable(true);
                    QTY_fild4.setDisable(true);
                    QTY_fild5.setDisable(true);
                    QTY_fild6.setDisable(true);
                    QTY_fild7.setDisable(true);
                    QTY_fild8.setDisable(true);
                    Add_btn.setDisable(true);
                    error_number_lbl.setVisible(false);
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                    Add_btn.setDisable(false);
                    text1_lbl.setVisible(false);
                    text2_lbl.setVisible(false);
                    text3_lbl.setVisible(false);
                    cancel_btn.setVisible(false);
                    confirm_btn.setVisible(false);
                    totalp_lbl.setVisible(false);
                    address_fild.setVisible(false);
                    QTY_fild1.setDisable(false);
                    QTY_fild2.setDisable(false);
                    QTY_fild3.setDisable(false);
                    QTY_fild4.setDisable(false);
                    QTY_fild5.setDisable(false);
                    QTY_fild6.setDisable(false);
                    QTY_fild7.setDisable(false);
                    QTY_fild8.setDisable(false);
                }
            }
            if (i==5) {
                try {
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild6.getText());
                    text1_lbl.setVisible(true);
                    text2_lbl.setVisible(true);
                    text3_lbl.setVisible(true);
                    cancel_btn.setVisible(true);
                    confirm_btn.setVisible(true);
                    totalp_lbl.setVisible(true);
                    address_fild.setVisible(true);
                    QTY_fild1.setDisable(true);
                    QTY_fild2.setDisable(true);
                    QTY_fild3.setDisable(true);
                    QTY_fild4.setDisable(true);
                    QTY_fild5.setDisable(true);
                    QTY_fild6.setDisable(true);
                    QTY_fild7.setDisable(true);
                    QTY_fild8.setDisable(true);
                    Add_btn.setDisable(true);
                    error_number_lbl.setVisible(false);
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                    Add_btn.setDisable(false);
                    text1_lbl.setVisible(false);
                    text2_lbl.setVisible(false);
                    text3_lbl.setVisible(false);
                    cancel_btn.setVisible(false);
                    confirm_btn.setVisible(false);
                    totalp_lbl.setVisible(false);
                    address_fild.setVisible(false);
                    QTY_fild1.setDisable(false);
                    QTY_fild2.setDisable(false);
                    QTY_fild3.setDisable(false);
                    QTY_fild4.setDisable(false);
                    QTY_fild5.setDisable(false);
                    QTY_fild6.setDisable(false);
                    QTY_fild7.setDisable(false);
                    QTY_fild8.setDisable(false);
                }
            }
            if (i==6){
                try {
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild7.getText());
                    text1_lbl.setVisible(true);
                    text2_lbl.setVisible(true);
                    text3_lbl.setVisible(true);
                    cancel_btn.setVisible(true);
                    confirm_btn.setVisible(true);
                    totalp_lbl.setVisible(true);
                    address_fild.setVisible(true);
                    QTY_fild1.setDisable(true);
                    QTY_fild2.setDisable(true);
                    QTY_fild3.setDisable(true);
                    QTY_fild4.setDisable(true);
                    QTY_fild5.setDisable(true);
                    QTY_fild6.setDisable(true);
                    QTY_fild7.setDisable(true);
                    QTY_fild8.setDisable(true);
                    Add_btn.setDisable(true);
                    error_number_lbl.setVisible(false);
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                    Add_btn.setDisable(false);
                    text1_lbl.setVisible(false);
                    text2_lbl.setVisible(false);
                    text3_lbl.setVisible(false);
                    cancel_btn.setVisible(false);
                    confirm_btn.setVisible(false);
                    totalp_lbl.setVisible(false);
                    address_fild.setVisible(false);
                    QTY_fild1.setDisable(false);
                    QTY_fild2.setDisable(false);
                    QTY_fild3.setDisable(false);
                    QTY_fild4.setDisable(false);
                    QTY_fild5.setDisable(false);
                    QTY_fild6.setDisable(false);
                    QTY_fild7.setDisable(false);
                    QTY_fild8.setDisable(false);
                }
            }
            if (i==7){
                try {
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild8.getText());
                    text1_lbl.setVisible(true);
                    text2_lbl.setVisible(true);
                    text3_lbl.setVisible(true);
                    cancel_btn.setVisible(true);
                    confirm_btn.setVisible(true);
                    totalp_lbl.setVisible(true);
                    address_fild.setVisible(true);
                    QTY_fild1.setDisable(true);
                    QTY_fild2.setDisable(true);
                    QTY_fild3.setDisable(true);
                    QTY_fild4.setDisable(true);
                    QTY_fild5.setDisable(true);
                    QTY_fild6.setDisable(true);
                    QTY_fild7.setDisable(true);
                    QTY_fild8.setDisable(true);
                    Add_btn.setDisable(true);
                    error_number_lbl.setVisible(false);
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                    Add_btn.setDisable(false);
                    text1_lbl.setVisible(false);
                    text2_lbl.setVisible(false);
                    text3_lbl.setVisible(false);
                    cancel_btn.setVisible(false);
                    confirm_btn.setVisible(false);
                    totalp_lbl.setVisible(false);
                    address_fild.setVisible(false);
                    QTY_fild1.setDisable(false);
                    QTY_fild2.setDisable(false);
                    QTY_fild3.setDisable(false);
                    QTY_fild4.setDisable(false);
                    QTY_fild5.setDisable(false);
                    QTY_fild6.setDisable(false);
                    QTY_fild7.setDisable(false);
                    QTY_fild8.setDisable(false);
                }
            }
        }
        totalp_lbl.setText(total+"$");
    }
}
