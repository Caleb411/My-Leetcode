/// Source : https://leetcode-cn.com/problems/reverse-linked-list/
/// Author : chenlin
/// Time   : 2020-10-09
/// Updated: 2020-10-09

// linkedlist
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null; // 链表结尾的next不置空会导致出现环
        return newHead;
    }
}
