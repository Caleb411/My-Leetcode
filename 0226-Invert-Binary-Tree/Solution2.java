/// Source : https://leetcode-cn.com/problems/invert-binary-tree/
/// Author : chenlin
/// Time   : 2020-09-16
/// Updated: 2020-09-16

// postorder
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
