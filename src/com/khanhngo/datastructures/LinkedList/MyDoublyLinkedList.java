package com.khanhngo.datastructures.LinkedList;

public class MyDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> myList = new DoublyLinkedList<>();
        myList.addFirst(10);
        myList.addLast(20);
        myList.addLast(30);
        myList.addLast(40);
        myList.addLast(50);
        System.out.println(myList.isEmpty());
        System.out.println(myList.size());
        System.out.println(myList.first() + " " + myList.last());
        System.out.println(myList.contains(50));
        System.out.println(myList.getElement(4));
        System.out.println(myList.getElement(0));
    }
}
