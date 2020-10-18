/// Source : https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
/// Author : chenlin
/// Time   : 2020-10-18
/// Updated: 2020-10-18

// fast slow pointers
// Time Complexity: O(n)
// Space Complexity: O(1)
// 算法的目的是找到要删除结点的前驱，即倒数第N+1个结点
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义虚拟头结点的目的是考虑到特殊情况：要删除的结点是头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while(n != 0){
            fast = fast.next;
            n--;
        }
        // 循环条件让fast达到尾结点而非空停止，这时候slow指向的是倒数第N+1个结点
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;  // 不应返回head因为head可能被删除
    }
}
