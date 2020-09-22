/// Source : https://leetcode-cn.com/problems/maximum-binary-tree/
/// Author : chenlin
/// Time   : 2020-09-22
/// Updated: 2020-09-22

// preOrder
// Time Complexity: O(n^2)
// Space Complexity: O(n)
// 找出当前数组中的最大值和对应的索引构造根结点，再递归调用左右子树构造左右孩子
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    private TreeNode dfs(int[] nums, int l, int r){
        if(l > r){
            return null;
        }
        int maxVal = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i = l;i<=r;i++){
            if(nums[i]>maxVal){
                maxVal = nums[i];
                maxIdx = i;
            }
        }
        TreeNode node = new TreeNode(maxVal);
        node.left = dfs(nums, l, maxIdx-1);
        node.right = dfs(nums, maxIdx+1, r);
        return node;
    }
}
