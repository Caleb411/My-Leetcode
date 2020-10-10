/// Source : https://leetcode-cn.com/problems/linked-list-cycle-ii/
/// Author : chenlin
/// Time   : 2020-10-10
/// Updated: 2020-10-10

// fast slow pointers
// Time Complexity: O(n)
// Space Complexity: O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        // 如果链表中没有环，直接返回空
        if(fast == null || fast.next == null) return null;
        // 有环的情况下才开始找环的入口
        slow = head;
        while(fast != null && fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
