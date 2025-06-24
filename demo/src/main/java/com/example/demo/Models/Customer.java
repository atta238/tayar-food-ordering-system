package com.example.demo.Models;

import com.example.demo.Main;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    public static int order_id;
    private String governorate;
    private int age;
    private String Phone_number;
    private String Gender;

    private List<Order> orders= new ArrayList<>();



    public Customer() {
        super();
        this.governorate="";
        this.age=0;
        this.Phone_number="";
        this.Gender="";
    }






    public int Register(String F_name, String L_name, String Email, String Password, String Phone_number, int age,String Gender,String governorate)
    {
        int check=super.Register( F_name.toLowerCase(),  L_name.toLowerCase(),  Email.toLowerCase(),  Password);
        if(Phone_number.length()!=11 || Phone_number.charAt(0)!='0' || Phone_number.charAt(1)!='1') {
            check= -1;
        }
        try {
            this.age=age;
        }
        catch(NumberFormatException e) {
            return -1;
        }
        this.Gender=Gender;
        this.Phone_number=Phone_number;
        this.governorate=governorate;
        if(check!=1){
            return check;
        }
        int govindex=Governorate.get_index(this.governorate);
        Main.capitals.get(govindex).getCustomers().add(this);
        return  Main.capitals.get(govindex).getCustomers().size()-1;
    }




    public int CreateOrder(String governorate,String area,String name, Double price,String addresse)
    {
        Order order1=new Order();
        order1.setId(order_id);
        order_id++;
        order1.setRestaurantName(name.toLowerCase());
        order1.setArea(area.toLowerCase());
        order1.setAddrsse(addresse.toLowerCase());
        order1.setTotalPrice(price);
        order1.setGovernorate(governorate.toLowerCase());
        int govindex=Governorate.get_index(governorate.toLowerCase());
        int areaindex=Area.get_index(area.toLowerCase(),govindex);
        int deliveryindex=Delievry_Staff.get_free_delivery(govindex,areaindex);

        if(deliveryindex!=-1) {
            order1.setStatus(-1);
            order1.setAssigne_To_delivery(true);
            Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().get(deliveryindex).set_deliverystaff_status(false);
            Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().get(deliveryindex).getOrders().add(order1);
        }
        else {
            order1.setAssigne_To_delivery(false);
            order1.setStatus(-2);
        }
        Main.capitals.get(govindex).getCustomers().get(Main.customeridx).orders.add(order1);
        return Main.capitals.get(govindex).getCustomers().get(Main.customeridx).orders.size()-1;
    }

    public int RemoveOrder(int orderindex)
    {
        int govindex= Governorate.get_index(this.orders.get(orderindex).getGovernorate());
        int areaindex=Area.get_index(this.orders.get(orderindex).getArea(),govindex);
        Boolean found=false;


        for(Delievry_Staff j:Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs())
        {
            if(found)
                break;
            for(Order k:j.getOrders())
            {
                if(k.getId()==this.orders.get(orderindex).getId())
                {
                    j.Change_state_order(this.orders.get(orderindex).getId());
                    j.getOrders().remove(k);
                    found=true;
                    break;
                }


            }
        }
        this.orders.remove(orderindex);
        return 1;
    }




    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate.toLowerCase();
    }

    public List<Order> getOrders() {
        return orders;
    }


}