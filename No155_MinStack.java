import java.util.ArrayList;

/**
 * Project Name: leetcode
 * File Name: Bo155_MinStack
 * Created by Chiangsir.
 * Date: AD 2021/02/26
 * description: 用空间换取时间，增加额外的minStrack。每次入栈后，就把栈的最小值保存至minStrack
 */
public class No155_MinStack {
    /** initialize your data structure here. */
    private ArrayList<Integer> stack;
    private ArrayList<Integer> min;
    private int count;

    public No155_MinStack() {
        this.stack = new ArrayList<Integer>();
        this.min = new ArrayList<Integer>();
        this.count = 0;
    }

    public void push(int x) {
        this.stack.add(x);
        if(this.count == 0) {
            this.min.add(x);
        } else {
            this.min.add(x < this.min.get(count -1) ? x : this.min.get(count -1));
        }
        ++this.count;
    }

    public void pop() {
        if(this.count == 0) return;
        this.stack.remove(count -1);
        this.min.remove(count -1);
        --this.count;
    }

    public int top() {
        return this.count == 0 ? null : this.stack.get(count -1);
    }

    public int getMin() {
        return this.count == 0 ? null: this.min.get(count - 1);
    }
}