/// Source : https://leetcode-cn.com/problems/sort-list/
/// Author : chenlin
/// Time   : 2020-11-21
/// Updated: 2020-11-21

// linkedlist
// Time Complexity: O(nlogn)
// Space Complexity: O(logn)
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 快慢指针找到中间结点
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next; // 先暂存右边链表的头结点再断开
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        ListNode p = new ListNode(0); // 始终指向即将要插入结点的前驱
        ListNode dummyHead = p; // 记录最后需要返回的虚拟头结点
        while(left!=null && right!=null){
            if(left.val < right.val){
                p.next = left;
                left = left.next;
            }else{
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left != null ? left : right;
        return dummyHead.next; 
    }
}
