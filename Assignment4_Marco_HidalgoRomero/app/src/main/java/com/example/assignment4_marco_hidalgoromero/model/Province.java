package com.example.assignment4_marco_hidalgoromero.model;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-07-09
 */
public class Province {
    String name;
    String capital;

    int armId;

    public Province(String name, String capital, int armId) {
        this.name = name;
        this.capital = capital;
        this.armId = armId;
    }

    public String getName() {
        return name;
    }


    public String getCapital() {
        return capital;
    }


    public int getArmId() {
        return armId;
    }

}
