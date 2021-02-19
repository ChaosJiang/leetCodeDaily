/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: SwapNodesInPairs
 * Creator: Chiang
 * Date: 2019-05-29
 * Description:24. Swap Nodes in Pairs
 */
public class SwapNodesInPairs {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * <p>
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     * <p>
     * <p>
     * <p>
     * Example:
     * <p>
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {

        ListNode res = new ListNode(0);
        res.next = head;

        swap(res, head);
        return res.next;
    }

    public void swap(ListNode res, ListNode head) {
        if (head != null && head.next != null) {
            ListNode next = head.next;

            head.next = next.next;
            next.next = head;
            res.next = next;
            swap(head, head.next);
        }
    }
}
