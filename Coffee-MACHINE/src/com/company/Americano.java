package com.company;

public class Americano extends Espresso{
    private int AdditionalWaterVolume;

    public Americano(){
        AdditionalWaterVolume = 30;
    }

    public int getAdditionalWaterVolume() {
        return AdditionalWaterVolume;
    }

    public void setAdditionalWaterVolume(int additionalWaterVolume) {
        AdditionalWaterVolume = additionalWaterVolume;
    }

    @Override
    public String toString(){
        return "\nAmericano{" + "sugar='" + isSugar() + '\'' + ", watertemperature='" + getWaterTemperature() + '\'' + ", coffeeamount='" + getCoffeeAmount() + '\'' + ", watervolume='" + getWaterVolume() + '\'' + ", additionalwatervolume='" + AdditionalWaterVolume + '\'' + "}";
    }
}
