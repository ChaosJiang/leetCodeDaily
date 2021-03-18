import java.util.Random;

/**
 * Creator:CharlesChaing
 * Date: AD 2021/03/18
 * Description:
 */
public class No215_KthLargestElementInAnArray {
    /**
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     * <p>
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     * Example 2:
     * <p>
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     */
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] a, int lo, int hi, int k) {
        int pivot = randomPartition(a, lo, hi);
        if (k == pivot) {
            return a[k];
        } else {
            return k > pivot ? quickSort(a, pivot + 1, hi, k) : quickSort(a, lo, pivot - 1, k);
        }
    }

    public int randomPartition(int[] a, int lo, int hi) {
        int i = random.nextInt(hi - lo + 1) + lo;
        swap(a, i, hi);
        return partition(a, lo, hi);
    }

    public int partition(int[] a, int lo, int hi) {
        // take number at right side of array as pivot
        int x = a[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, hi);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
