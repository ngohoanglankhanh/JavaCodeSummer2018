package com.khanhngo.datastructures.tree;

import com.khanhngo.datastructures.general.Position;

public interface BinaryTree<E> extends Tree<E>{
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    Position<E> right (Position<E> p) throws IllegalArgumentException;

    Position<E> sibling (Position<E> p) throws IllegalArgumentException;
}
