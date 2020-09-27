/// Source : https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
/// Author : chenlin
/// Time   : 2020-09-27
/// Updated: 2020-09-27

// postorder
// Time Complexity: O(n)
// Space Complexity: O(n)
// 后序遍历保证找到的公共祖先是最近公共祖先
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        // 假设当前结点是p，如果q在p的子树中，p即是它们的最近公共祖先，返回p；如果q不在p的子树中，返回p
        // 假设当前结点是q，同理，返回q
        // 综上，如果当前结点是p或者q，返回当前结点即可
        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // 情况1：左右子树返回的结点都是非空，由递归到底的情况可知一个是p一个是q，当前结点即作为最近公共祖先返回
        if(left != null && right != null){
            // 当前的root就是它们的最近公共祖先
            return root;
        }
        // 情况2：左右子树返回都是空，返回空
        if(left == null && right == null){
            return null;
        }
        // 情况3：左右子树返回的结点一个非空一个空，返回非空的结点
        return left == null ? right : left;
    }
}
