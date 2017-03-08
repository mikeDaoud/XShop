/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.database;

import com.jetsmad.xshop.util.beans.Order;
import com.jetsmad.xshop.util.beans.Product;
import com.jetsmad.xshop.util.beans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author michael
 */
public class DBController {

    OrderDAO orderdao;
    ProductDAO productdao;
    UserDAO userdao;
    Connection con;

    public DBController() {
        orderdao = new OrderDAO(this);
        productdao = new ProductDAO(this);
        userdao = new UserDAO(this);
    }

    public void connectToDB() {
        // Marko start
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //here mydb is database name, root is username and  password
            con = DriverManager.getConnection("jdbc:mysql://localhost/xshop?user=root&password=123");
            System.out.println("hii");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        //Marko end
    }

    public void disconnect() {
        // Marko start
        try {

            con.close();
            System.out.println("byee");

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Marko end
    }

    public void addUser(User user) {
        userdao.addUser(user);
    }

    public boolean checkEmail(String email) {
        return userdao.checkEmail(email);
    }

    public String checkPass(String email) {
        return userdao.checkPass(email);
    }

    public User getUser(String email) {
        return userdao.getUser(email);
    }

    // Marko start
    public boolean insertProduct(Product prdct) {
        return productdao.insertProduct(prdct);
    }

    public Product getProduct(String id) {
        return productdao.getProduct(id);
    }

    public ArrayList<Product> getAllProducts() {
        return productdao.getAllProducts();
    }

    public ArrayList<Product> getCategoryProducts(String category) {
        return productdao.getCategoryProducts(category);
    }

    public ArrayList<Product> getPriceLimitProducts(String name, Float upper, Float lower) {
        return productdao.getPriceLimitProducts(name, upper, lower);
    }

    public ArrayList<Product> getPriceLimitProducts(Float upper, Float lower) {
        return productdao.getPriceLimitProducts(upper, lower);
    }
//    public ArrayList<Product> searchProductsByName(String name) {
//        return productdao.searchProductsByName(name);
//    }

    public boolean updateProduct(Product prdct) {
        return productdao.updateProduct(prdct);
    }

    //Marko end
    public ArrayList<String> getCategories() {
        return productdao.getCategories();
    }

    public User getUserById(String id) {
        return userdao.getUserById(id);
    }

    public void ubdateUser(User user) {
        userdao.ubdateUser(user);
    }

    public ArrayList<User> getAllUsers() {
        return userdao.getAllUsers();
    }

    public void insertOrder(Order order) {
        orderdao.insertOrder(order);
    }

    public Order getOrder(String orderID) {
        return orderdao.getOrder(orderID);
    }

    public ArrayList<Order> getAllOrders() {
        return orderdao.getAllOrders();
    }

    public ArrayList<Order> getUserOrders(String userID) {
        return orderdao.getUserOrders(userID);
    }

    public void updateOrderStatus(String orderID, String status) {
        orderdao.updateOrderStatus(orderID, status);
    }
    
    public String[] getDashboardData(){
        //in order
            //get count of users table
            //get count of products
            //get total of toals of all orders
            //get total no. of pending orders
            
            //put all the data in the array and return 
            String[] dashboardData = {userdao.getCountOfUsers(),productdao.getCountOfProducts(),orderdao.getTotalOfTotalOfAllOrders(),orderdao.getCountOfPendingOrders()};
            return dashboardData;
    }

    public ArrayList<Order> getPendingOrders() {
        return orderdao.getPendingOrders();
    }
    public boolean updateProductStatus(String prdctId , boolean status) {
        return productdao.updateProductStatus(prdctId, status);
    }
    }
