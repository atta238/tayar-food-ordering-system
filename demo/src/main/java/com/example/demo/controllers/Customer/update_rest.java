package com.example.demo.controllers.Customer;

import com.example.demo.Main;
import com.example.demo.Models.*;
import com.example.demo.controllers.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class update_rest  implements Initializable {

    public Button undo_btn;
    public Label RestaurantName_lbl;
    public Label Governate_lbl;
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
    public Label order_id;
    public Button done_btn;
    public Label error_number_lbl;


    static Order order;
    static Resturant resturant;
    double total=0;
    int order_idx=-1;
    public static void set_order(Order order1){
        order=order1;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RestaurantName_lbl.setText(order.getRestaurantName().toUpperCase());
        Governate_lbl.setText(order.getGovernorate()+" , "+order.getArea());
        order_id.setText("ORDER_ID : "+order.getId());
        totalp_lbl.setText(order.getTotalPrice()+"$");


        for (int i=0;i<Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().size();i++){
            if (Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(i).getId()==order.getId()){
                order_idx=i;
                break;
            }
        }



        totalp_lbl.setVisible(true);
        confirm_btn.setVisible(true);
        cancel_btn.setVisible(true);
        totalp_lbl.setVisible(true);
        text1_lbl.setVisible(true);
        text2_lbl.setVisible(true);
        text3_lbl.setVisible(true);
        address_fild.setVisible(true);
        Add_btn.setVisible(true);



        totalp_lbl.setDisable(true);
        confirm_btn.setDisable(true);
        cancel_btn.setDisable(true);
        totalp_lbl.setDisable(true);
        text1_lbl.setDisable(true);
        text2_lbl.setDisable(true);
        text3_lbl.setDisable(true);
        address_fild.setText(order.getAddrsse());
        address_fild.setDisable(true);


        for ( Resturant idx: Main.capitals.get(Governorate.get_index(order.getGovernorate())).getArea_list().get(Area.get_index(order.getArea(),Governorate.get_index(order.getGovernorate()))).getResturantlist()){
            if(idx.get_name().equals(order.getRestaurantName().toLowerCase())){
                resturant=idx;
                break;
            }
        }

        for (int i=0;i<resturant.getFood_items().size();i++){
            if (i==0){
                itemname_lbl1.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl1.setVisible(true);
                price_lbl1.setText(resturant.getFood_items().get(i).getPrice()+"$");
                price_lbl1.setVisible(true);
                QTY_fild1.setVisible(true);
                QTY_fild1.setText("0");
                type1_lbl.setText(resturant.getFood_items().get(i).getType());
                type1_lbl.setVisible(true);
                for (int j=0;j<order.getOrderItems().size();j++){
                    if (order.getOrderItems().get(j).getName().equals(resturant.getFood_items().get(i).getName().toLowerCase())){
                        QTY_fild1.setText(String.valueOf(order.getOrderItems().get(j).getQuantity()));
                        break;
                    }
                }
                QTY_fild1.setDisable(true);
            }
            if(i==1){
                itemname_lbl2.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl2.setVisible(true);
                price_lbl2.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type2_lbl.setText(resturant.getFood_items().get(i).getType());
                type2_lbl.setVisible(true);
                price_lbl2.setVisible(true);
                QTY_fild2.setVisible(true);
                QTY_fild2.setText("0");
                for (int j=0;j<order.getOrderItems().size();j++){
                    if (order.getOrderItems().get(j).getName().equals(resturant.getFood_items().get(i).getName().toLowerCase())){
                        QTY_fild2.setText(String.valueOf(order.getOrderItems().get(j).getQuantity()));
                        break;
                    }
                }
                QTY_fild2.setDisable(true);
            }
            if(i==2){
                itemname_lbl3.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl3.setVisible(true);
                price_lbl3.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type3_lbl.setText(resturant.getFood_items().get(i).getType());
                type3_lbl.setVisible(true);
                price_lbl3.setVisible(true);
                QTY_fild3.setVisible(true);
                QTY_fild3.setText("0");
                for (int j=0;j<order.getOrderItems().size();j++){
                    if (order.getOrderItems().get(j).getName().equals(resturant.getFood_items().get(i).getName().toLowerCase())){
                        QTY_fild3.setText(String.valueOf(order.getOrderItems().get(j).getQuantity()));
                        break;
                    }
                }
                QTY_fild3.setDisable(true);
            }
            if(i==3){
                itemname_lbl4.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl4.setVisible(true);
                price_lbl4.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type4_lbl.setText(resturant.getFood_items().get(i).getType());
                type4_lbl.setVisible(true);
                price_lbl4.setVisible(true);
                QTY_fild4.setVisible(true);
                QTY_fild4.setText("0");
                for (int j=0;j<order.getOrderItems().size();j++){
                    if (order.getOrderItems().get(j).getName().equals(resturant.getFood_items().get(i).getName().toLowerCase())){
                        QTY_fild4.setText(String.valueOf(order.getOrderItems().get(j).getQuantity()));
                        break;
                    }
                }
                QTY_fild4.setDisable(true);
            }
            if(i==4){
                itemname_lbl5.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl5.setVisible(true);
                price_lbl5.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type5_lbl.setText(resturant.getFood_items().get(i).getType());
                type5_lbl.setVisible(true);
                price_lbl5.setVisible(true);
                QTY_fild5.setVisible(true);
                QTY_fild5.setText("0");
                for (int j=0;j<order.getOrderItems().size();j++){
                    if (order.getOrderItems().get(j).getName().equals(resturant.getFood_items().get(i).getName().toLowerCase())){
                        QTY_fild5.setText(String.valueOf(order.getOrderItems().get(j).getQuantity()));
                        break;
                    }
                }
                QTY_fild5.setDisable(true);
            }
            if(i==5){
                itemname_lbl6.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl6.setVisible(true);
                price_lbl6.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type6_lbl.setText(resturant.getFood_items().get(i).getType());
                type6_lbl.setVisible(true);
                price_lbl6.setVisible(true);
                QTY_fild6.setVisible(true);
                QTY_fild6.setText("0");
                for (int j=0;j<order.getOrderItems().size();j++){
                    if (order.getOrderItems().get(j).getName().equals(resturant.getFood_items().get(i).getName().toLowerCase())){
                        QTY_fild6.setText(String.valueOf(order.getOrderItems().get(j).getQuantity()));
                        break;
                    }
                }
                QTY_fild6.setDisable(true);
            }
            if(i==6){
                itemname_lbl7.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl7.setVisible(true);
                price_lbl7.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type7_lbl.setText(resturant.getFood_items().get(i).getType());
                type7_lbl.setVisible(true);
                price_lbl7.setVisible(true);
                QTY_fild7.setVisible(true);
                QTY_fild7.setText("0");
                for (int j=0;j<order.getOrderItems().size();j++){
                    if (order.getOrderItems().get(j).getName().equals(resturant.getFood_items().get(i).getName().toLowerCase())){
                        QTY_fild7.setText(String.valueOf(order.getOrderItems().get(j).getQuantity()));
                        break;
                    }
                }
                QTY_fild7.setDisable(true);
            }
            if(i==7){
                itemname_lbl8.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl8.setVisible(true);
                price_lbl8.setText(resturant.getFood_items().get(i).getPrice()+"$");
                type8_lbl.setText(resturant.getFood_items().get(i).getType());
                type8_lbl.setVisible(true);
                price_lbl8.setVisible(true);
                QTY_fild8.setVisible(true);
                QTY_fild8.setText("0");
                for (int j=0;j<order.getOrderItems().size();j++){
                    if (order.getOrderItems().get(j).getName().equals(resturant.getFood_items().get(i).getName().toLowerCase())){
                        QTY_fild8.setText(String.valueOf(order.getOrderItems().get(j).getQuantity()));
                        break;
                    }
                }
                QTY_fild8.setDisable(true);
            }
        }

        done_btn.setOnAction(event ->done_update_order());
        Add_btn.setOnAction(event -> update_order());
        undo_btn.setOnAction(event -> undo());
        cancel_btn.setOnAction(event -> clear_order());
        confirm_btn.setOnAction(event -> confirm_order());
    }


    public void done_update_order(){
        text1_lbl.setVisible(true);
        text2_lbl.setVisible(true);
        text3_lbl.setVisible(true);
        cancel_btn.setVisible(true);
        confirm_btn.setVisible(true);
        totalp_lbl.setVisible(true);
        address_fild.setVisible(true);



        text1_lbl.setDisable(false);
        text2_lbl.setDisable(false);
        text3_lbl.setDisable(false);
        cancel_btn.setDisable(false);
        confirm_btn.setDisable(false);
        totalp_lbl.setDisable(false);
        address_fild.setDisable(false);



        QTY_fild1.setDisable(true);
        QTY_fild2.setDisable(true);
        QTY_fild3.setDisable(true);
        QTY_fild4.setDisable(true);
        QTY_fild5.setDisable(true);
        QTY_fild6.setDisable(true);
        QTY_fild7.setDisable(true);
        QTY_fild8.setDisable(true);

        for (int i = 0; i < resturant.getFood_items().size(); i++) {
            if (i==0) {
                try {
                    error_number_lbl.setVisible(false);
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild1.getText());
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                }
            }
            if (i==1) {
                try {
                    error_number_lbl.setVisible(false);
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild2.getText());
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                }
            }
            if (i==2) {
                try {
                    error_number_lbl.setVisible(false);
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild3.getText());
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                }
            }
            if (i==3) {
                try {
                    error_number_lbl.setVisible(false);
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild4.getText());
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                }
            }
            if (i==4) {
                try {
                    error_number_lbl.setVisible(false);
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild5.getText());
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                }
            }
            if (i==5) {
                try {
                    error_number_lbl.setVisible(false);
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild6.getText());
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                }
            }
            if (i==6){
                try {
                    error_number_lbl.setVisible(false);
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild7.getText());
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                }
            }
            if (i==7){
                try {
                    error_number_lbl.setVisible(false);
                    total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild8.getText());
                }
                catch (NumberFormatException e) {
                    error_number_lbl.setVisible(true);
                }
            }
        }
        totalp_lbl.setText(total+"$");
        Add_btn.setVisible(true);
        Add_btn.setDisable(true);
        done_btn.setVisible(false);
    }
    public void update_order(){
        Add_btn.setVisible(false);
        done_btn.setVisible(true);
        QTY_fild1.setDisable(false);
        QTY_fild2.setDisable(false);
        QTY_fild3.setDisable(false);
        QTY_fild4.setDisable(false);
        QTY_fild5.setDisable(false);
        QTY_fild6.setDisable(false);
        QTY_fild7.setDisable(false);
        cancel_btn.setVisible(false);
        confirm_btn.setVisible(false);
        text1_lbl.setVisible(false);
        text2_lbl.setVisible(false);
        text3_lbl.setVisible(false);
        totalp_lbl.setVisible(false);

        cancel_btn.setDisable(false);
        confirm_btn.setDisable(false);
        totalp_lbl.setDisable(false);
        address_fild.setDisable(false);
        text1_lbl.setDisable(false);
        text2_lbl.setDisable(false);
        text3_lbl.setDisable(false);
        total=0;
        totalp_lbl.setText(total+"$");
        address_fild.setText("");
        address_fild.setVisible(false);
    }
    public void clear_order(){
        text1_lbl.setDisable(true);
        text2_lbl.setDisable(true);
        text3_lbl.setDisable(true);
        address_fild.setDisable(true);
        cancel_btn.setDisable(true);
        confirm_btn.setDisable(true);
        totalp_lbl.setDisable(true);


        Add_btn.setDisable(false);
        total=0;
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
        }
        else{
            Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(order_idx).getOrderItems().clear();
            Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(order_idx).setAddrsse(address_fild.getText().toLowerCase());
            Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders().get(order_idx).setTotalPrice(total);
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
    public void undo(){
        Model.getInstance().getViewFactory().ShowViewordersView();
    }
}
