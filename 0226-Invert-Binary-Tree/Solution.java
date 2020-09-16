/// Source : https://leetcode-cn.com/problems/invert-binary-tree/
/// Author : chenlin
/// Time   : 2020-09-16
/// Updated: 2020-09-16

// preorder
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
