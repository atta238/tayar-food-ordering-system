package com.example.demo.Models;

import com.example.demo.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Resturant {
    private String Name;
    private String Area;
    private String Governorate;
    private List<String> Category= new ArrayList<>();
    private List<Items> Food_items=new ArrayList<>();


    public Resturant(String Name, String Area, String Governorate) {
        this.Name = Name.toLowerCase();
        this.Area = Area.toLowerCase();
        this.Governorate = Governorate.toLowerCase();
    }




    public static int get_index(String rest,int index_of_governorate,int index_of_area)
    {
        for(Resturant i : Main.capitals.get(index_of_governorate).getArea_list().get(index_of_area).getResturantlist())
        {
            if(i.Name.equals(rest.toLowerCase()))
            {
                return Main.capitals.get(index_of_governorate).getArea_list().get(index_of_area).getResturantlist().indexOf(i) ;
            }
        }

        return -1;
    }





    // update resturant


    public void add_category(String name)
    {

        this.Category.add(name.toLowerCase());
    }


    public int Remove_category(String name) {
        for (String i :this.Category) {
            if (i.equals(name.toLowerCase())) {
                this.Category.remove(i);
                return 1;
            }
        }
        return 0;
    }




    public void AddItem(String Name , double Price, String Type)
    {
        Items it=new Items(Name.toLowerCase(),Price,Type.toLowerCase());
        this.Food_items.add(it);
    }




    public int RemoveItem(String name)
    {
        for(Items i:this.Food_items)
        {
            if(i.getName().equals(name.toLowerCase()))
            {
                this.Food_items.remove(i);
                return 1;

            }
        }
        return 0;
    }




    public String get_name(){
        return Name;
    }
    public String get_area(){
        return Area;
    }
    public String get_Governorate(){
        return Governorate;
    }
    public List<String> getCategory() {
        return Category;
    }
    public List<Items> getFood_items() {
        return Food_items;
    }
}