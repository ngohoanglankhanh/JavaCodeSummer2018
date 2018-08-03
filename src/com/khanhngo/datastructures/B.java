package com.khanhngo.datastructures;

public class B implements I{
    @Override
    public void fun(int i){
        System.out.println("B " + String.valueOf(i));
    }

    public static void main(String[] args) {
        B object = new B();
        object.fun(2);
    }
}
