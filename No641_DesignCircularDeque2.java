/**
 * Project Name: leetcode
 * File Name: No641_DesignCircularDeque
 * Created by Chiangsir.
 * Date: AD 2021/03/07
 */
public class No641_DesignCircularDeque2 {
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
    //用数组实现循环队列
    int [] arr;
    int front;
    int rear;
    int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public No641_DesignCircularDeque2(int k) {
        capacity = k + 1;
        arr = new int[capacity];
        front = rear = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        // 为了不与rear冲突，front向后退一步
        front = (front -1 + capacity)%capacity;
        arr[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        arr[rear] = value;
        rear = (rear +1)%capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return  false;
        front = (front + 1)%capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return  false;
        rear = (rear - 1 + capacity)%capacity ;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return front==rear? -1:arr[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return front==rear? -1:arr[(rear - 1 + capacity)%capacity ];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front==rear;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear + 1)%capacity ==front;
    }
}
