/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.database;

import com.jetsmad.xshop.util.beans.User;
import java.sql.Connection;

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
        //TBE
    }
    
    public void disconnect(){
        //TBE
    }
    
    //Mostafa begin
    public void addUser(User user){
        userdao.addUser(user);
    }
    
    public String checkEmail(String email){
        return userdao.checkEmail(email);
    }
    
    public String checkPass(String email){
        return userdao.checkPass(email);
    }
    
    //Mostafa End
    
    
    //Markko start
    
    //Marko End
    
    //Michael Start
    
    //Michael End
    
}
