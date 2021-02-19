/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: MergeTwoSortedLists
 * Creator: Chiang
 * Date: 2019-05-23
 * Description:21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {
    /**
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     * <p>
     * Example:
     * <p>
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
