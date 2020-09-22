/// Source : https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/
/// Author : chenlin
/// Time   : 2020-09-22
/// Updated: 2020-09-22

// preOrder
// Time Complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode dfs(int[] postorder, int pl, int pr, int[] inorder, int il, int ir){
        if(pl>pr){
            return null;
        }
        int rootVal = postorder[pr];
        int index = -1;
        for(int i = il;i<=ir;i++){
            if(inorder[i] == rootVal){
                index = i;
            }
        }
        int leftSize = index-il;
        TreeNode node = new TreeNode(rootVal);
        node.left = dfs(postorder, pl, pl+leftSize-1, inorder, il, index-1);
        node.right = dfs(postorder, pl+leftSize, pr-1, inorder, index+1, ir);
        return node;
    }
}
