/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.database;

import com.jetsmad.xshop.util.beans.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michael
 */

/*
* Class that acts as a Data Access Object to perform different functionalities
* related to listed users. adding, deleting, updating and retrieving 
* user related data
*/


public class UserDAO {

    DBController controller;
    
    UserDAO(DBController aThis) {
        controller = aThis;
    }
    
    public void addUser(User user){
        PreparedStatement pst;
        String query = "INSERT INTO users (name, email, dob, password, address, job) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            controller.connectToDB();
            pst = controller.con.prepareStatement(query);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getDob());
            pst.setString(4, user.getPassword());
            pst.setString(5, user.getAddress());
            pst.setString(6, user.getJob());
            pst.executeUpdate();
            for(String interest:user.getInterests()){
                String queryString = "INSERT INTO interests VALUES (?, ?)";
                pst = controller.con.prepareStatement(queryString);
                pst.setString(1, user.getId());
                pst.setString(2, interest);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            controller.disconnect();
        }
    }
    
    public String checkEmail(String email){
        String res = "notFound";
        PreparedStatement pst;
        ResultSet rs;
        String query = "SELECT * FROM users WHERE email=?";
        try {
            controller.connectToDB();
            pst = controller.con.prepareStatement(query);
            pst.setString(1, email);
            rs = pst.executeQuery();
            while(rs.next())
            {
		res = rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            controller.disconnect();
            return res;
        }
    }
    
    public String checkPass(String email){
        String res = "notFound";
        PreparedStatement pst;
        ResultSet rs;
        String  query = "SELECT password FROM users WHERE email=?";
        try {
            controller.connectToDB();
            pst = controller.con.prepareStatement(query);
            pst.setString(1, email);
            rs = pst.executeQuery();
            while(rs.next())
            {
		res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            controller.disconnect();
            return res;
        }
    }
    
}
