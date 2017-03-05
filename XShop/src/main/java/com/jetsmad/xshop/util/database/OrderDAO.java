/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.database;

import com.jetsmad.xshop.util.beans.Order;
import java.util.ArrayList;

/**
 *
 * @author michael
 */

/*
* Class that acts as a Data Access Object to perform different functionalities
* related to sales records and user's shopping carts
*/

public class OrderDAO {
    
    private DBController dbController;

    OrderDAO(DBController controller) {
       dbController = controller;
    }
    
    public void insertOrder(Order order){
    
//        1. connect to database
//        2. insert the order data in the two tables (orders, order_details)
//        3. disconnect database
        
    }
    
    public Order getOrder(int orderID){
//        1. connect to database
//        2. get the order data with the given order id from the two tables (orders, order_details)
//        3. return the created Order object
//        4. disconnect database
     
        return null;
    }
    
    public ArrayList<Order> getAllOrders(){
    
        // like get order .. only gets all the orders in the database and return array list of them
        // Instead 
        
        return null;
    }
    
    public void updateOrderStatus(String orderID, String status){
//        connect to database
//        update the status of the order with the given id to the given status
//        disconnect database
    }
    
}
