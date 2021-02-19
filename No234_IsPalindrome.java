import java.time.chrono.IsoChronology;

/**
 * Project Name: leetcode
 * File Name: IsPalindrome
 * Created by Chiangsir.
 * Date: AD 2021/02/19
 */
public class No234_IsPalindrome {
    /**
     *请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
     */
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            // 对前半部分进行逆序
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // 保证前半部分全部逆序完毕
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i :new int[]{2,3,3,2,1}) {
            current.next = new ListNode(i);
            current = current.next;
        }
        System.out.println(isPalindrome(head));

    }
}
