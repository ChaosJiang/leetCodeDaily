/**
 * @author : chaosjiang
 * @created : AD 2021/12/18, Saturday
 * @Description:Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing
 * the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 **/
public class No300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        int maxLen = 1;

        for (int i = 1; i < len; i++) {
            ans[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    ans[i] = Math.max(ans[i], ans[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, ans[i]);
        }
        return maxLen;
    }
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        int[] tail = new int[len];
        int maxLen = 1;
        for (int num : nums) {
            int l = 0, r = maxLen;
            while(l < r) {
                int m = (l + r) >> 1;
                if(tail[m] < num) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            tail[l] = num;
            if(maxLen == r) maxLen++;
        }
        return maxLen;
    }

}
