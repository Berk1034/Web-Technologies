package com.company;

public class Latte extends Cappuccino{
    private int WhippedCreamVolume;

    public Latte(){
        WhippedCreamVolume = 100;
    }

    public int getWhippedCreamVolume() {
        return WhippedCreamVolume;
    }

    public void setWhippedCreamVolume(int whippedCreamVolume) {
        WhippedCreamVolume = whippedCreamVolume;
    }
}
