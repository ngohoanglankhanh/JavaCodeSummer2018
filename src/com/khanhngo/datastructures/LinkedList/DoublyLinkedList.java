package com.khanhngo.datastructures.LinkedList;

public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public DoublyLinkedList(){
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    public void addFirst(E e){
        addBetween(e, head, head.getNext());
    }

    public void addLast(E e){
        addBetween(e, tail.getPrev(), tail);
    }

    private void addBetween (E e, Node<E> predecessor, Node<E> successor){
        Node<E> node = new Node<>(e, predecessor, successor);
        predecessor.setNext(node);
        successor.setPrev(node);
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }
        return remove(head.getNext());
    }

    public E removeLast(){
        if (isEmpty()){
            return null;
        }
        return remove(tail.getPrev());
    }

    private E remove (Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        return temp;
    }

    public E first(){
        if (isEmpty()){
            return null;
        }
        return head.getNext().getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getPrev().getElement();
    }

    public E getElement (int position) throws IllegalArgumentException{
        if (!isValidPosition(position)){
            throw new IllegalArgumentException("position is invalid");
        }
        Node<E> temp = head.getNext();
        for (int i = 0; i < position; i++) {
            temp = temp.getNext();
        }
        return temp.getElement();
    }

    public boolean contains (E e){
        if (isEmpty()){
            return false;
        }
        Node<E> temp = head.getNext();
        int marker = 0;
        while (marker < size()){
            if (temp.getElement() == e){
                return true;
            }
            temp = temp.getNext();
            marker++;
        }
        return false;
    }

    private boolean isValidPosition (int position){
        return 0 <= position && position < size;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (head.getNext() == tail) && (tail.getPrev() == head);
    }

    private class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}