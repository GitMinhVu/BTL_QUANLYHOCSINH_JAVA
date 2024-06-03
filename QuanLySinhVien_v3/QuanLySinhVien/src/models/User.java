/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author myPC
 */
public class User {
    
//Khai bao cac thuoc tinh cuar User
    private int userID;
    private String userName;
    private String passWord;
//Ham khoi tao
    public User() {
    }
//Ham khoi tao co tham so 
    public User(int userID, String userName, String passWord) {
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;
    }
//Cac phuong thu get va set
    public int getUserID() {
        return userID;
    }

    public void setUseID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    
}
