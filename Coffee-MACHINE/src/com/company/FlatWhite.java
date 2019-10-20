package com.company;

public class FlatWhite extends Espresso{
    private int CoconutMilkVolume;

    public FlatWhite(){
        CoconutMilkVolume = 50;
    }

    public int getCoconutMilkVolume() {
        return CoconutMilkVolume;
    }

    public void setCoconutMilkVolume(int coconutMilkVolume) {
        CoconutMilkVolume = coconutMilkVolume;
    }
    @Override
    public String toString(){
        return "\nFlatWhite{" + "sugar='" + isSugar() + '\'' + ", watertemperature='" + getWaterTemperature() + '\'' + ", coffeeamount='" + getCoffeeAmount() + '\'' + ", watervolume='" + getWaterVolume() + '\'' + ", coconutmilkvolume='" + CoconutMilkVolume + '\'' + "}";
    }
}
