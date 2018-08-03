package com.khanhngo.datastructures;

public class BoxedItem implements Insurable{
    private String description;
    private int weight;
    private int price;
    private int boxHeight = 0;
    private int boxWidth = 0;
    private int boxDepth = 0;
    private boolean hazardous;

    public BoxedItem (String description, int weight, int price, boolean hazardous) {
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.hazardous = hazardous;
    }

    public void setBox(int boxHeight, int boxWidth, int boxDepth){
        this.boxHeight = boxHeight;
        this.boxWidth = boxWidth;
        this.boxDepth = boxDepth;
    }

    public int insuredValue(){
        return price*2;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public int lowestPrice() {
        return price;
    }

    @Override
    public int weight() {
        return weight;
    }

    @Override
    public boolean isHazardous() {
        return hazardous;
    }
}
