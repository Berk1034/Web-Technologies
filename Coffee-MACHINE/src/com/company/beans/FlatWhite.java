package com.company.beans;

import java.io.Serializable;
import java.util.Objects;

public class FlatWhite extends Espresso implements Serializable {
    private int CoconutMilkVolume;

    public FlatWhite(){
        CoconutMilkVolume = 50;
        super.setCoffeeAmount(13);
    }

    public int getCoconutMilkVolume() {
        return CoconutMilkVolume;
    }

    public void setCoconutMilkVolume(int coconutMilkVolume) {
        CoconutMilkVolume = coconutMilkVolume;
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

        FlatWhite that = (FlatWhite)o;

        if(CoconutMilkVolume != that.CoconutMilkVolume){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), CoconutMilkVolume);
    }

    @Override
    public String toString(){
        return "\nFlatWhite{" + "sugar='" + isSugar() + '\'' + ", watertemperature='" + getWaterTemperature() + '\'' + ", coffeeamount='" + getCoffeeAmount() + '\'' + ", watervolume='" + getWaterVolume() + '\'' + ", coconutmilkvolume='" + CoconutMilkVolume + '\'' + "}";
    }
}
