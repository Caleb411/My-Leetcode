/// Source : https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
/// Author : chenlin
/// Time   : 2020-09-21
/// Updated: 2020-09-21

// inorder
// Time Complexity: O(n)
// Space Complexity: O(n)
// 先遍历右子树的中序遍历
class Solution {

    int sum = 0;    // 在遍历的过程中不断更新后缀和

    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
