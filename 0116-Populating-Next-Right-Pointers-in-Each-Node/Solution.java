/// Source : https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
/// Author : chenlin
/// Time   : 2020-09-16
/// Updated: 2020-09-16

// preorder
// Time Complexity: O(n)
// Space Complexity: O(logn)
// 二叉树的问题难点在于，如何把题目的要求细化成每个节点需要做的事情
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        connectTwoNodes(root.left, root.right);
        return root;
    }

    // 基于两个结点的先序遍历递归函数
    private void connectTwoNodes(Node node1, Node node2){
        if(node1 != null && node2 != null){
            node1.next = node2;
            // 连接相同父节点的两个子节点
            connectTwoNodes(node1.left, node1.right);
            connectTwoNodes(node2.left, node2.right);
            // 连接跨越父节点的两个子节点
            connectTwoNodes(node1.right, node2.left);
        }
    }
}
