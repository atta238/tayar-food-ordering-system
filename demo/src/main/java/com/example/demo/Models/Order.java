package com.example.demo.Models;


import java.util.ArrayList;
import java.util.List;

public class Order {
    private  int id;
    private  String restaurantName;
    private  double totalPrice;
    private int status;
    private String Governorate;
    private String addrsse;
    private String area;
    private Boolean assigne_To_delivery;


    private List<Items> OrderItems= new ArrayList<>();



    public Order() {
        totalPrice=0;
        status=0;
        assigne_To_delivery=false;
        restaurantName="";
        Governorate="";
        addrsse="";
        area="";
    }




    public void AddItem(String name, int quantity, double price,String type)
    {
        Items item=new Items(name.toLowerCase(),price,type.toLowerCase());
        item.setQuantity(quantity);
        OrderItems.add(item);
    }











    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }






    public String getRestaurantName() {
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName.toLowerCase();
    }







    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }






    public int getStatus() {

        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }






    public String getGovernorate() {
        return Governorate;
    }
    public void setGovernorate(String governorate) {
        Governorate = governorate.toLowerCase();
    }





    public String getAddrsse() {
        return addrsse;
    }
    public void setAddrsse(String addrsse) {
        this.addrsse = addrsse.toLowerCase();
    }







    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }





    public Boolean getAssigne_To_delivery() {
        return assigne_To_delivery;
    }
    public void setAssigne_To_delivery(Boolean assigne_Io_delivery) {
        this.assigne_To_delivery = assigne_Io_delivery;
    }






    public List<Items> getOrderItems() {
        return OrderItems;
    }
}
