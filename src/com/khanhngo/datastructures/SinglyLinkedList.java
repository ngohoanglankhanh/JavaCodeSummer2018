package com.khanhngo.datastructures;

import java.util.NoSuchElementException;

public class SinglyLinkedList {
    private int mListSize;
    private Node mHead;
    private Node mTail;

    public SinglyLinkedList(){
        mListSize = 0;
        mHead = null;
        mTail = null;
    }

    public void pushFront (int key) {
        //create new node here to avoid uncontrollably adding a list
        Node node = new Node(key, null);
        if (mTail == null || mHead == null) { //case: list has no elements
            mHead = node;
            mTail = mHead;
        } else {
            node.setNextNode(mHead);
            mHead = node;
        }
        mListSize++;
    }

    public void pushBack (int key) {
        //create new node here to avoid uncontrollably adding a list
        Node node = new Node(key, null);
        if (mTail == null || mHead == null) { //case: list has no elements
            mTail = node;
            mHead = mTail;
        } else {
            mTail.setNextNode(node);
            mTail = node;
        }
        mListSize++;
    }

    public int popFront(){
        if (mHead == null || mTail == null){ //check if list is empty
            throw new NoSuchElementException();
        }
        Node nodeToRemove = mHead;
        mHead = mHead.next();
        nodeToRemove.setNextNode(null);//release reference to the rest of the list
        mListSize--;
        if (mHead == null){ //case: only 1 node left in the list
            mTail = null;
        }
        return nodeToRemove.getKey();
    }

    public int popBack(){
        if (mHead == null){ //check if list is empty
            throw new NoSuchElementException();
        }
        if(mHead == mTail){ //case: only 1 node in the list
            Node nodeToRemove = mHead;
            mHead = null;
            mTail = null;
            mListSize --;
            return nodeToRemove.getKey();
        }else{
            Node temp = mHead;
            while (temp.next().next() != null){
                temp = temp.next();
            }
            Node nodetoRemove = temp.next();
            temp.setNextNode(null);
            mTail = temp;
            mListSize --;
            return nodetoRemove.getKey();
        }
    }

    public boolean isEmpty(){
        return mHead == null;
    }

    public int getHeadKey(){
        return mHead.getKey();
    }

    public int getSize(){
        return mListSize;
    }

    public boolean contains(int key) {
        Node temp = mHead;
        while (temp != null){
            if (temp.getKey() == key){
                return true;
            }else{
                temp = temp.next();
            }
        }
        return false;
    }

    public void changeValueAt (int position){

    }

    public int getValueAt(int position) {
        if (!isValidPosition(position)) {
            throw new IllegalArgumentException("Position is invalid");
        }else{
            Node temp = mHead;
            for (int i = 1; i < position; i++) {
                temp = temp.next();
            }
            return temp.getKey();
        }
    }

    private boolean isValidPosition(int position) {
        return 0 <= position && position <= mListSize;
    }

    private class Node{
        private int mKey;
        private Node mNextNode;

        public Node(int key, Node nextNode) {
            this.mKey = key;
            this.mNextNode = nextNode;
        }

        public int getKey(){
            return mKey;
        }

        public Node next(){
            return mNextNode;
        }

        public void setKey(int key) {
            this.mKey = key;
        }

        public void setNextNode(Node nextNode) {
            this.mNextNode = nextNode;
        }
    }
}