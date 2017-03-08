/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.database;

import com.jetsmad.xshop.util.beans.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

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

    public boolean insertProduct(Product prdct) {
        //Insert the product given into the database
        // return true if inserted , and false if not
        dbController.connectToDB();
        if (dbController.con != null) {
            try {
                String query = "insert into products(id,name,price,stock,category,description,active,image) values (?,?,?,?,?,?,?,?)";
                PreparedStatement pst;

                pst = dbController.con.prepareStatement(query);
                pst.setString(1, prdct.getId());
                pst.setString(2, prdct.getName());
                pst.setFloat(3, prdct.getPrice());
                pst.setInt(4, prdct.getStock());
                pst.setString(5, prdct.getCategory());
                pst.setString(6, prdct.getDesc());
                pst.setByte(7, (prdct.isActive() == true ? (byte) 1 : (byte) 0));
                pst.setString(8, prdct.getImg());
                pst.executeUpdate();

                pst.close();
                return true;
            } catch (SQLException ex) {

                return false;
            } finally {
                dbController.disconnect();
            }

        }
        return false;
    }

    public Product getProduct(String id) {

        //Connect to database
        // create object Product from data and reutn it
        // return null if not found
        Product item = null;
        dbController.connectToDB();
        if (dbController.con != null) {
            try {
                String query = "SELECT * FROM products WHERE id=?";
                PreparedStatement pst;
                ResultSet rs;

                pst = dbController.con.prepareStatement(query);
                pst.setString(1, id);

                rs = pst.executeQuery();

                if (rs.next()) {
                    item = new Product(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6), (rs.getInt(7) == 1 ? true : false), rs.getString(8));
                }
                rs.close();
                pst.close();

            } catch (SQLException ex) {
                System.out.println("product not found !");

            } finally {
                dbController.disconnect();
                return item;
            }
        }
        return item;
    }

    public ArrayList<Product> getAllProducts() {
        // get an array list containing all products in the database
        // and return it
        // return empty arraylist if nothing was found
        ArrayList<Product> products = new ArrayList<>();
        dbController.connectToDB();
        if (dbController.con != null) {
            try {
                String query = "select * from products";
                PreparedStatement pst;
                ResultSet rs;

                pst = dbController.con.prepareStatement(query);
                rs = pst.executeQuery();
                while (rs.next()) {
                    products.add(new Product(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6), (rs.getInt(7) == 1 ? true : false), rs.getString(8)));
                }
                rs.close();
                pst.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                dbController.disconnect();
                return products;
            }

        }
        return products;
    }

    public ArrayList<Product> getCategoryProducts(String category) {

        //connect to db and get result set ot products with the specific category
        // create a Product object for each item
        // create the array
        // return the Array with the list of products
        // return empty Array if nothing was found
        ArrayList<Product> products = new ArrayList<>();
        dbController.connectToDB();
        if (dbController.con != null) {
            try {
                String query = "select * from products where category=?";
                PreparedStatement pst;
                ResultSet rs;

                pst = dbController.con.prepareStatement(query);
                pst.setString(1, category);
                rs = pst.executeQuery();
                while (rs.next()) {
                    products.add(new Product(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6), (rs.getInt(7) == 1 ? true : false), rs.getString(8)));
                }
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                dbController.disconnect();
                return products;
            }

        }
        return products;
    }

    public ArrayList<Product> getPriceLimitProducts(String name, Float upper, Float lower) {
        //Same as above but within the price limits given
        ArrayList<Product> products = new ArrayList<>();
        dbController.connectToDB();
        if (dbController.con != null) {
            try {
                String query = "select * from products where name like ? and price between ? and ?";
                PreparedStatement pst;
                ResultSet rs;

                pst = dbController.con.prepareStatement(query);
                pst.setString(1, "%" + name + "%");
                pst.setFloat(2, lower);
                pst.setFloat(3, upper);
                rs = pst.executeQuery();
                while (rs.next()) {
                    products.add(new Product(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6), (rs.getInt(7) == 1 ? true : false), rs.getString(8)));
                }
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                dbController.disconnect();
                return products;
            }

        }
        return products;
    }

    public ArrayList<Product> getPriceLimitProducts(Float upper, Float lower) {
        //Same as above but within the price limits given
        ArrayList<Product> products = new ArrayList<>();
        dbController.connectToDB();
        if (dbController.con != null) {
            try {
                String query = "select * from products where price between ? and ?";
                PreparedStatement pst;
                ResultSet rs;

                pst = dbController.con.prepareStatement(query);

                pst.setFloat(1, lower);
                pst.setFloat(2, upper);
                rs = pst.executeQuery();
                while (rs.next()) {
                    products.add(new Product(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6), (rs.getInt(7) == 1 ? true : false), rs.getString(8)));
                }
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                dbController.disconnect();
                return products;
            }

        }
        return products;
    }

