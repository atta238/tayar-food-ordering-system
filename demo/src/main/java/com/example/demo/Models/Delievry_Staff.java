package com.example.demo.Models;

import com.example.demo.Main;

import java.util.ArrayList;
import java.util.List;

public class Delievry_Staff extends User{
        private String area;
        private String governorate;
        private int age;
        private String Phone_number;
        private Boolean deliverystaff_status;
        private int idx_gov;

        private List<Order> orders = new ArrayList<>();


        public Delievry_Staff() {
            super();
            this.area = "";
            this.governorate = "";
            this.age = 0;
            this.Phone_number = "";
            this.deliverystaff_status = true;
            this.idx_gov = 0;
        }





        public int Register(String F_name, String L_name, String Email, String Password, String Phone_number, int age, String Area1, String Governorate1) {
            try {
                int check = super.Register(F_name.toLowerCase(), L_name.toLowerCase(), Email.toLowerCase(), Password);
                if (Phone_number.length() != 11 || Phone_number.charAt(0) != '0' || Phone_number.charAt(1) != '1') {
                    check = -1;
                }
                this.age = age;
                this.Phone_number = Phone_number;
                this.area = Area1;
                this.governorate = Governorate1;
                this.idx_gov = Governorate.get_index(governorate);
                return check;
            }
            catch (NumberFormatException e) {
                return -1;
            }
        }


        public void Change_state_order(int id) {

            for(Order i:this.orders)
            {
                if(i.getId()==id)
                {
                    i.setStatus(1);
                }
            }

            this.deliverystaff_status = true;


            for (Governorate k:Main.capitals) {
                for (Customer i:k.getCustomers()) {
                    for (Order j : i.getOrders()) {
                        if (j.getArea().equals(area) && !j.getAssigne_To_delivery() && j.getGovernorate().equals(governorate)) {
                            this.orders.add(j);    // add to array_of_orders_in_delievrystaff
                            j.setStatus(-1);
                            j.setAssigne_To_delivery(true);
                            this.deliverystaff_status = false;
                            break;
                        }
                    }
                }
            }


        }


        public static int get_free_delivery(int govindex,int areaindex)
    {

        for(Delievry_Staff i:Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs())
        {
            if(i.deliverystaff_status)
            {
                return Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().indexOf(i);
            }
        }

        return -1;
    }


    @Override
    public String get_Email(){
        return this.Email;
    }

    @Override
    public String get_pass(){
        return this.Password;
    }

    public void set_deliverystaff_status(Boolean status){
            this.deliverystaff_status = status;
    }

    public List<Order> getOrders() {
        return orders;
    }

}
