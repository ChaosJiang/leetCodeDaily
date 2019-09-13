package com.leetcode;

public class No4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int mergedLen = m + n;
        int[] nums3 = new int[mergedLen];

        int i = 0, j = 0, k = 0;
        while (k < mergedLen) {

            if (i == m) {

                nums3[k++] = nums2[j++];

            } else if (j == n) {

                nums3[k++] = nums1[i++];

            } else {

                if (nums1[i] < nums2[j]) {

                    nums3[k++] = nums1[i++];
                } else {
                    nums3[k++] = nums2[j++];
                }
            }
        }
        return 0.5 * (nums3[(mergedLen - 1) / 2] + nums3[mergedLen / 2]);
    }
}
