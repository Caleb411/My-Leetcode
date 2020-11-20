/// Source : https://leetcode-cn.com/problems/insertion-sort-list/submissions/
/// Author : chenlin
/// Time   : 2020-11-20
/// Updated: 2020-11-20

// linkedlist
// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution2 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode cur = head.next;
        while(cur != null){
            if(lastSorted.val<=cur.val){  // 利用当前结点的前驱可以直接判断当前结点要不要动
                lastSorted = lastSorted.next;
            }else{
                // 判断要动才从前往后遍历前驱查找插入位置
                ListNode pre = dummyHead;
                while(pre.next.val<=cur.val){
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }
}
