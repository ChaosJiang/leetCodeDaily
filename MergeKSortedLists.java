package com.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: MergeKSortedLists
 * Creator: Chiang
 * Date: 2019-05-23
 * Description:23. Merge k Sorted Lists
 */
public class MergeKSortedLists {
    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     * <p>
     * Example:
     * <p>
     * Input:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        int length = lists.length;

        if (lists.length < 1) {
            return res;
        }
        res = lists[0];
        for (int i = 1; i < length; i++) {
            res = merge2Lists(res, lists[i]);
        }
        return res;
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode res = start;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                start.next = l2;
                l2 = l2.next;
            } else {
                start.next = l1;
                l1 = l1.next;
            }
            start = start.next;
        }
        if (l1 != null) {
            start.next = l1;
        }
        if (l2 != null) {
            start.next = l2;
        }
        return res.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
