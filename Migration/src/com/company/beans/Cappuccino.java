package com.company.beans;

import java.io.Serializable;
import java.util.Objects;

public class Cappuccino extends Espresso implements Serializable {
    private int MilkTemperature;
    private int MilkVolume;

    public Cappuccino(){
        MilkVolume = 65;
        MilkTemperature = 65;
        super.setCoffeeAmount(10);
    }

    public int getMilkVolume() {
        return MilkVolume;
    }

    public void setMilkVolume(int milkVolume) {
        MilkVolume = milkVolume;
    }

    public int getMilkTemperature() {
        return MilkTemperature;
    }

    public void setMilkTemperature(int milkTemperature) {
        MilkTemperature = milkTemperature;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != getClass()){
            return false;
        }
        if(!super.equals(o)){
            return false;
        }
        if(this == o){
            return true;
        }

        Cappuccino that = (Cappuccino)o;

        if(MilkTemperature != that.MilkTemperature || MilkVolume != that.MilkVolume){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), MilkTemperature, MilkVolume);
    }

    @Override
    public String toString(){
        return "\nCappuccino{" + "sugar='" + isSugar() + '\'' + ", watertemperature='" + getWaterTemperature() + '\'' + ", coffeeamount='" + getCoffeeAmount() + '\'' + ", watervolume='" + getWaterVolume() + '\'' + ", milktemperature='" + MilkTemperature + '\'' + ", milkvolume='" + MilkVolume + '\'' + "}";
    }
}
