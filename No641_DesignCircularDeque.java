/**
 * Project Name: leetcode
 * File Name: No641_DesignCircularDeque
 * Created by Chiangsir.
 * Date: AD 2021/03/07
 */
public class No641_DesignCircularDeque {
    /**
     * Design your implementation of the circular double-ended queue (deque).
     *
     * Your implementation should support following operations:
     *
     * MyCircularDeque(k): Constructor, set the size of the deque to be k.
     * insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
     * insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
     * deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
     * deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
     * getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
     * getRear(): Gets the last item from Deque. If the deque is empty, return -1.
     * isEmpty(): Checks whether Deque is empty or not. 
     * isFull(): Checks whether Deque is full or not.
     *  
     *
     * Example:
     *
     * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
     * circularDeque.insertLast(1);			// return true
     * circularDeque.insertLast(2);			// return true
     * circularDeque.insertFront(3);			// return true
     * circularDeque.insertFront(4);			// return false, the queue is full
     * circularDeque.getRear();  			// return 2
     * circularDeque.isFull();				// return true
     * circularDeque.deleteLast();			// return true
     * circularDeque.insertFront(4);			// return true
     * circularDeque.getFront();			// return 4
     */
    private class QueueNode {
        int val;
        QueueNode pre;
        QueueNode next;
        QueueNode(int x) {
            this.val = x;
        }
    }
    private QueueNode dqueue;
    private QueueNode head;
    private QueueNode tail;
    private int capacity;
    private int count;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public No641_DesignCircularDeque(int k) {
        dqueue = null;
        head = null;
        tail = null;
        capacity = k;
        count = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    // 利用双向链表实现
    public boolean insertFront(int value) {
        if(count==capacity) return false;
        QueueNode node = new QueueNode(value);

        if(head == null && tail == null) {
            dqueue = node;
            head = tail = node;
        } else {
            node.next = head;
            tail.next = node;
            node.pre = tail;
            head.pre = node;
        }
        // head指向新加入的节点
        head = node;
        count++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(count==capacity) return false;
        QueueNode node = new QueueNode(value);
        if(head == null && tail == null) {
            dqueue = node;
            head = tail = node;
        } else {
            // 修改tail节点的后继指针
            tail.next = node;
            node.next = head;
            // 修改head节点的前向指针
            node.pre = tail;
            head.pre = node;
        }
        // head指向新加入的节点
        tail = node;
        count++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(count==0) return false;
        if(head == tail) {
            dqueue = null;
            head = null;
            tail = null;
        } else {
            tail.next = head.next;
            head.next.pre = tail;
            head = head.next;
        }
        count--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(count==0) return false;
        if(head == tail) {
            dqueue = null;
            head = null;
            tail = null;
        } else {
            head.pre = tail.pre;
            tail.pre.next = head;
            tail = tail.pre;
        }
        count--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head==null ? -1: head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail==null? -1: tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count==capacity;
    }
}
