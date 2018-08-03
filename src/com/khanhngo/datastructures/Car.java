package com.khanhngo.datastructures;

public class Car extends Vehicle{
    private int wheels;
    private int seats;

    public Car (int wheels, int seats, String material, int year){
        super(material, year);
        this.wheels = wheels;
        this.seats = seats;
    }

}
