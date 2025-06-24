package com.example.demo.Models;

import com.example.demo.Main;

public class Items {
    private String Name;
    private double Price;
    private String type;
    private int quantity;

    public Items(String Name, double Price, String type) {
        this.Name = Name.toLowerCase();
        this.Price = Price;
        this.type = type.toLowerCase();
        this.quantity = 0;
    }



    public String getName() {
        return Name;
    }


    public double getPrice() {
        return Price;
    }


    public String getType() {
        return type;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
