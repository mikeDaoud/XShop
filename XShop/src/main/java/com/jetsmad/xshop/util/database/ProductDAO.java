/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.database;

import com.jetsmad.xshop.util.beans.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author michael
 */

/*
* Class that acts as a Data Access Object to perform different functionalities
* related to listed items (products), stocks, prices ...etc
*/

public class ProductDAO {

    DBController dbController;
    
    ProductDAO(DBController controller) {
        dbController = controller;
    }
    
    public boolean insertProduct(Product prdct){
        //Insert the product given into the database
        // return true if inserted , and false if not
        return false;
    }
    
    public Product getProduct(String id){
        String query = "SELECT * FROM products WHERE id=?";
        PreparedStatement pst;
        ResultSet rs;
        Product item = null;
        
        //Connect to database
        // create object Product from data and reutn it
        // return null if not found
        
        return item;
        
    }
    
    public ArrayList<Product> getAllProducts(){
        // get an array list containing all products in the database
        // and return it
        // return empty arraylist if nothing was found
        return null;
    }
    
    public ArrayList<Product> getCategoryProducts(String category){
        ArrayList<Product> products = new ArrayList<>();
        //connect to db and get result set ot products with the specific category
        // create a Product object for each item
        // create the array
        // return the Array with the list of products
        // return empty Array if nothing was found
        
        return products;
    }
    
    
    public ArrayList<Product> getPriceLimitProducts(int upper, int lower){
        //Same as above but within the price limits given
        return null;
    }
    
    public ArrayList<Product> searchProductsByName(String name){
        //Same as above but with the product name "Like" the name given
        return null;
    }
    
    public boolean updateProduct(Product prdct){
        //Update the product in the database with the product ID in the given
        //product object and return true if updated, false if not
        return false;
    }
    
}
