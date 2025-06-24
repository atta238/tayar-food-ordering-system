package com.example.demo.Models;

public abstract class User {
    protected String F_name;
    protected String L_name ;
    protected String Email ;
    protected String Password ;



    public User(){
        F_name = "";
        L_name = "";
        Email = "";
        Password = "";
    }

    public int Register(String F_name, String L_name, String Email, String Password) {
        if(!Email.contains("@gmail.com") && Email.length()<=10) {
            return -1;
        }
        if(Password.length()<8 ) {
            return -1;
        }
        if(F_name.isEmpty()) {
            return -1;
        }
        if(L_name.isEmpty()) {
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
        this.F_name = F_name;
        this.L_name = L_name;
        this.Email = Email;
        this.Password = Password;

        return 1;
    }






    public String getF_name() {
        return this.F_name;
    }

    public void setF_name(String F_name) {
        this.F_name = F_name.toLowerCase();
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setEmail(String Email) {
        this.Email = Email.toLowerCase();
    }

    public String get_Email(){
        return this.Email;
    };

    public String  get_pass(){
        return this.Password;
    };

}