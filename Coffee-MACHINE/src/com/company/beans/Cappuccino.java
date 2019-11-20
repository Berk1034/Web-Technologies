package com.company.beans;

public class Cappuccino extends Espresso {
    private int MilkTemperature;
    private int MilkVolume;

    public Cappuccino(){
        MilkVolume = 65;
        MilkTemperature = 65;
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
    public String toString(){
        return "\nCappuccino{" + "sugar='" + isSugar() + '\'' + ", watertemperature='" + getWaterTemperature() + '\'' + ", coffeeamount='" + getCoffeeAmount() + '\'' + ", watervolume='" + getWaterVolume() + '\'' + ", milktemperature='" + MilkTemperature + '\'' + ", milkvolume='" + MilkVolume + '\'' + "}";
    }
}
