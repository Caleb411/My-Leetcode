/// Source : https://leetcode-cn.com/problems/sort-list/
/// Author : chenlin
/// Time   : 2020-11-21
/// Updated: 2020-11-21

// linkedlist
// Time Complexity: O(nlogn)
// Space Complexity: O(1)
class Solution {
    public ListNode sortList(ListNode head) {
        if(head ==null) return head;
        ListNode h = head;
        int length = 0;
        while(h!=null){
            length++;
            h = h.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for(int subLen=1;subLen<length;subLen<<=1){
            ListNode pre = dummyHead;   // 用于将两两合并的链表串起来
            ListNode cur = dummyHead.next;
            while(cur != null){
                ListNode left = cur;
                for(int i = 1;i < subLen && cur.next != null;i++){
                    cur = cur.next;
                }
                // 此时cur到达left链表的尾部（注意cur.next可能是null）
                // 先暂存后面的结点再断开，cur再指向暂存的结点
                ListNode right = cur.next;
                cur.next = null;
                cur = right;
                for(int i = 1;i < subLen && cur != null && cur.next != null;i++){
                    cur = cur.next;
                }
                // 此时cur到达right链表的尾部（注意可能是null）
                ListNode next = null;
                if(cur != null){
                    next = cur.next;
                    cur.next = null;
                }

                ListNode merged = merge(left, right);
                pre.next = merged;
                while(pre.next!=null){
                    pre = pre.next;
                }
                // 此时pre到达合并链表的尾部
                cur = next;
            }
        }
        return dummyHead.next;
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(left!=null && right!=null){
            if(left.val<right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left!=null ? left : right;
        return dummyHead.next;
    }
}
