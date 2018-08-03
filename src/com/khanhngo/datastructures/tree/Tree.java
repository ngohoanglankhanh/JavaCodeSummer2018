package com.khanhngo.datastructures.tree;

import com.khanhngo.datastructures.general.Position;

import java.util.Iterator;

public interface Tree<E>{
    Position<E> root();

    Iterable<Position<E>> children (Position<E> p) throws IllegalArgumentException;

    Position<E> parent (Position<E> p) throws IllegalArgumentException;

    int numChildren (Position<E> p) throws IllegalArgumentException;

    boolean isInternal (Position<E> p) throws IllegalArgumentException;

    boolean isExternal (Position<E> p) throws IllegalArgumentException;

    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    int size();

    boolean isEmpty();

    /**Returns an iterator for all elements in the tree (so that the tree itself is Iterable) */
    Iterator<E> iterator();

    /**Returns an iterable collection of all positions of the tree */
    Iterable<Position<E>> positions();
}
