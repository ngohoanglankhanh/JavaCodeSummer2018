package com.khanhngo.datastructures;

public class Stack {
    private int maxSize;
    private int[] stack;
    private int top;
    public final int OUT_OF_BOUND_VALUE = -1;

    public Stack (int size){
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    public void push (int pushValue){
        if (!isFull()){
            stack[++top] = pushValue;
        }else{
            System.out.println("overload");
        }
    }

    public int pop(){
        if (!isEmpty()){
            int valueToRemove = stack[top];
            top--;
            return valueToRemove;
        }
        return OUT_OF_BOUND_VALUE;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public int peek(){
        return stack[top];
    }
}