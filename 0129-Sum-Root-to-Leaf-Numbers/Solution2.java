/// Source : https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
/// Author : chenlin
/// Time   : 2020-10-29
/// Updated: 2020-10-29

// dfs
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution2 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    // 递归函数定义：计算以node为根的二叉树到叶子结点数字之和
    private int dfs(TreeNode node, int preSum){
        if(node == null){
            return 0;
        }
        int sum = preSum * 10 + node.val;
        if(node.left == null && node.right == null){
            return sum;
        }else{
            return dfs(node.left, sum)+dfs(node.right, sum);
        }
    }
}
