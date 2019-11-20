package com.company.beans;

import java.io.Serializable;
import java.util.Objects;

public class Romano extends Espresso implements Serializable {
    private int LemonJuiceVolume;

    public Romano(){
        LemonJuiceVolume = 5;
        super.setCoffeeAmount(16);
    }

    public int getLemonJuiceVolume() {
        return LemonJuiceVolume;
    }

    public void setLemonJuiceVolume(int lemonJuiceVolume) {
        LemonJuiceVolume = lemonJuiceVolume;
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

        Romano that = (Romano)o;

        if(LemonJuiceVolume != that.LemonJuiceVolume){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), LemonJuiceVolume);
    }

    @Override
    public String toString(){
        return "\nRomano{" + "sugar='" + isSugar() + '\'' + ", watertemperature='" + getWaterTemperature() + '\'' + ", coffeeamount='" + getCoffeeAmount() + '\'' + ", watervolume='" + getWaterVolume() + '\'' + ", lemonjuicevolume='" + LemonJuiceVolume + '\'' + "}";
    }
}
