/// Source : https://leetcode-cn.com/problems/odd-even-linked-list/
/// Author : chenlin
/// Time   : 2020-11-13
/// Updated: 2020-11-13

// linkedlist
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
