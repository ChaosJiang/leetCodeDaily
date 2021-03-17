/**
 * Project Name: leetcode
 * File Name: QuickSort
 * Created by Chiangsir.
 * Date: AD 2021/03/11
 */
public class QuickSort {
    /**
     * @param a
     * @param n 快速排序
     * 要点：类似于归并排序，不同点在于分区点（pivot）不是中间点，一般选取区间末尾的数字
     * @return
     */
    public static int[] quickSort(int[] a, int n) {
        sort(a, 0, n - 1);
        return a;
    }

    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int i = partition(a, lo, hi);
        sort(a, lo, i - 1);
        sort(a, i+1, hi);
    }
    public static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo;
        int j = hi;

        while (i < j) {
            // 找出左侧大于等于pivot的数
            while (i < j  && a[i] < pivot) {
                i++;
            }
            // 找出左侧小于于pivot的数
            while (i < j && a[j] >= pivot) {
                j--;
            }
            if(i >= j) break;
            // 交换pivot左侧逆序的数
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        // 将pivot点放回合适的位置
        a[hi] = a[i];
        a[i] = pivot;
        // return j也可
        return i;
    }

    public static void main(String[] args) {
//        int[] nums = {8, 10,2, 3, 6, 1, 5};
        int[] nums = {6, 1, 3, 5, 7, 2, 4, 9, 11, 8};
        System.out.println(quickSort(nums, nums.length));
    }
}
