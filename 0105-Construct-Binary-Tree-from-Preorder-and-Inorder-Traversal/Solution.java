  
/// Source : https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
/// Author : chenlin
/// Time   : 2020-09-22
/// Updated: 2020-09-22

// preOrder
// Time Complexity: O(n^2)
// Space Complexity: O(n)
// 根据preOrder中根结点元素来确定其在inOrder中的索引，从而确定inOrder的划分和preOrder的划分
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){
        if(pl>pr){
            return null;
        }
        int rootVal = preorder[pl];
        int index = -1;
        for(int i = il;i<=ir;i++){
            if(inorder[i] == rootVal){
                index = i;
            }
        }
        int leftSize = index-il;
        TreeNode node = new TreeNode(rootVal);
        node.left = dfs(preorder, pl+1, pl+leftSize, inorder, il, index-1);
        node.right = dfs(preorder, pl+leftSize+1, pr, inorder, index+1, ir);
        return node;
    }
}
