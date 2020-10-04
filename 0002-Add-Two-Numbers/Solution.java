/// Source : https://leetcode-cn.com/problems/add-two-numbers/
/// Author : chenlin
/// Time   : 2020-10-04
/// Updated: 2020-10-04

// linkedlist
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;  // 记录每次一位数字加和后进位的数字
        ListNode head = null; // 头指针指向结果链表的首结点，最后返回头指针
        ListNode tail = null; // 尾指针指向结果链表的尾结点，用于从前往后构建链表
        // 在循环内部l1或l2都有可能为null，所以对他们操作之前要确保不是空
        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            if(tail == null){
                tail = node;
                head = node;
            }else{
                tail.next = node;
                tail = tail.next;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return head;
    }
}
