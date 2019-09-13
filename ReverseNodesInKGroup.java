package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: ReverseNodesInKGroup
 * Creator: Chiang
 * Date: 2019-05-30
 * Description:25. Reverse Nodes in k-Group
 */
public class ReverseNodesInKGroup {
    /**
     *
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 1) {
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;

        reverse(res, k);

        return res.next;

    }

    public void reverse(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>(k);
        int count = 0;
        ListNode cur = head.next;

        while (cur != null && count < k) {
            list.add(cur);
            cur = cur.next;
            count++;
        }
        if (count < k) {
            return;
        }


        head.next = list.get(k - 1);
        for (int i = k - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(0).next = cur;

        reverse(list.get(0), k);
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        //1. test weather we have more then k node left, if less then k node left we just return head
        ListNode node = head;
        int count = 0;
        while (count < k) {
            if (node == null) return head;
            node = node.next;
            count++;
        }
        // 2.reverse k node at current level
        ListNode pre = reverseKGroup2(node, k); //pre node point to the the answer of sub-problem
        while (count > 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count = count - 1;
        }
        return pre;
    }
}
