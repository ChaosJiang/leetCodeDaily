/**
 * Project Name: leetcode
 * File Name: MergeSort
 * Created by Chiangsir.
 * Date: AD 2021/03/11
 */
public class MergeSort {
    public void mergeSort(int[] a, int n) {
        mergeSort_c(a, 0, n - 1);
    }

    public void mergeSort_c(int[] a, int lo, int hi) {
        // 递归终止条件
        if (lo >= hi) return;
        // 中间位置mid
        int mid = (lo + hi) >> 1;
        // 分治递归
        mergeSort_c(a, lo, mid);
        mergeSort_c(a, mid + 1, hi);
        // 合并数组
        merge(a, lo, mid, hi);
    }

    public void merge(int[] a, int lo, int mid, int hi) {
        int n = hi - lo + 1;
        // 临时数组
        int tmp[] = new int[n];
        int i = lo;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= hi) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= hi) tmp[k++] = a[j++];
        // copy from tmp to a
        for (k = 0; k < n; k++) {
            a[lo + k] = tmp[k];
        }
    }
}