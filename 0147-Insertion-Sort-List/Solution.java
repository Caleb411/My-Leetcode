/// Source : https://leetcode-cn.com/problems/insertion-sort-list/submissions/
/// Author : chenlin
/// Time   : 2020-11-20
/// Updated: 2020-11-20

// linkedlist
// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode dummyHead = new ListNode(-1);  // 设置虚拟头结点的目的是可能在头结点的前面插入元素
        dummyHead.next = head;
        ListNode lastSorted = head; // 指向当前待插入结点的前驱，即排好序部分的尾结点
        ListNode cur = head.next; // 指向当前待插入结点
        while(cur != null){
            // 查找插入位置的前驱
            ListNode pre = dummyHead;
            // 和数组中的插入排序不同的是这里是从前往后找插入位置，注意判断的是前驱的下一个结点
            while(pre.next!=cur && pre.next.val<=cur.val){
                pre = pre.next;
            }
            // 判断待插入结点用动还是不用动
            if(pre.next != cur){
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }else{
                lastSorted = lastSorted.next;
            }
            // 更新当前待插入结点为它前驱的下一个结点，因为当前结点可能已经换位置了
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }
}
