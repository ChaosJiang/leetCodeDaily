/**
 * Project Name: leetcode
 * File Name: SelectionSort
 * Created by Chiangsir.
 * Date: AD 2021/03/11
 */
public class SelectionSort {
    /**
     *
     * @param a
     * @param n
     * 选择排序
     * 要点：数组菲为已排序区间和待排序区间，已排序区间初始长度为0。
     * 每次循环从待排序区间选出最小值插入（元素交换）已排序区间末尾。
     */
    public void selectionSort(int[] a, int n) {
        if (n <= 0) return;
        for (int i = 0; i < n; i++) {

            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) minIndex = j;
            }
            if (i != minIndex) {
                int tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp;
            }
        }
    }
}
