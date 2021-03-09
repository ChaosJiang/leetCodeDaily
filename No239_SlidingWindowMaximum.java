import java.util.*;

/**
 * Project Name: leetcode
 * File Name: NO239_SlidingWindowMaximum
 * Created by Chiangsir.
 * Date: AD 2021/03/09
 */
public class No239_SlidingWindowMaximum {
    /**
     * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     * <p>
     * Return the max sliding window.
     * <p>
     *  
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * Example 2:
     * <p>
     * Input: nums = [1], k = 1
     * Output: [1]
     * Example 3:
     * <p>
     * Input: nums = [1,-1], k = 1
     * Output: [1,-1]
     * Example 4:
     * <p>
     * Input: nums = [9,11], k = 2
     * Output: [11]
     * Example 5:
     * <p>
     * Input: nums = [4,-2], k = 2
     * Output: [4]
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 利用优先队列实现
        int length = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length + 1 - k];
        res[0] = pq.peek()[0];

        for (int i = k; i < length; i++) {
            pq.offer(new int[]{nums[i], i});

            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,4};
        System.out.println(maxSlidingWindow(nums, 2));
    }
}
