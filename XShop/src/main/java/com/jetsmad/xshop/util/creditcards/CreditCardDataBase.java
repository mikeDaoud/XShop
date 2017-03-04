/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.creditcards;

import com.jetsmad.xshop.util.beans.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author markoiti
 */
public class CreditCardDataBase {
    //connect method
    //disconnect method

    //validateCreditCard (CredictCard)
    //checkBalance (credit card number)
    //processPayment(credit card number, amount)
    Connection con;

    public void connectToDB() {
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

    public Boolean validateCreditCard(CreditCard creditCard) {

        connectToDB();
        if (con != null) {
            try {
                String query = "SELECT * FROM creditCard WHERE creditCardNumber=? and securityCode=? and expiryMonth=? and expiryYear=? and holder_name=?";
                PreparedStatement pst;
                ResultSet rs;

                pst = con.prepareStatement(query);
                pst.setString(1, creditCard.getCreditCardNumber());
                pst.setString(2, creditCard.getSecurityCode());
                pst.setInt(3, creditCard.getExpiryMonth());
                pst.setInt(4, creditCard.getExpiryYear());
                pst.setString(5, creditCard.getHolderName());
                

                rs = pst.executeQuery();

                if (rs.next()) {
                    rs.close();
                    pst.close();
                    return true;
                }

            } catch (SQLException ex) {
                System.out.println("creditcard not found !");
                return false;

            } finally {
                disconnect();

            }
        }
        return false;
    }

    public Boolean processPayment(String creditCardNumber, double totalPrice) {
        connectToDB();
        double balance;
        if (con != null) {
            try {
                String query = "SELECT balance FROM creditCard WHERE creditCardNumber=?";
                PreparedStatement pst;
                ResultSet rs;

                pst = con.prepareStatement(query);
                pst.setString(1, creditCardNumber);

                rs = pst.executeQuery();

                if (rs.next()) {
                    balance = rs.getDouble(1);
                    if (balance >= totalPrice) {
                        String query2 = "update creditCard set balance=? where creditCardNumber=?";
                        PreparedStatement pst2;

                        pst2 = con.prepareStatement(query2);
                        pst2.setString(2, creditCardNumber);
                        pst2.setDouble(1, (balance - totalPrice));

                        pst2.executeUpdate();

                        rs.close();
                        pst.close();
                        return true;

                    }

                }

            } catch (SQLException ex) {
                System.out.println("creditcard not ubdated !");
                return false;

            } finally {
                disconnect();

            }

        }

        return false;
    }
}
