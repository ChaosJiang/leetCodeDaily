/**
 * Project Name: leetcode
 * File Name: BUbbleSort
 * Created by Chiangsir.
 * Date: AD 2021/03/10
 */
public class BubbleSort {
    /**
     * @param a
     * @param n
     * 要点：相邻元素比较交换
     * 一轮表后找出最大/最小值放到数组尾端
     */
    public void bubbleSort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            // 提前推出冒泡循环标志位
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[i] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            // 如果循环哪没有数据交换，说明数组已经完全有序，可直接退出
            if(!flag) break;
        }
    }

}
