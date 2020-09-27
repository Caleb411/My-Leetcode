/// Source : https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
/// Author : chenlin
/// Time   : 2020-09-27
/// Updated: 2020-09-27

// BST search
// Time Complexity: O(n)
// Space Complexity: O(n)
// 利用二分搜索树的性质进行查找
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
