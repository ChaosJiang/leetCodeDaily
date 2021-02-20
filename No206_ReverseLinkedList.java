/**
 * Project Name: leetcode
 * File Name: No206_ReverseLinkedList
 * Created by Chiangsir.
 * Date: AD 2021/02/20
 */
public class No206_ReverseLinkedList {
    /**
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     *
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     * Input: head = [1,2]
     * Output: [2,1]
     * Input: head = []
     * Output: []
     * Constraints:
     *
     * The number of nodes in the list is the range [0, 5000].
     * -5000 <= Node.val <= 5000
     *
     * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
     */
     public static ListNode reverseList(ListNode head) {
         if(head == null || head.next == null) {
             return head;
         }
         ListNode preNode = new ListNode(-1);
         ListNode prev = null;
         while(head != null) {
             preNode.next = head;
             head = head.next;
             preNode.next.next = prev;
             prev = preNode.next;
         }
         return preNode.next;
     }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i : new int[] {2,3,4,5}) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println(reverseList(head));
    }
}
