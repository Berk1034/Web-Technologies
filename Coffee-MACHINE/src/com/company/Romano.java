package com.company;

public class Romano extends Espresso {
    private int LemonJuiceVolume;

    public Romano(){
        LemonJuiceVolume = 5;
    }

    public int getLemonJuiceVolume() {
        return LemonJuiceVolume;
    }

    public void setLemonJuiceVolume(int lemonJuiceVolume) {
        LemonJuiceVolume = lemonJuiceVolume;
    }

    @Override
    public String toString(){
        return "\nRomano{" + "sugar='" + isSugar() + '\'' + ", watertemperature='" + getWaterTemperature() + '\'' + ", coffeeamount='" + getCoffeeAmount() + '\'' + ", watervolume='" + getWaterVolume() + '\'' + ", lemonjuicevolume='" + LemonJuiceVolume + '\'' + "}";
    }
}
