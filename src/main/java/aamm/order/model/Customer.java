package aamm.order.model;

import java.util.List;




public class Customer {
    String name;
    String mail;
    String password;
    String phone;
    double balance;
    List<String> friends;
    Location location;

    public Customer(String name, String mail, String password, String phone, double balance, List<String> friends, Location location) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.balance = balance;
        this.friends = friends;
        this.location = location;
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

    public List<String> getFriends() {
        return friends;
    }

    public Location getLocation() {
        return location;
    }
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", mail=" + mail + ", password=" + password + ", phone=" + phone + ", balance=" + balance + ", friends=" + friends + ", location=" + location + '}';
    }


}
