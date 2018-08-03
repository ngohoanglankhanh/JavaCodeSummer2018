package com.khanhngo.datastructures;

import java.util.StringJoiner;

public class QueueWithArray {
    private Integer[] mArray;
    private int mArraySize;
    private int mHead;
    private int mTail;
    private final int DEFAULT_INDEX = 0;
    private final Integer DEFAULT_VALUE = null;

    public QueueWithArray(int size) {
        if (size > 0) {
            mArraySize = size + 1;
            mArray = new Integer[mArraySize];
            mHead = DEFAULT_INDEX;
            mTail = DEFAULT_INDEX;
        }
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new OverflowException("Queue overflows");
        }

        mArray[mTail] = value;

        if (mTail == mArraySize - 1) {
            mTail = DEFAULT_INDEX;
        } else {
            mTail++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new UnderflowException("Queue underflows");
        }

        int removeValue = mArray[mHead];
        mArray[mHead] = DEFAULT_VALUE;
        if (mHead == mArraySize - 1) {
            mHead = DEFAULT_INDEX;
        }
        mHead++;
        return removeValue;
    }

    public boolean isFull() {
        return (mTail == mArraySize - 1 && mHead == 0) || (mHead == mTail + 1);
    }

    public boolean isEmpty() {
        return mHead == mTail;
    }

    public int getHead() {
        return mArray[mHead];
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "", "");
        for (Integer integer : mArray) {
            if (integer != null) {
                sj.add(String.valueOf(integer));
            }
        }
        return sj.toString();
    }
}
