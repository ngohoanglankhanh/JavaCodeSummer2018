package com.khanhngo.datastructures;

public class New {
    private int count;

    public New(){
        this(0);
    }

    public New(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
//        New myNew = new New();
        New myNew = new New();
        System.out.println(myNew.getCount());
        double number = 5.1;
        System.out.printf("%d", number);
    }
}
