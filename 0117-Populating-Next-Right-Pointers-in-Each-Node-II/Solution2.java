/// Source : https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
/// Author : chenlin
/// Time   : 2020-09-28
/// Updated: 2020-09-28

// bfs
// Time Complexity: O(n)
// Space Complexity: O(1)
// 因为可以逐层串成链表，所以无需队列即可完成层序遍历
class Solution2 {
    public Node connect(Node root) {
        if(root == null) return null;
        // 把每一层看成链表 cur指向当前要遍历的链表 初始为第一层的根结点
        Node cur = root;
        // 遍历每一层链表的同时将下一层结点串成链表
        while(cur != null){
            Node dummy = new Node();
            Node pre = dummy;
            while(cur != null){
                if(cur.left != null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right != null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                // 将cur指向当前链表的下一个结点
                cur = cur.next;
            }
            // 将cur指向下一层链表的初始结点
            cur = dummy.next;
        }
        return root;
    }
}
