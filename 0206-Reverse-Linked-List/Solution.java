/// Source : https://leetcode-cn.com/problems/reverse-linked-list/
/// Author : chenlin
/// Time   : 2020-10-09
/// Updated: 2020-10-09

// linkedlist
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next; // 接下来cur.next会发生改变，需要暂存下一个结点
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
