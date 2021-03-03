import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Project Name: leetcode
 * File Name: No169_MajorityElement
 * Created by Chiangsir.
 * Date: AD 2021/03/02
 */
public class No169_MajorityElement {
    /**
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     *
     * Example 1:
     *
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     *
     * Constraints:
     *
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -231 <= nums[i] <= 231 - 1
     *
     * Follow-up: Could you solve the problem in linear time and in O(1) space?
     */
    public int majorityElement(int[] nums) {
        // 用hashmap来计数
        Map<Integer, Integer> counts = new HashMap();
        for (int num: nums) {
            if(!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        // 找出count最大的数字
        Map.Entry<Integer, Integer> majorityEnrty = null;
        for(Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            if(majorityEnrty == null || entry.getValue() > majorityEnrty.getValue()) {
                majorityEnrty = entry;
            }
        }
        return majorityEnrty.getKey();
    }
    public int majorityElement2(int[] nums) {
        //因为钟数在长度为n的数组中至少出现（n/2 + 1）次，那么下标为n/2的元素一定是众数
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
