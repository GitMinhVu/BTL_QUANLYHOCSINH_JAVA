/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author myPC
 */
public class Student {
    private int stID = 0;
    private String stName = "";
    private String stBirth = "";
    private String stGender = "";
    private int stPhone = 0;
    private String stClass = "";
    private float stPoint = 0;
    private int stPonit_R = 0;

    public Student() {
    }

    public Student(int stID, String stName, String stBirth, String stGender, int stPhone, String stClass, float stPoint, int stPonit_R) {
        this.stID = stID;
        this.stName = stName;
        this.stBirth = stBirth;
        this.stGender = stGender;
        this.stPhone = stPhone;
        this.stClass = stClass;
        this.stPoint = stPoint;
        this.stPonit_R = stPonit_R;
    }

    public int getStID() {
        return stID;
    }

    public void setStID(int stID) {
        this.stID = stID;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String  getStBirth() {
        return stBirth;
    }

    public void setStBirth(String stBirth) {
        this.stBirth = stBirth;
    }

    public String getStGender() {
        return stGender;
    }

    public void setStGender(String stGender) {
        this.stGender = stGender;
    }

    public int getStPhone() {
        return stPhone;
    }

    public void setStPhone(int stPhone) {
        this.stPhone = stPhone;
    }

    public String getStClass() {
        return stClass;
    }

    public void setStClass(String stClass) {
        this.stClass = stClass;
    }

    public float getStPoint() {
        return stPoint;
    }

    public void setStPoint(float stPoint) {
        this.stPoint = stPoint;
    }

    public int getStPonit_R() {
        return stPonit_R;
    }

    public void setStPonit_R(int stPonit_R) {
        this.stPonit_R = stPonit_R;
    }
    
}
