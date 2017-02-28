/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.database;

import com.jetsmad.xshop.util.beans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
    public void connectToDB(){
        // Marko start
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //here mydb is database name, root is username and  password
            con = DriverManager.getConnection("jdbc:mysql://localhost/xshop?user=root&password=marko");
            System.out.println("hii");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        //Marko end
    }
    
    public void disconnect(){
        // Marko start
        try {
           
            con.close();
            System.out.println("byee");

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Marko end
    }
    
    public void addUser(User user){
        userdao.addUser(user);
    }
    
    public boolean checkEmail(String email){
        return userdao.checkEmail(email);
    }
    
    public String checkPass(String email){
        return userdao.checkPass(email);
    }
    
    public User getUser(String email){
        return userdao.getUser(email);
    }
    
    // Marko start
    
        //Calling methods from ProductDAO class
        
    //Marko end
    
}
