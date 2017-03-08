/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.beans;

import java.util.ArrayList;

/**
 *
 * @author michael
 */
public class Order {

   
    private String orderID;
    private String userID;
    private String street;
    private String city;
    private String governorate;
    private String phone;
    private String date;
    private ArrayList<CartItem> orderItems;
    private String status;
    private double total;

    
    
     public Order(String orderID, String userID, String street, String city, String governorate, String phone, String date, ArrayList<CartItem> orderItems, String status) {
        this.orderID = orderID;
        this.userID = userID;
        this.street = street;
        this.city = city;
        this.governorate = governorate;
        this.phone = phone;
        this.date = date;
        this.orderItems = orderItems;
        this.status = status;
    }

    public Order() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<CartItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<CartItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
