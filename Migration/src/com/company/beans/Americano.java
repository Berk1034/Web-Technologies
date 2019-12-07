package com.company.beans;

import java.io.Serializable;
import java.util.Objects;

public class Americano extends Espresso implements Serializable {
    private int AdditionalWaterVolume;

    public Americano(){
        AdditionalWaterVolume = 30;
        super.setCoffeeAmount(15);
    }

    public int getAdditionalWaterVolume() {
        return AdditionalWaterVolume;
    }

    public void setAdditionalWaterVolume(int additionalWaterVolume) {
        AdditionalWaterVolume = additionalWaterVolume;
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

        Americano that = (Americano)o;

        if(AdditionalWaterVolume != that.AdditionalWaterVolume){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), AdditionalWaterVolume);
    }

    @Override
    public String toString(){
        return "\nAmericano{" + "sugar='" + isSugar() + '\'' + ", watertemperature='" + getWaterTemperature() + '\'' + ", coffeeamount='" + getCoffeeAmount() + '\'' + ", watervolume='" + getWaterVolume() + '\'' + ", additionalwatervolume='" + AdditionalWaterVolume + '\'' + "}";
    }
}
