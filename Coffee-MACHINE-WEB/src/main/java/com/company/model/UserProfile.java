package com.company.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class UserProfile implements Serializable {
    protected String Name;
    protected String Surname;
    protected int Age;
    protected Date CreationDate;

    public UserProfile(){}

    public UserProfile(String name, String surname, int age, Date creationDate){
        Name = name;
        Surname = surname;
        Age = age;
        CreationDate = creationDate;
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

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != getClass()){
            return false;
        }
        if(this == o){
            return true;
        }

        UserProfile that = (UserProfile)o;

        if(!Name.equals(that.Name) || !Surname.equals(that.Surname) || Age != that.Age || !CreationDate.equals(that.CreationDate)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(Name, Surname, Age, CreationDate);
    }

    @Override
    public String toString(){
        return "Name: " + getName() + "\n" + "Surname: " + getSurname() + "\n" + "Age: " + getAge() + "\n" + "CreationDate: " + getCreationDate();
    }
}
