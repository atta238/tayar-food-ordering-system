package com.example.demo;



import com.example.demo.Models.*;
import com.example.demo.controllers.Model;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    public static List<Admin> moderators = new ArrayList<>();  //save
    public static List<Governorate> capitals = new ArrayList<>(); //save
    public static int customeridx;
    public static int deliveryidx;
    public static int adminidx=0;
    public static int governoridx=0;
    public static int area_del_idx;



    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().ShowLoginWindow();
    }

    public static void main(String[] args) {

        capitals = JsonHandler.readJsonFile(Governorate[].class);
        moderators = JsonHandler.loadAdmins();
        Customer.order_id = JsonHandler.readOrderid();
        launch(args);
        JsonHandler.writeOrderid(Customer.order_id);
        JsonHandler.saveAdmins(moderators);
        JsonHandler.writecapitalsFile(capitals,Governorate[].class);
    }
}