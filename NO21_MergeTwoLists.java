/**
 * Project Name: leetcode
 * File Name: NO21_MergeTwoLists
 * Created by Chiangsir.
 * Date: AD 2021/02/20
 */
public class NO21_MergeTwoLists {
    /**
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     * <p>
     * Example:
     * <p>
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null && l2!=null) {
            if(l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            if(l1 == null) cur.next = l2;
            else if(l2 == null) cur.next = l1;
        }
        return head.next;
    }
}
