/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.database;

/**
 *
 * @author michael
 */
public class DBController {
    OrderDAO orderdao;
    ProductDAO productdao;
    UserDAO userdao;

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
    
    //Mostafa End
    
    
    //Markko start
    
    //Marko End
    
    //Michael Start
    
    //Michael End
    
}