//    public ArrayList<Product> searchProductsByName(String name) {
//        //Same as above but with the product name "Like" the name given
//        dbController.connectToDB();
//        if (dbController.con != null) {
//            ArrayList<Product> products = new ArrayList<>();
//            try {
//                String query = "select * from products where name like ?";
//                PreparedStatement pst;
//                ResultSet rs;
//
//                pst = dbController.con.prepareStatement(query);
//                pst.setString(1, "%" + name + "%");
//                rs = pst.executeQuery();
//                while (rs.next()) {
//                    products.add(new Product(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6), (rs.getInt(7) == 1 ? true : false)));
//                }
//                rs.close();
//                pst.close();
//            } catch (SQLException ex) {
//                return null;
//            } finally {
//                if (products.isEmpty()) {
//                    dbController.disconnect();
//                    return null;
//                } else {
//                    dbController.disconnect();
//                    return products;
//                }
//            }
//
//        }
//        return null;
//    }
    public boolean updateProduct(Product prdct) {
        //Update the product in the database with the product ID in the given
        //product object and return true if updated, false if not
        dbController.connectToDB();
        if (dbController.con != null) {
            try {
                String query = "update products set name=?,price=?,stock=?,category=?,description=?,active=?,image=? where id=?";
                PreparedStatement pst;
                ResultSet rs;

                pst = dbController.con.prepareStatement(query);

                pst.setString(1, prdct.getName());
                pst.setFloat(2, prdct.getPrice());
                pst.setInt(3, prdct.getStock());
                pst.setString(4, prdct.getCategory());
                pst.setString(5, prdct.getDesc());
                pst.setByte(6, (prdct.isActive() == true ? (byte) 1 : (byte) 0));
                pst.setString(7, prdct.getImg());
                pst.setString(8, prdct.getId());
                if (pst.executeUpdate() > 0) {
                    pst.close();
                    return true;
                } else {
                    pst.close();
                    return false;
                }
            } catch (SQLException ex) {

                return false;
            } finally {
                dbController.disconnect();
            }

        }
        return false;
    }

    public ArrayList<String> getCategories() {
        dbController.connectToDB();
        ArrayList<String> categories = new ArrayList<>();

        try {
            String query = "SELECT DISTINCT category FROM products";
            PreparedStatement pst;
            ResultSet rs;

            pst = dbController.con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                categories.add(rs.getString(1));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            dbController.disconnect();
            return categories;

        }
    }

    public String getCountOfProducts() {
        dbController.connectToDB();

        String countOfProducts = "0";
        if (dbController.con != null) {
            try {
                String query = "select COUNT(*) from products";
                PreparedStatement pst;
                ResultSet rs;

                pst = dbController.con.prepareStatement(query);
                rs = pst.executeQuery();
                if (rs.next()) {
                    countOfProducts = rs.getString(1);
                }
                rs.close();
                pst.close();
                return countOfProducts;

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                dbController.disconnect();
            }
        }
        return countOfProducts;
    }

    public boolean updateProductStatus(String prdctId, boolean status) {
        //Update the product in the database with the product ID in the given
        //product object and return true if updated, false if not
        dbController.connectToDB();
        if (dbController.con != null) {
            try {
                String query = "update products set active=? where id=?";
                PreparedStatement pst;
                ResultSet rs;
                pst = dbController.con.prepareStatement(query);
//                System.out.println(prdctId);
//                System.out.println(status);
                pst.setByte(1, (status == true ? (byte) 1 : (byte) 0));
                pst.setString(2, prdctId);
                if (pst.executeUpdate() > 0) {
                    pst.close();
                    return true;
                } else {
                    pst.close();
                    return false;
                }
            } catch (SQLException ex) {

                return false;
            } finally {
                dbController.disconnect();
            }

        }
        return false;
    }

}
