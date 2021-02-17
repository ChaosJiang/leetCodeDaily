import java.util.Arrays;

//Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//        Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
//
//        You may assume that each input would have exactly one solution and you may not use the same element twice.
//
//
//
//        Example 1:
//
//        Input: numbers = [2,7,11,15], target = 9
//        Output: [1,2]
//        Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
//        Example 2:
//
//        Input: numbers = [2,3,4], target = 6
//        Output: [1,3]
//        Example 3:
//
//        Input: numbers = [-1,0], target = -1
//        Output: [1,2]
//
//
//        Constraints:
//
//        2 <= numbers.length <= 3 * 104
//        -1000 <= numbers[i] <= 1000
//        numbers is sorted in increasing order.
//        -1000 <= target <= 1000
//        Only one valid answer exists.
public class No167_TwoSum2 {
//    // 2分法
//    public static int[] twoSum(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length; i++) {
//            int low = i + 1, high = numbers.length -1;
//            while(low <= high) {
//                int mid = (high - low)/2 + low;
//                if(numbers[i] >  target - numbers[mid]) {
//                    high = mid -1;
//                } else if (numbers[i] < target - numbers[mid]) {
//                    low = mid + 1;
//                } else {
//                    return new int[]{i + 1, mid + 1};
//                }
//            }
//        }
//        return new int[]{-1, -1};
//    }
    // 双指针法
    public static int[] twoSum(int[] numbers, int target) {
        int head = 0, tail = numbers.length -1;
        while(head <  tail) {
            if (numbers[head] == (target - numbers[tail])) {
                return new int[]{head + 1, tail + 1};
            } else if (numbers[head] > target - numbers[tail]) {
                tail -= 1;
            } else {
                head += 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
//        int[] numbers = {2, 3, 4};
//        int target = 6;
//        int[] numbers = {2,7,11,15};
//        int target = 9;
        int[] numbers = {-1, 0};
        int target = -1;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}


