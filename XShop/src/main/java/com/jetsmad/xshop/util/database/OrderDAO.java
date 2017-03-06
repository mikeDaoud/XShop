/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.database;

import com.jetsmad.xshop.util.beans.CartItem;
import com.jetsmad.xshop.util.beans.Order;
import com.jetsmad.xshop.util.beans.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        dbController.connectToDB();
        if (dbController.con != null) {
            try {
                String query = "insert into orders(order_id,users_id,street,city,governorate,phone,status,date) values (?,?,?,?,?,?,?,?)";
                PreparedStatement pst;

                pst = dbController.con.prepareStatement(query);
                pst.setString(1, order.getOrderID());
                pst.setString(2, order.getUserID());
                pst.setString(3, order.getStreet());
                pst.setString(4, order.getCity());
                pst.setString(5, order.getGovernorate());
                pst.setString(6, order.getPhone());
                pst.setString(7, order.getStatus());
                pst.setString(8, order.getDate());
                pst.executeUpdate();
                if (order.getOrderItems() != null) {
                for (CartItem item : order.getOrderItems()) {
                    String queryString = "INSERT INTO order_details VALUES (?, ?, ?)";
                    PreparedStatement pstmnt = dbController.con.prepareStatement(queryString);
                    pstmnt.setString(1, order.getOrderID());
                    pstmnt.setString(2, item.getProduct().getId());
                    pstmnt.setInt(2, item.getQuantity());
                    pstmnt.executeUpdate();
                }
            }
                pst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                dbController.disconnect();
            }
        }
        dbController.disconnect();
    }
    
    public Order getOrder(String orderID){
//        1. connect to database
//        2. get the order data with the given order id from the two tables (orders, order_details)
//        3. return the created Order object
//        4. disconnect database
     
        Order item = null;
        dbController.connectToDB();
        if (dbController.con != null) {
            try {
                String query = "SELECT order_id,users_id,street,city,governorate,phone,date,status FROM orders WHERE order_id=?";
                PreparedStatement pst;
                ResultSet rs;

                pst = dbController.con.prepareStatement(query);
                pst.setString(1, orderID);

                rs = pst.executeQuery();

                if (rs.next()) {
                    PreparedStatement pstDet;
                    ResultSet rsDet;
                    String queryDet = "SELECT products_id,quant FROM interests WHERE order_id=?";
                    pstDet = dbController.con.prepareStatement(queryDet);
                    pstDet.setString(1, orderID);
                    rsDet = pstDet.executeQuery();
                    ArrayList<CartItem> arrayList = new ArrayList<>();
                    while (rsDet.next()) {
                        CartItem cartItem = new CartItem();
                        Product product = dbController.productdao.getProduct(rsDet.getString(1));
                        cartItem.setQuantity(rsDet.getInt(2));
                        arrayList.add(cartItem);
                    }
                    item = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), arrayList,  rs.getString(8));
                    rsDet.close();
                    pstDet.close();
                }
                rs.close();
                pst.close();

            } catch (SQLException ex) {
                System.out.println("order not found !");

            } finally {
                dbController.disconnect();
                return item;
            }
        }
        return item;
    }
    
    public ArrayList<Order> getAllOrders(){
    
        // like get order .. only gets all the orders in the database and return array list of them
        // Instead 
        dbController.connectToDB();
        if (dbController.con != null) {
            ArrayList<Order> orders = new ArrayList<>();
            try {
                String query = "select order_id,users_id,street,city,governorate,phone,date,status from orders";
                PreparedStatement pst;
                ResultSet rs;

                pst = dbController.con.prepareStatement(query);
                rs = pst.executeQuery();
                while (rs.next()) {
                    PreparedStatement pstDet;
                    ResultSet rsDet;
                    String queryDet = "SELECT products_id,quant FROM interests WHERE order_id=?";
                    pstDet = dbController.con.prepareStatement(queryDet);
                    pstDet.setString(1, rs.getString(1));
                    rsDet = pstDet.executeQuery();
                    ArrayList<CartItem> arrayList = new ArrayList<>();
                    while (rsDet.next()) {
                        CartItem cartItem = new CartItem();
                        Product product = dbController.productdao.getProduct(rsDet.getString(1));
                        cartItem.setQuantity(rsDet.getInt(2));
                        arrayList.add(cartItem);
                    }
                    orders.add(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), arrayList,  rs.getString(8)));
                    rsDet.close();
                    pstDet.close();
                }
                rs.close();
                pst.close();

            } catch (SQLException ex) {

                return null;
            } finally {
                if (orders.isEmpty()) {
                    dbController.disconnect();
                    return null;
                } else {
                    dbController.disconnect();
                    return orders;
                }
            }

        }
        
        return null;
    }
    
    public void updateOrderStatus(String orderID, String status){
//        connect to database
//        update the status of the order with the given id to the given status
//        disconnect database
        dbController.connectToDB();
        if (dbController.con != null) {
            try {
                String query = "update orders set status=? where order_id=?";
                PreparedStatement pst;
                ResultSet rs;

                pst = dbController.con.prepareStatement(query);

                pst.setString(1, status);
                pst.setString(2, orderID);
                pst.executeUpdate();
                pst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                dbController.disconnect();
            }

        }
        dbController.disconnect();
    }
    
}
