package com.company.beans;

import java.io.Serializable;
import java.util.Objects;

public class Espresso implements Serializable {
    private boolean Sugar;
    private int WaterTemperature;
    private int WaterVolume;
    private int CoffeeAmount;

    public Espresso(){
        Sugar = false;
        WaterTemperature = 90;
        CoffeeAmount = 10;
        WaterVolume = 30;
    }

    public int getWaterTemperature() {
        return WaterTemperature;
    }

    public void setWaterTemperature(int waterTemperature) {
        WaterTemperature = waterTemperature;
    }

    public int getCoffeeAmount() {
        return CoffeeAmount;
    }

    public void setCoffeeAmount(int coffeeAmount) {
        CoffeeAmount = coffeeAmount;
    }

    public int getWaterVolume() {
        return WaterVolume;
    }

    public void setWaterVolume(int waterVolume) {
        WaterVolume = waterVolume;
    }

    public boolean isSugar() {
        return Sugar;
    }

    public void setSugar(boolean sugar) {
        Sugar = sugar;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != getClass()){
            return false;
        }
        if(this == o){
            return true;
        }

        Espresso that = (Espresso)o;

        if(Sugar != that.Sugar || WaterTemperature != that.WaterTemperature || CoffeeAmount != that.CoffeeAmount || WaterVolume != that.WaterVolume){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(Sugar, WaterTemperature, CoffeeAmount, WaterVolume);
    }

    @Override
    public String toString(){
        return "\nEspresso{" + "sugar='" + Sugar + '\'' + ", watertemperature='" + WaterTemperature + '\'' + ", coffeeamount='" + CoffeeAmount + '\'' + ", watervolume='" + WaterVolume + '\'' + "}";
    }
}
