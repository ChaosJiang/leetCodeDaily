import java.util.LinkedList;
import java.util.Queue;
/**
 * Project Name: leetcode
 * File Name: No_ImplementStackusingQueues
 * Created by Chiangsir.
 * Date: AD 2021/03/02
 */
public class No225_ImplementStackusingQueues {
    /**
     * Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the
     * functions of a normal queue (push, top, pop, and empty).
     *
     * Implement the MyStack class:
     *
     * void push(int x) Pushes element x to the top of the stack.
     * int pop() Removes the element on the top of the stack and returns it.
     * int top() Returns the element on the top of the stack.
     * boolean empty() Returns true if the stack is empty, false otherwise.
     * Notes:
     *
     * You must use only standard operations of a queue, which means only push to back, peek/pop from front, size,
     * and is empty operations are valid.
     * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list
     * or deque (double-ended queue), as long as you use only a queue's standard operations.
     *
     * Example 1:
     *
     * Input
     * ["MyStack", "push", "push", "top", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * Output
     * [null, null, null, 2, 2, false]
     *
     * Explanation
     * MyStack myStack = new MyStack();
     * myStack.push(1);
     * myStack.push(2);
     * myStack.top(); // return 2
     * myStack.pop(); // return 2
     * myStack.empty(); // return False
     *
     */
    class MyStack {
        /** Initialize your data structure here. */
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<Integer>();
            queue2 = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue2.offer(x);
            while(!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue1.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
