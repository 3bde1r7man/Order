package aamm.order.model;

import java.util.List;



public class Customer {
    
    long id; 
    String name;
    String mail;
    String password;
    String phone;
    double balance;
    Location location;

    public Customer(String name, String mail, String password, String phone, double balance, Location location) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.balance = balance;
        
        this.location = location;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }
    

    public String getPassword() {
        return password;
    }


    public String getPhone() {
        return phone;
    }

    public double getBalance() {
        return balance;
    }


    public Location getLocation() {
        return location;
    }
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", mail=" + mail + ", password=" + password + ", phone=" + phone + ", balance=" + balance + ", location=" + location + '}';
    }
}
