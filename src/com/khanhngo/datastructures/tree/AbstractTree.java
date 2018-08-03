package com.khanhngo.datastructures.tree;

import com.khanhngo.datastructures.general.Position;

public abstract class AbstractTree<E> implements Tree<E>{
    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return (numChildren(p) > 0);
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return (0 == numChildren(p));
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return (p == root());
    }

    @Override
    public boolean isEmpty() {
        return (0 == size());
    }
}
