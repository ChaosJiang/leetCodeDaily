import java.util.ArrayList;

/**
 * Project Name: leetcode
 * File Name: Bo155_MinStack
 * Created by Chiangsir.
 * Date: AD 2021/02/26
 * description: 常规方法，为了能在常数时间内找到最小值，每次push，pop后都重新查找最小值，并保存至变量minIndex
 */
public class No155_MinStack {
    /** initialize your data structure here. */
    private ArrayList<Integer> stack;
    private int count;
    private int minIndex;

    public No155_MinStack() {
        this.stack = new ArrayList<Integer>();
        this.minIndex = 0;
    }

    public void push(int x) {
        this.stack.add(x);
        ++this.count;
        if(x < this.stack.get(minIndex)) minIndex = this.count -1;
    }

    public void pop() {
        if(this.count == 0) return;
        this.stack.remove(this.count -1);
        --this.count;
        this.minIndex = 0;
        for (int i = 0; i < this.count; i++) {
            if(this.stack.get(i) < this.stack.get(minIndex)) this.minIndex = i;
        }
    }

    public int top() {
        return this.count == 0 ? null : this.stack.get(count -1);
    }

    public int getMin() {
        return this.count == 0 ? null: this.stack.get(minIndex);
    }
}
