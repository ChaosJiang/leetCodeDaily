package com.leetcode;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //No3_LongestSubstringWithoutRepeatingCharacters No3 = new No3_LongestSubstringWithoutRepeatingCharacters();
        //Example 1:
        //
        //Input: "abcabcbb"
        //Output: 3
        //Explanation: The answer is "abc", with the length of 3.
//        String exma1 = "abcabcbb";
//        System.out.println(No3.lengthOfLongestSubstring(exma1));
        //Example 2:
        //
        //Input: "bbbbb"
        //Output: 1
        //Explanation: The answer is "b", with the length of 1.
        //String exma2 = "cabcedkefjhijk";
        //System.out.println(No3.lengthOfLongestSubstring(exma2));
        //Example 3:
        //
        //Input: "pwwkew"
        //Output: 3S
//        String exma3 = "pwwkew";
//        System.out.println(No3.lengthOfLongestSubstring(exma3));

//        No4_MedianOfTwoSortedArrays no4 = new No4_MedianOfTwoSortedArrays();
//        int [] nums1 = {0,1,3};
//        int [] nums2 = {2};
//        System.out.println(no4.findMedianSortedArrays(nums1, nums2));

//        No5_LongestPalindromicSubstring no5 = new No5_LongestPalindromicSubstring();
////        String s = "cbbd";
////        System.out.print(no5.longestPalindrome(s));
//        No6_ZigZagConversion no6 = new No6_ZigZagConversion();
//        String s = "PAYPALISHIRING";
//        int numRows = 6;
//        System.out.print(no6.convert(s, numRows));
//
//        No8_StringToInteger no8 = new No8_StringToInteger();
//        String s = "1-";
//        System.out.println(no8.myAtoi(s));


//        RegularExpressionMatching no10 = new RegularExpressionMatching();
//        String s = "aa";
//        String p = "a*";
//        System.out.println(no10.isMatch(s,p));

        /* 11. Container With Most Water */
//        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
//        int[] input = {1,8,6,2,5,4,8,3,7};
//        System.out.println(containerWithMostWater.maxArea2(input));

        /* 12. Integer to Roman */
//        IntegerToRoman integerToRoman = new IntegerToRoman();
//        int input = 1994;
//        System.out.println(integerToRoman.intToRoman2(input));

        /* 13. Roman to Integer */
//        RomanToInteger romanToInteger = new RomanToInteger();
//        String input = "MCMXCIV";
//        System.out.println(romanToInteger.romanToInt(input));

        /* 14. Longest Common Prefix */
//        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
//        String[] input = {"dog","racecar","car"};
//        System.out.println(longestCommonPrefix.longestCommonPrefix(input));

        /* 15. 3Sum */
//        ThreeSum threeSum = new ThreeSum();
//        int[] input = {-1, 0, 1, 2, -1, -4,-3};
//        System.out.println(threeSum.threeSum2(input));

        /* 17. Letter Combinations of a Phone Number */
//        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
//        String input = "11abcd";
//        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations(input));input

        /* 18. 4Sum */
//        FourSum fourSum = new FourSum();
//        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
//        int target = -9;
//        System.out.println(fourSum.fourSum(nums, target));

        /* 454. 4Sum II */
//        FourSum2 fourSum2 = new FourSum2();
//        int[] A = { 1, 2};
//        int[] B = {-2,-1};
//        int[] C = {-1, 2};
//        int[] D = { 0, 2147483647};
//        System.out.println(fourSum2.fourSumCount(A, B, C, D));
        /* 20. Valid Parentheses */
//        ValidParentheses validParentheses = new ValidParentheses();
//        String input = "{[]}";
//        System.out.println(validParentheses.isValid(input));

        /* 20. Valid Parentheses */
//        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
//
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(5);
//
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
//
//        ListNode l3 = new ListNode(2);
//        l3.next = new ListNode(6);
//
//        ListNode[] list = {l1, l2, l3};
//
//        System.out.println(mergeKSortedLists.mergeKLists2(list));
        /* 22. Generate Parentheses */
//        GenerateParentheses generateParentheses = new GenerateParentheses();
//        int input = 3;
//        System.out.println(generateParentheses.generateParenthesis(input));
        /* 24. Swap Nodes in Pairs */
//        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
//        ListNode list = new ListNode(1);
//        list.next = new ListNode(2);
//        list.next.next = new ListNode(3);
//        list.next.next.next = new ListNode(4);
//        System.out.println(swapNodesInPairs.swapPairs(list));

        /* 25. Reverse Nodes in k-Group */
//        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
//        ListNode list = new ListNode(1);
//        list.next = new ListNode(2);
//        list.next.next = new ListNode(3);
//        list.next.next.next = new ListNode(4);
//        list.next.next.next.next = new ListNode(5);
//        System.out.println(reverseNodesInKGroup.reverseKGroup2(list,2));
        /* 26. Remove Duplicates from Sorted Array */
//        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
//        int[] input = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4};
//        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(input));
        SubStringWithConcatenationOfAllWords subStringWithConcatenationOfAllWords = new SubStringWithConcatenationOfAllWords();
        /* 30. Substring with Concatenation of All Words */
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(subStringWithConcatenationOfAllWords.findSubstring(s, words));


    }
}
