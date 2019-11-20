package com.company.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class UserOrder implements Serializable {
    private Date Date;
    private Espresso CoffeeType;
    private UserProfile UserProfile;
    private int ID;

    public UserOrder(){}

    public UserOrder(int id, Date date, Espresso coffeeType, UserProfile userProfile){
        ID = id;
        Date = date;
        CoffeeType = coffeeType;
        UserProfile = userProfile;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public Espresso getCoffeeType() {
        return CoffeeType;
    }

    public void setCoffeeType(Espresso coffeeType) {
        CoffeeType = coffeeType;
    }

    public com.company.beans.UserProfile getUserProfile() {
        return UserProfile;
    }

    public void setUserProfile(com.company.beans.UserProfile userProfile) {
        UserProfile = userProfile;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != getClass()){
            return false;
        }
        if(this == o){
            return true;
        }

        UserOrder that = (UserOrder)o;

        if(ID != that.ID || !Date.equals(that.Date) || !CoffeeType.equals(that.CoffeeType) || !UserProfile.equals(that.UserProfile)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(ID, Date, CoffeeType, UserProfile);
    }

    @Override
    public String toString(){
        return "Date: " + getDate() + "\n" + "CoffeeType: " + getCoffeeType();
    }
}
