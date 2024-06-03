/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.User;
import quanlysinhvien.data.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static quanlysinhvien.data.ConnectDB.stmt;
/**
 *
 * @author myPC
 */
public class userController {
    
    private User user1;

    public User getUser1() {
        return user1;
    }
//Ham update mk
    public void updatePass(String name,String pass){
        try {
            String sq0 = "UPDATE `user` SET `passWord`='" + pass + "' WHERE `userName`='" + name + "'";
            stmt.executeUpdate(sq0);
        } catch (SQLException ex) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Ham kiem tra su ton tai cua nguoi dung   
    public boolean checkUser(String userName){
        boolean i = true;
        try {
            String sq0 = "SELECT * FROM `user` WHERE `userName`= '" + userName + "'";
            ResultSet rs = stmt.executeQuery(sq0);
            i = rs.next();
        } catch (SQLException ex) {
        }
        return i;
    }
//Ham lay thong tin nguoi dung
    public void getUserInfor(String userName){
        int id;
        String name,pass;
        String sq0 = "SELECT * FROM `user` WHERE `userName`= '" + userName + "'";
        try {
            ResultSet rs = stmt.executeQuery(sq0);
            while(rs.next()){
                id = Integer.parseInt(rs.getString("userID"));
                name =  rs.getString("userName");
                pass =  rs.getString("passWord");
                user1 = new User(id,name,pass);
            }
        } catch (SQLException ex) {
        }
    }
    //Ham lay thong tin nguoi dung
    public User getUser(String userName){
        User user = new User();
        int id;
        String name,pass;
        String sq0 = "SELECT * FROM `user` WHERE `userName`= '" + userName + "'";
        try {
            ResultSet rs = stmt.executeQuery(sq0);
            while(rs.next()){
                id = Integer.parseInt(rs.getString("userID"));
                name =  rs.getString("userName");
                pass =  rs.getString("passWord");
                user = new User(id,name,pass);
            }
        } catch (SQLException ex) {
        }
        return user;
    }
//Update thong tin nguoi dung
    public void updateUser(User user){
        String sq = "UPDATE `user` SET `userName`='"+user.getUserName() +"',`passWord`='"+user.getPassWord()+"' WHERE `userID`= "+user.getUserID()+";";
        try {
            stmt.executeUpdate(sq);
        } catch (Exception e) {
        }
    }
//Ham them nguoi dung moi    
    public void insertUser(String name, String pass){
        try {
            String sq1 = "INSERT INTO `user`(`userName`, `passWord`) VALUES ('" + name +"','" + pass + "')";
            stmt.executeUpdate(sq1);
        } catch (SQLException ex) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Khoi tao    
    public userController() {
        new ConnectDB();
    }
//    public static void main(String[] args) {
//        userController u = new userController();
//    }
}