package com.khanhngo.datastructures.tree;

import com.khanhngo.datastructures.general.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E>{
    public Position<E> sibling (Position<E> p){
        Position<E> parent = parent(p);
        if (parent == null){
            return null;
        }
        if(p == left(parent)){
            return right(parent);
        }else{
            return left(parent);
        }
    }

    public int numChildren (Position<E> p){
        int count = 0;
        if (left(p) != null){
            count ++;
        }
        if (right(p) != null){
            count++;
        }
        return count;
    }

    public Iterable<Position<E>> children (Position<E> p){
        List<Position<E>> childrenList = new ArrayList<>(2);
        if (left(p)!= null){
            childrenList.add(left(p));
        }
        if (right(p) != null){
            childrenList.add(right(p));
        }
        return childrenList;
    }
}
