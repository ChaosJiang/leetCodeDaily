/**
 * Project Name: leetcode
 * File Name: BinarySearch
 * Created by Chiangsir.
 * Date: AD 2021/03/17
 */
public class BinarySearch {
    public static int firstEqual(int[] a, int value) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);
            if (a[mid] == value) {
//                res = mid;
//                break;
                if (mid == 0 || a[mid - 1] != value) return mid;
                else hi = mid - 1;
            } else if (a[mid] > value) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
//        while(res> 0 && a[res -1] == value) {
//            res--;
//        }
        return -1;
    }

    public static int lastEqual(int[] a, int value) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);
            if (a[mid] == value) {
                if (mid == a.length - 1 || a[mid + 1] != value) return mid;
                else lo = mid + 1;
            } else if (a[mid] > value) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static int firstGreaterOrEqual(int[] a, int value) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) return mid;
                else hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static int lastSmallerOrEqual(int[] a, int value) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);
            if (a[mid] > value) {
                hi = mid - 1;
            } else {
                if(mid == a.length -1 || a[mid + 1] > value) return mid;
                else lo = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
//        int[] a = {3,4,6,7,10};
        int[] a = {3,5,6,8,9,10};
        System.out.println(lastSmallerOrEqual(a, 7));
    }
}
