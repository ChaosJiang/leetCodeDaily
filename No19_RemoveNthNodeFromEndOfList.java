import java.util.HashMap;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: RemoveNthNodeFromEndOfList
 * Creator: Chiang
 * Date: 2019-05-21
 * Description:19. Remove Nth Node From End of List
 */
public class No19_RemoveNthNodeFromEndOfList {
    /**
     * Given a linked list, remove the n-th node from the end of list and return its head.
     * <p>
     * Example:
     * <p>
     * Given linked list: 1->2->3->4->5, and n = 2.
     * <p>
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * <p>
     * Given n will always be valid.
     * <p>
     * Follow up:
     * <p>
     * Could you do this in one pass?
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) {
            return head;
        }
        HashMap<Integer, ListNode> listMap = new HashMap<>();
        listMap.put(1, head);

        int count = 1;
        ListNode current = head.next;

        while (current != null) {
            count++;
            listMap.put(count, current);
            current = current.next;
        }
        if (n >= count) {
            head = head.next;
        } else if (n < count) {
            current = listMap.get(count - n);
            current.next = current.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode slow = prev, fast = prev;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return prev.next;
    }
}
