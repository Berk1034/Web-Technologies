package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class UserProfile implements IFileWriter {
    private String Name;
    private String Surname;
    private int Age;
    private Date CreationDate;
    private ArrayList<Espresso> CoffeeSettings;

    public UserProfile(){}

    public UserProfile(String name, String surname, int age, Date creationDate){
        Name = name;
        Surname = surname;
        Age = age;
        CreationDate = creationDate;
        CoffeeSettings = new ArrayList<Espresso>();
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

    public ArrayList<Espresso> getCoffeeSettings() {
        return CoffeeSettings;
    }

    public void setCoffeeSettings(ArrayList<Espresso> coffeeSettings) {
        CoffeeSettings = coffeeSettings;
    }

    @Override
    public void WriteInfo(String filename, String info) {
        try(FileWriter writer = new FileWriter(filename,false))
        {
            writer.write(info);
            writer.write("\n");
            writer.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
