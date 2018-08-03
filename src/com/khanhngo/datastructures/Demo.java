package com.khanhngo.datastructures;

public class Demo {
    public static void main(String[] args) {
        SinglyLinkedList myLinkedList = new SinglyLinkedList();
        myLinkedList.pushFront(20);
        myLinkedList.pushBack(40);
        myLinkedList.pushBack(60);
        myLinkedList.pushBack(80);
        myLinkedList.pushFront(100);

        System.out.println(myLinkedList.getHeadKey());
    }
}
