/// Source : https://leetcode-cn.com/problems/linked-list-cycle/
/// Author : chenlin
/// Time   : 2020-10-09
/// Updated: 2020-10-09

// fast slow pointers
// Time Complexity: O(n)
// Space Complexity: O(1)
// 如果链表中有环，快指针比慢指针多走一个环
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 快指针每次走两步，慢指针每次走一步
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
