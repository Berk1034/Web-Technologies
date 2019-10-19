package com.company;

public class Espresso {
    private boolean Sugar;
    private int WaterTemperature;
    private int CoffeeAmount;
    private int WaterVolume;

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


}
