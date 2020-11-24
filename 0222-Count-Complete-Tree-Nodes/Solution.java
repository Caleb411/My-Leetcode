/// Source : https://leetcode-cn.com/problems/count-complete-tree-nodes/
/// Author : chenlin
/// Time   : 2020-11-24
/// Updated: 2020-11-24

// complete binary tree
// Time Complexity: O(logn*logn)
// Space Complexity: O(logn)
// 利用完全二叉树的性质
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes(root.right)+(1<<left);  // 移位运算记得加括号
        }else{
            return countNodes(root.left)+(1<<right);
        }
    }
    // 求以node为根的二叉树的层数（利用完全二叉树的性质可以使用不断向左的迭代法完成）
    private int countLevel(TreeNode node){
        int count = 0;
        while(node != null){
            count++;
            node = node.left;
        }
        return count;
    }
}
