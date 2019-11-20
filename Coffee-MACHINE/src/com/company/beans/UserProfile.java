package com.company.beans;

import java.util.Date;

public class UserProfile {
    private String Name;
    private String Surname;
    private int Age;
    private Date CreationDate;
//    private ArrayList<Espresso> CoffeeSettings;

    public UserProfile(){}

    public UserProfile(String name, String surname, int age, Date creationDate){
        Name = name;
        Surname = surname;
        Age = age;
        CreationDate = creationDate;
        /*
        CoffeeSettings = new ArrayList<Espresso>();
        CoffeeSettings.add(new Americano());
        CoffeeSettings.add(new Cappuccino());
        CoffeeSettings.add(new Espresso());
        CoffeeSettings.add(new FlatWhite());
        CoffeeSettings.add(new Latte());
        CoffeeSettings.add(new Romano());
        */
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }
/*
    public ArrayList<Espresso> getCoffeeSettings() {
        return CoffeeSettings;
    }

    public void setCoffeeSettings(ArrayList<Espresso> coffeeSettings) {
        CoffeeSettings = coffeeSettings;
    }

*/
}
