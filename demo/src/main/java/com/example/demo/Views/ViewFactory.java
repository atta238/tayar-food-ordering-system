package com.example.demo.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ViewFactory {
    Stage stage=new Stage();
    public void createScene(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene=new Scene(loader.load());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        this.stage.setScene(scene);
        this.stage.setTitle("TAYAR");
        this.stage.show();
    }










    public void ShowLoginWindow(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        createScene(loader);
    }




    public void ShowRegisterWindow(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Register.fxml"));
        createScene(loader);
    }



    public void ShowfirstcusWindow(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Customer/firstpagecus.fxml"));
        createScene(loader);
    }


    public void ShowCreateorderView() {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Customer/Createorder.fxml"));
        createScene(loader);
    }





    public void ShowViewordersView() {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Customer/viewmyorders.fxml"));
        createScene(loader);
    }


    public void ShowupdateorderView() {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Customer/update_rest.fxml"));
        createScene(loader);
    }



    public void Show_specific_rest() {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Customer/restaurantview.fxml"));
        createScene(loader);
    }



    public void Show_delivery_ordersWindow(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Delivery/Delivery.fxml"));
        createScene(loader);
    }



    public void Show_firstpageadmin(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Admin/firstpageadmin.fxml"));
        createScene(loader);
    }



    public void Show_updateresWindow(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Admin/updaterest.fxml"));
        createScene(loader);
    }


    public void Show_addadminWindow(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Admin/addadmin.fxml"));
        createScene(loader);
    }



    public void Show_addTayarWindow(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Admin/addtayar.fxml"));
        createScene(loader);
    }



    public void Show_addRestWindow(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Admin/addrestaurant.fxml"));
        createScene(loader);
    }





}
