/// Source : https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
/// Author : chenlin
/// Time   : 2020-09-16
/// Updated: 2020-09-16

// postorder
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        // 先将左右子树分别拉平成链表
        flatten(root.left);
        flatten(root.right);
        // 右子树连到左子树最后，将左子树置空，并将左子树连到右子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(root.left != null){
            TreeNode p = root.left;
            while(p.right!=null){
                p = p.right;
            }
            p.right = right;
            root.left = null;
            root.right = left;
        }
    }
}
