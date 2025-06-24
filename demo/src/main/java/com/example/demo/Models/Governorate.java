package com.example.demo.Models;
import com.example.demo.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;


public class Governorate {

    private String Name;
    private List<Area> area_list=new ArrayList<>();
    private List<Customer> customers=new ArrayList<>();

    public Governorate(String Name){

        this.Name=Name.toLowerCase();

    }


    public static int get_index(String Location_of_customer)
    {
        for(Governorate i : Main.capitals)
        {
            if(i.Name.equals(Location_of_customer.toLowerCase()))
            {
                return Main.capitals.indexOf(i);
            }
        }

        return -1;
    }


     public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name.toLowerCase();
    }

    public List<Area> getArea_list() {
        return area_list;
    }


    public List<Customer> getCustomers() {
        return customers;
    }

}
