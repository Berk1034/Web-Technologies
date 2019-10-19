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
}
