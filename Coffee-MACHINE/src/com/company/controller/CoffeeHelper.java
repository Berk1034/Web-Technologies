package com.company.controller;

import com.company.beans.*;

import java.util.HashMap;
import java.util.Map;

public class CoffeeHelper {
    private static final CoffeeHelper instance = new CoffeeHelper();
    private Map<CoffeeName, Espresso> coffee = new HashMap<>();

    public CoffeeHelper(){
        coffee.put(CoffeeName.AMERICANO, new Americano());
        coffee.put(CoffeeName.CAPPUCCINO, new Cappuccino());
        coffee.put(CoffeeName.ESPRESSO, new Espresso());
        coffee.put(CoffeeName.FLATWHITE, new FlatWhite());
        coffee.put(CoffeeName.LATTE, new Latte());
        coffee.put(CoffeeName.ROMANO, new Romano());
    }

    public static CoffeeHelper getInstance(){
        return instance;
    }

    public Espresso getCoffee(String coffeeName){
        Espresso coffeeType;
        try{
            CoffeeName name = CoffeeName.valueOf(coffeeName.toUpperCase());
            if(name != null){
                coffeeType = coffee.get(name);
            }
            else{
                coffeeType = null;
            }
        }
        catch (IllegalArgumentException | NullPointerException exception){
            coffeeType = null;
        }

        return coffeeType;
    }
}
