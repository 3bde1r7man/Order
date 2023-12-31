package aamm.order.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    long id; 
    String name;
    String mail;
    String password;
    String phone;
    double balance;
    Location location;
    List<String> notifyWith;

    public Customer(String name, String mail, String password, String phone, double balance, Location location,List<String> notifyWith) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.balance = balance;
        this.location = location;
        this.notifyWith = notifyWith;

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNotifyWith(List<String> notifyWith) {
        this.notifyWith = notifyWith;
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<String> getNotifyWith()
    {
        return notifyWith;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", mail=" + mail + ", password=" + password + ", phone=" + phone + ", balance=" + balance + ", location=" + location + '}';
    }
}
