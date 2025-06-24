package com.example.demo.Models;

import com.example.demo.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Area {

    private String Name;
    private List<Resturant> resturantlist= new ArrayList<>();
    private List<Delievry_Staff> delievryStaffs=new ArrayList<>();



    public Area(String name) {
        this.Name = name.toLowerCase();
    }


    public static int get_index(String area,int index_of_governorate)
    {
        for(Area i:Main.capitals.get(index_of_governorate).getArea_list())
        {
            if(i.Name.equals(area.toLowerCase()))
            {
                return Main.capitals.get(index_of_governorate).getArea_list().indexOf(i);
            }
        }
        return -1;
    }



    public static ObservableList<Resturant> search_category(int index_of_governorate,int index_of_area,String category)
    {
        ObservableList<Resturant> demo=FXCollections.observableArrayList();
        for(Resturant i : Main.capitals.get(index_of_governorate).getArea_list().get(index_of_area).resturantlist)
        {
            for(String j:i.getCategory())
            {
                if(j.equals(category))
                {
                    demo.add(i);
                }

            }
        }
        return demo;
    }



    public String getName() {
        return Name;
    }

    public List<Resturant> getResturantlist() {
        return resturantlist;
    }

    public List<Delievry_Staff> getDelievryStaffs() {
        return delievryStaffs;
    }
}
