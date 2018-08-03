package com.khanhngo.datastructures;

import com.khanhngo.datastructures.general.Position;

public interface PositionalList<E> {
    /**Returns the number of positions in the list*/
    int size();

    /**Returns true if list L does not contain any elements */
    boolean isEmpty();

    /**Returns the position of the first element of L (or null if empty)*/
    Position<E> first();

    /**Returns the position of the last element of L (or null if empty)*/
    Position<E> last();

    /**Returns the position of L immediately before position p */
    Position<E> before (Position<E> p) throws IllegalArgumentException;

    /**Returns the position of L immediately after position p */
    Position<E> after (Position<E> p) throws IllegalArgumentException;

    /**Inserts a new element e at the front of the list, returning the position of the new element */
    Position<E> addFirst (E e);

    /**Inserts a new element e at the back of the list, returning the position of the new element */
    Position<E> addLast (E e);

    /**Inserts a new element e in the list, just before position p returning the position of the new element */
    Position<E> addBefore (Position<E> p, E e) throws IllegalArgumentException;

    /**Inserts a new element e in the list, just before position p returning the position of the new element */
    Position<E> addAfter (Position<E> p, E e) throws IllegalArgumentException;

    /**Replaces the element at position p with element e, returning the element formerly at position p */
    E set (Position<E> p, E e) throws IllegalArgumentException;

    /**Removes and returns the element at position p in the list (invalidating p) */
    E remove (Position<E> p) throws IllegalArgumentException;
}