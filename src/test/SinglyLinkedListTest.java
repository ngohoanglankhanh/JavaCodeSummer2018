package test;

import com.khanhngo.datastructures.SinglyLinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {
    private SinglyLinkedList mSinglyLinkedList;

    @Before
    public void setup() {
        mSinglyLinkedList = new SinglyLinkedList();
    }

    @Test
    public void testContains() {
        mSinglyLinkedList.pushFront(2);
        mSinglyLinkedList.pushBack(3);
        mSinglyLinkedList.pushBack(4);
        assertTrue(mSinglyLinkedList.contains(4));
    }

    @Test
    public void testPop() {
        mSinglyLinkedList.pushFront(1);
        mSinglyLinkedList.pushFront(2);
        assertEquals(1, mSinglyLinkedList.popBack());
    }

    @After
    public void tearDown() {
        mSinglyLinkedList = null;
    }
}