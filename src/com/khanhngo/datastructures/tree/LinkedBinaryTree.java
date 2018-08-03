package com.khanhngo.datastructures.tree;

import com.khanhngo.datastructures.general.Position;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    //----------------------------- Nested Node class ------------------------------------
    private class Node<E> implements Position<E>{
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
            this.element = element;
            this.parent = parent;
            this.left = leftChild;
            this.right = rightChild;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<E> leftChild) {
            this.left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            this.right = rightChild;
        }
    }
    //------------------------End of nested Node class----------------------------

    private Node<E> root = null;
    private int size = 0;

    public Position<E> addRoot(E e) throws IllegalStateException{
        if (!isEmpty()){
            throw new IllegalStateException("Tree is not empty");
        }
        root = new Node<>(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft (Position<E> p, E e) throws IllegalStateException{
        Node<E> parent = validate(p);
        if (parent.getLeft() != null){
            throw new IllegalStateException("P already has a left child");
        }
        Node<E> leftChild = new Node<>(e, parent, null, null);
        parent.setLeft(leftChild);
        size++;
        return leftChild;
    }

    public Position<E> addRight (Position<E> p, E e) throws IllegalStateException{
        Node<E> parent = validate(p);
        if (parent.getRight() != null){
            throw new IllegalStateException("p already has a right child");
        }
        Node<E> rightChild = new Node<>(e, parent, null, null);
        parent.setRight(rightChild);
        size++;
        return rightChild;
    }

    public E set (Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        E pastElement = node.getElement();
        node.setElement(e);
        return pastElement;
    }

    /** Attaches trees T1 and T2 as left and right subtrees of external p */
    public void attach (Position<E> p, LinkedBinaryTree<E> T1, LinkedBinaryTree<E> T2) throws IllegalArgumentException{
        Node<E> node = validate(p);
        if (isInternal(p)){
            throw new IllegalArgumentException("p must be a leaf");
        }
        size = size + T1.size() + T2.size();
        if (!T1.isEmpty()){
            T1.root.setParent(node);
            node.setLeft(T1.root);
        }

        if (!T2.isEmpty()){
            T2.root.setParent(node);
            node.setLeft(T2.root);
        }
    }

    /** Removes the node at position p and replaces it with its child, if any */
    public E remove (Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        if (numChildren(p) == 2){
            throw new IllegalArgumentException("p has 2 children");
        }
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null){
            child.setParent(node.getParent());
        }
        if (node == root){ //check if node to be removed is a root
            root = child;
        }else{
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()){
                parent.setLeft(child);
            }else{
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;
    }

    private Node<E> validate (Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node)){
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>)p; //casting from Position<E> to Node<E> type
        if (node.getParent() == node){ // our convention for a defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getRight();
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }
}