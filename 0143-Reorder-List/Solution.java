/// Source : https://leetcode-cn.com/problems/reorder-list/
/// Author : chenlin
/// Time   : 2020-10-20
/// Updated: 2020-10-20

// linear list
// Time Complexity: O(n)
// Space Complexity: O(n)
// 将链表的每个结点存在顺序表里并根据索引重新构建next
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size()-1;
        // 因为一次循环两个指针都要变，所以终止条件放循环中间且循环条件不取等号
        while(left < right){
            list.get(left).next = list.get(right);
            left++;
            if(left == right) break;
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }
}
