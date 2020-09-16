/// Source : https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
/// Author : chenlin
/// Time   : 2020-09-16
/// Updated: 2020-09-16

// postorder
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution2 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        // 先将左右子树分别拉平成链表
        flatten(root.left);
        flatten(root.right);
        // 左子树置空，将左子树作为右子树，将原先的右子树接到当前右子树的末端
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while(p.right!=null){
            p = p.right;
        }
        p.right = right;
    }
}
