/// Source : https://leetcode-cn.com/problems/odd-even-linked-list/
/// Author : chenlin
/// Time   : 2020-11-13
/// Updated: 2020-11-13

// violence
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null ||head.next ==null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while(slow!=null){
            pre.next = new ListNode(slow.val);  // 创建新结点的目的是防止原来的链表发生更改
            if(slow.next==null) break;
            slow = slow.next.next;
            pre = pre.next;
        }
        // 在上面循环中最后一个元素直接break 所以这里要更新一下pre指针
        if(slow != null && slow.next == null){
            pre = pre.next;
        } 
        while(fast!=null){
            pre.next = new ListNode(fast.val);  // 创建新结点的目的是防止出现原来链表中的元素
            if(fast.next==null) break;
            fast = fast.next.next;
            pre = pre.next;
        }
        return dummyHead.next;
    }
}
