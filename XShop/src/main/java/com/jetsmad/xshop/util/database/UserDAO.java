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
import java.util.ArrayList;
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

    public void addUser(User user) {
        PreparedStatement pst;
        String query = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            controller.connectToDB();
            pst = controller.con.prepareStatement(query);
            pst.setString(1, user.getId());
            pst.setString(2, user.getName());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getDob());
            pst.setString(5, user.getPassword());
            pst.setString(6, user.getAddress());
            pst.setString(7, user.getJob());
            pst.executeUpdate();

            if (user.getInterests() != null) {
                for (String interest : user.getInterests()) {
                    String queryString = "INSERT INTO interests VALUES (?, ?)";
                    PreparedStatement pstmnt = controller.con.prepareStatement(queryString);
                    pstmnt.setString(1, user.getId());
                    pstmnt.setString(2, interest);
                    pstmnt.executeUpdate();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            controller.disconnect();
        }
    }

    public boolean checkEmail(String email) {
        boolean res = true;
        PreparedStatement pst;
        ResultSet rs;
        String query = "SELECT * FROM users WHERE email=?";
        try {
            controller.connectToDB();
            pst = controller.con.prepareStatement(query);
            pst.setString(1, email);
            rs = pst.executeQuery();
            if (rs.next()) {
                res = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            controller.disconnect();
            return res;
        }
    }

    public String checkPass(String email) {
        String res = "notFound";
        PreparedStatement pst;
        ResultSet rs;
        String query = "SELECT password FROM users WHERE email=?";
        try {
            controller.connectToDB();
            pst = controller.con.prepareStatement(query);
            pst.setString(1, email);
            rs = pst.executeQuery();
            while (rs.next()) {
                res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            controller.disconnect();
            return res;
        }
    }

    public User getUser(String email) {
        User user = null;
        PreparedStatement pst;
        ResultSet rs;
        String query = "SELECT id,name,email,dob,password,address,job FROM users WHERE email=?";
        try {
            controller.connectToDB();
            pst = controller.con.prepareStatement(query);
            pst.setString(1, email);
            rs = pst.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getString(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setDob(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setJob(rs.getString(7));
                PreparedStatement pstInt;
                ResultSet rsInt;
                String queryInt = "SELECT interest FROM interests WHERE users_id=?";
                pstInt = controller.con.prepareStatement(queryInt);
                pstInt.setString(1, rs.getString(1));
                rsInt = pstInt.executeQuery();
                ArrayList<String> arrayList = new ArrayList<>();
                while (rsInt.next()) {
                    arrayList.add(rsInt.getString(1));
                }
                System.out.println(user);
                user.setInterests((String[]) arrayList.toArray());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            controller.disconnect();
            return user;
        }
    }

    public User getUserById(String id) {
        User user = null;
        PreparedStatement pst;
        ResultSet rs;
        String query = "SELECT id,name,email,dob,password,address,job FROM users WHERE id=?";
        try {
            controller.connectToDB();
            pst = controller.con.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getString(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setDob(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setJob(rs.getString(7));
                PreparedStatement pstInt;
                ResultSet rsInt;
                String queryInt = "SELECT interest FROM interests WHERE users_id=?";
                pstInt = controller.con.prepareStatement(queryInt);
                pstInt.setString(1, rs.getString(1));
                rsInt = pstInt.executeQuery();
                ArrayList<String> arrayList = new ArrayList<>();
                while (rsInt.next()) {
                    arrayList.add(rsInt.getString(1));
                }
                user.setInterests((String[]) arrayList.toArray());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            controller.disconnect();
            System.out.println(user);
            return user;
        }
    }

    public void ubdateUser(User user) {
        PreparedStatement pst;
        String query = "update users set name=?,email=?,dob=?,password=?,address=?,job=? where id=?";
        try {
            controller.connectToDB();
            pst = controller.con.prepareStatement(query);
            pst.setString(7, user.getId());
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getDob());
            pst.setString(4, user.getPassword());
            pst.setString(5, user.getAddress());
            pst.setString(6, user.getJob());
            pst.executeUpdate();

            if (user.getInterests() != null) {
                String queryDelete = "Delete from interests where users_id=?";
                PreparedStatement pstmntDelete = controller.con.prepareStatement(queryDelete);
                pstmntDelete.setString(1, user.getId());
                pstmntDelete.executeUpdate();
                for (String interest : user.getInterests()) {
                    String queryString = "INSERT INTO interests VALUES (?, ?)";
                    PreparedStatement pstmnt = controller.con.prepareStatement(queryString);
                    pstmnt.setString(1, user.getId());
                    pstmnt.setString(2, interest);
                    pstmnt.executeUpdate();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            controller.disconnect();
        }
    }

    public ArrayList<User> getAllUsers() {
        controller.connectToDB();

        if (controller.con != null) {
            ArrayList<User> users = new ArrayList<>();
            try {
                String query = "select * from users";
                PreparedStatement pst;
                ResultSet rs;

                pst = controller.con.prepareStatement(query);
                rs = pst.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getString(1));
                    user.setName(rs.getString(2));
                    user.setEmail(rs.getString(3));
                    user.setDob(rs.getString(4));
                    user.setPassword(rs.getString(5));
                    user.setAddress(rs.getString(6));
                    user.setJob(rs.getString(7));                   
                    users.add(user);                    
                }
                rs.close();
                pst.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            } finally {
                if (users.isEmpty()) {
                    controller.disconnect();
                    System.out.println("ops null data");
                    return null;
                } else {
                    controller.disconnect();
                    return users;
                }
            }

        }
        return null;
    }
    
    public String getCountOfUsers(){
        controller.connectToDB();

        if (controller.con != null) {
            try {
                String countOfUsers = null;
                String query = "select COUNT(*) from users";
                PreparedStatement pst;
                ResultSet rs;

                pst = controller.con.prepareStatement(query);
                rs = pst.executeQuery();
                if (rs.next()) {
                       countOfUsers =  rs.getString(1);
                }
                rs.close();
                pst.close();
                return countOfUsers;

            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            } finally {
                controller.disconnect();
            }
        }
        return null;
    }
}
