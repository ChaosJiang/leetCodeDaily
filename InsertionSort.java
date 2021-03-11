/**
 * Project Name: leetcode
 * File Name: InsertionSort
 * Created by Chiangsir.
 * Date: AD 2021/03/10
 */
public class InsertionSort {
    /**
     * @param a
     * @param n
     * 要点：数组分为两部分，有序区域，无序区域
     *      每次循环，从无序取出数据插入到有序区域
     */
    public void insertionSort(int[] a, int n) {
        if (n <= 0) return;

        for (int i =1; i < n; i++) {
            int value = a[i];
            int j = i -1;

            for (; j >= 0; j--) {
                if(a[j] > value) {
                    //元素向后移动
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }
}
