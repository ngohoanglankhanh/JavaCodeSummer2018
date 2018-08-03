package com.khanhngo.datastructures;

public abstract class Vehicle {
    private String material;
    private final int year;
    private int price;

    public Vehicle(){
        this(null, 0, 0);
    }

    public Vehicle(String material, int year) {
        this(material, year, 0);
    }

    public Vehicle(String material, int year, int price) {
        this.material = material;
        this.year = year;
        this.price = price;
    }
}
