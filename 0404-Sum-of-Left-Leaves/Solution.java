/// Source : https://leetcode-cn.com/problems/sum-of-left-leaves/
/// Author : chenlin
/// Time   : 2020-09-19
/// Updated: 2020-09-19

// preorder
// Time Complexity: O(n)
// Space Complexity: O(n)
// 左叶子结点：是其父亲结点的左孩子；是左右孩子都为空的叶子结点
class Solution {

    int sum = 0;  // 记录结果

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return sum;
    }

    // 需要传入额外参数代表当前结点是其父亲结点的左孩子还是右孩子
    private void dfs(TreeNode node, boolean isLeft){
        if(node == null) return;
        if(node.left == null && node.right == null && isLeft){
            sum += node.val;
        }
        dfs(node.left, true);
        dfs(node.right, false);
    }
}
