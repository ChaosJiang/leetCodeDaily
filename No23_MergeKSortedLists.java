
/**
 * Project Name: leetcode Package Name: leetcode File Name: MergeKSortedLists
 * Creator: Chiang Date: 2019-05-23 Description:23. Merge k Sorted Lists
 */
public class No23_MergeKSortedLists {
    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and
     * describe its complexity.
     * <p>
     * Example:
     * <p>
     * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    // 分治合并法
    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        return Merge2Lists(merge(lists, start, mid), merge(lists, mid + 1, end));
    }

    public ListNode Merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ans.next = l1;
                l1 = l1.next;
            } else {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        ans.next = (l1 != null) ? l1 : l2;
        return head.next;
    }
}
