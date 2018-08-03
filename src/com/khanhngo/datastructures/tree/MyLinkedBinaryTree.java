package com.khanhngo.datastructures.tree;

import com.khanhngo.datastructures.general.Position;

public class MyLinkedBinaryTree {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> myBinaryTree = new LinkedBinaryTree<>();
        myBinaryTree.addRoot(10);

        Position<Integer> root = myBinaryTree.root();
        Position<Integer> num1 = myBinaryTree.addLeft(root, 23);
        Position<Integer> num2 = myBinaryTree.addRight(root, 12);
        Position<Integer> num3 = myBinaryTree.addLeft(num1, 34);
        Position<Integer> num4 = myBinaryTree.addRight(num1, 78);
        Position<Integer> num5 = myBinaryTree.addLeft(num2, 82);
        Position<Integer> num6 = myBinaryTree.addRight(num2, 20);

        System.out.println(myBinaryTree.size());
        Integer oldValue = myBinaryTree.set(num6, 1);
        System.out.println(oldValue);
        System.out.println(num6.getElement());
        System.out.println("----------------------------------------------------------");

        System.out.println(myBinaryTree.parent(num3).getElement());
        System.out.println(myBinaryTree.numChildren(num2));
        System.out.println(myBinaryTree.numChildren(root));

        myBinaryTree.remove(num1);
    }
}