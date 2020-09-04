/// Source : https://leetcode-cn.com/problems/binary-tree-paths/
/// Author : chenlin
/// Time   : 2020-09-04
/// Updated: 2020-09-04

// dfs
// Time Complexity: O(n)
// Space Complexity: O(h)
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode node, String path, List<String> list){
        if(node!=null){
            if(node.left == null && node.right == null){
                // 到达叶子结点就添加到结果集中
                list.add(path+node.val);
            }
            dfs(node.left, path+node.val+"->", list);
            dfs(node.right, path+node.val+"->", list);
        }
    }
}
