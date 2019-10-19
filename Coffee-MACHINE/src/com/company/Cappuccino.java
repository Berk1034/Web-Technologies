package com.company;

public class Cappuccino extends Espresso{
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
}
