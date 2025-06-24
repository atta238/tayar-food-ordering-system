package com.example.demo.Models;

import com.example.demo.Main;

public class Admin extends User {
    private String Phone_number;




    public Admin() {
        super();
        this.Phone_number="";
    }

    


    @Override
    public int Register(String F_name,String Email, String Password,String Phone_number) {
        Admin admin = new Admin();
        if(!Email.contains("@gmail.com") || Email.length()<=10) {
            return -1;
        }
        if(Password.length()<8 ) {
            return -1;
        }
        if(F_name.isEmpty()) {
            return -1;
        }
        if (Phone_number.length() != 11 || Phone_number.charAt(0) != '0' || Phone_number.charAt(1) != '1') {
            return -1;
        }
        for(int i=0; i<Password.length(); i++) {
            boolean flag1 = false;
            for(int j=0; j<=9; j++) {
                if((Password.charAt(i)-'0')==j){
                    flag1 = true;
                    break;
                }
            }
            if(!flag1) {
                return -1;
            }
        }
        admin.setF_name(F_name);
        admin.setEmail(Email);
        admin.setPassword(Password);
        admin.set_Phone_number(Phone_number);
        Main.moderators.add(admin);
        return 1;
    }






    public int Add_Delievry_stuff(String F_name, String L_name, String Email, String Password, String Phone_number, int age,String area,String governorate)
    {
        User us1=new Delievry_Staff();
        Delievry_Staff delievryStaff=(Delievry_Staff)us1;   // downcasting

       int check= delievryStaff.Register(F_name.toLowerCase(),  L_name.toLowerCase(),  Email.toLowerCase(),  Password,  Phone_number, age, area.toLowerCase(), governorate.toLowerCase());
       if(check==1) {
           int idx_gov = Governorate.get_index(governorate.toLowerCase());
           int idx_area = Area.get_index(area.toLowerCase(), idx_gov);
           for (Customer idx : Main.capitals.get(idx_gov).getCustomers()) {
               for (Order idx2 : idx.getOrders()) {
                   if (idx2.getArea().equals(area) && !idx2.getAssigne_To_delivery()) {
                       idx2.setStatus(-1);
                       idx2.setAssigne_To_delivery(true);
                       delievryStaff.getOrders().add(idx2);
                       delievryStaff.set_deliverystaff_status(false);
                       break;
                   }
               }
           }
           Main.capitals.get(idx_gov).getArea_list().get(idx_area).getDelievryStaffs().add(delievryStaff);
       }
       return check;
    }

    public int Add_Resturant(String Name , String area1,String governorate)
    {
        Resturant rest=new Resturant(Name.toLowerCase(),area1.toLowerCase(),governorate.toLowerCase());
        int gov_idx= Governorate.get_index(governorate.toLowerCase());
        int area_idx=Area.get_index(area1.toLowerCase(),gov_idx);
        if(area_idx==-1||gov_idx==-1)
        {
            return -1;
        }
        Main.capitals.get(gov_idx).getArea_list().get(area_idx).getResturantlist().add(rest);
        return 1;
    }


    public void Remove_Resturant( int restindex,int areaindex,int governorateindex) {

        Main.capitals.get(governorateindex).getArea_list().get(areaindex).getResturantlist().remove(restindex);
    }



    public void set_Phone_number(String phone_number){
        this.Phone_number=phone_number;
    }
}