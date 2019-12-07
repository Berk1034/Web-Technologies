package com.company.beans;

import java.io.Serializable;
import java.util.Objects;

public class Latte extends Cappuccino implements Serializable {
    private int WhippedCreamVolume;

    public Latte(){
        WhippedCreamVolume = 100;
        super.setCoffeeAmount(13);
    }

    public int getWhippedCreamVolume() {
        return WhippedCreamVolume;
    }

    public void setWhippedCreamVolume(int whippedCreamVolume) {
        WhippedCreamVolume = whippedCreamVolume;
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

        Latte that = (Latte)o;

        if(WhippedCreamVolume != that.WhippedCreamVolume){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), WhippedCreamVolume);
    }

    @Override
    public String toString(){
        return "\nLatte{" + "sugar='" + isSugar() + '\'' + ", watertemperature='" + getWaterTemperature() + '\'' + ", coffeeamount='" + getCoffeeAmount() + '\'' + ", watervolume='" + getWaterVolume() + '\'' + ", whippedcreamvolume='" + WhippedCreamVolume + '\'' + "}";
    }
}
