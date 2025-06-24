package com.example.demo.controllers.Delivery;

import com.example.demo.Main;
import com.example.demo.controllers.Model;
import com.example.demo.Models.Order;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
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

public class Deliverycontroller implements Initializable {
    public TableView<Order> vieworder_table;
    public TableColumn<Order,Integer> OrderID_column;
    public TableColumn<Order,String> namerest_column;
    public TableColumn<Order,String> Status_column;
    public TableColumn<Order,Double> price_column;
    public TableColumn<Order,String> Area_column;
    public Label noorder_lbl;
    public Text el7taelso8nna;
    public Button done1_lbl;
    public Button done2_lbl;
    public Button done3_lbl;
    public Button done4_lbl;
    public Button done5_lbl;
    public Button done6_lbl;
    public Button done7_lbl;
    public Button logout_btn;

    public ObservableList<Order> orderlist= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        done1_lbl.setVisible(false);
        done2_lbl.setVisible(false);
        done3_lbl.setVisible(false);
        done4_lbl.setVisible(false);
        done5_lbl.setVisible(false);
        done6_lbl.setVisible(false);
        done7_lbl.setVisible(false);
        orderlist=FXCollections.observableArrayList(Main.capitals.get(Main.governoridx).getArea_list().get(Main.area_del_idx).getDelievryStaffs().get(Main.deliveryidx).getOrders());

        if(orderlist.isEmpty()){
            noorder_lbl.setVisible(true);
            vieworder_table.setVisible(false);
            el7taelso8nna.setVisible(false);
        }
        else {
            for (int i=0;i<orderlist.size();i++) {
                if (i == 0 && orderlist.get(i).getStatus()!=1) {
                    done1_lbl.setVisible(true);
                }
                if (i == 1 && orderlist.get(i).getStatus()!=1) {
                    done2_lbl.setVisible(true);
                }
                if (i == 2 && orderlist.get(i).getStatus()!=1) {
                    done3_lbl.setVisible(true);
                }
                if (i == 3 && orderlist.get(i).getStatus()!=1) {
                    done4_lbl.setVisible(true);
                }
                if (i == 4 && orderlist.get(i).getStatus()!=1)  {
                    done5_lbl.setVisible(true);
                }
                if (i == 5 && orderlist.get(i).getStatus()!=1) {
                    done6_lbl.setVisible(true);
                }
                if (i == 6 && orderlist.get(i).getStatus()!=1) {
                    done7_lbl.setVisible(true);
                }
            }
            el7taelso8nna.setVisible(true);
            noorder_lbl.setVisible(false);
            vieworder_table.setVisible(true);
            Area_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArea()));
            OrderID_column.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
            namerest_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRestaurantName()));
            price_column.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTotalPrice()).asObject());
            Status_column.setCellValueFactory(cellData -> {
                if(cellData.getValue().getStatus()==1){
                    return new SimpleStringProperty("delivered");
                }
                else if(cellData.getValue().getStatus()==-1){
                    return new SimpleStringProperty("pending");
                }
                else {
                    return new SimpleStringProperty("waiting");
                }
            });
            vieworder_table.setItems(orderlist);


            done1_lbl.setOnAction(event -> change_state(0));
            done2_lbl.setOnAction(event -> change_state(1));
            done3_lbl.setOnAction(event -> change_state(2));
            done4_lbl.setOnAction(event -> change_state(3));
            done5_lbl.setOnAction(event ->change_state(4));
            done6_lbl.setOnAction(event -> change_state(5));
            done7_lbl.setOnAction(event -> change_state(6));

        }
        logout_btn.setOnAction(event -> logout());
    }



    public void change_state(int j){
       int order_id=Main.capitals.get(Main.governoridx).getArea_list().get(Main.area_del_idx).getDelievryStaffs().get(Main.deliveryidx).getOrders().get(j).getId();
        Main.capitals.get(Main.governoridx).getArea_list().get(Main.area_del_idx).getDelievryStaffs().get(Main.deliveryidx).Change_state_order(order_id);
        vieworder_table.refresh();
        orderlist=FXCollections.observableArrayList(Main.capitals.get(Main.governoridx).getArea_list().get(Main.area_del_idx).getDelievryStaffs().get(Main.deliveryidx).getOrders());
        vieworder_table.setItems(orderlist);
        if (j == 0) {
            done1_lbl.setVisible(false);
        }
        if (j == 1) {
            done2_lbl.setVisible(false);
        }
        if (j== 2) {
            done3_lbl.setVisible(false);
        }
        if (j == 3) {
            done4_lbl.setVisible(false);
        }
        if (j == 4) {
            done5_lbl.setVisible(false);
        }
        if (j == 5) {
            done6_lbl.setVisible(false);
        }
        if (j == 6) {
            done7_lbl.setVisible(false);
        }

        for (int i=0;i<orderlist.size();i++) {
            if (i == 0 && orderlist.get(i).getStatus()!=1) {
                done1_lbl.setVisible(true);
            }
            if (i == 1 && orderlist.get(i).getStatus()!=1) {
                done2_lbl.setVisible(true);
            }
            if (i == 2 && orderlist.get(i).getStatus()!=1) {
                done3_lbl.setVisible(true);
            }
            if (i == 3 && orderlist.get(i).getStatus()!=1) {
                done4_lbl.setVisible(true);
            }
            if (i == 4 && orderlist.get(i).getStatus()!=1)  {
                done5_lbl.setVisible(true);
            }
            if (i == 5 && orderlist.get(i).getStatus()!=1) {
                done6_lbl.setVisible(true);
            }
            if (i == 6 && orderlist.get(i).getStatus()!=1) {
                done7_lbl.setVisible(true);
            }
        }
    }


    public void logout(){

        Model.getInstance().getViewFactory().ShowLoginWindow();
    }
}