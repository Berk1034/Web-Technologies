package com.company;

import java.util.Date;

public class UserOrder {
    private Date Date;
    private Espresso CoffeeType;

    public UserOrder(Date date, Espresso coffeeType){
        Date = date;
        CoffeeType = coffeeType;
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
}
