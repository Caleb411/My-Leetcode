/// Source : https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
/// Author : chenlin
/// Time   : 2020-10-29
/// Updated: 2020-10-29

// dfs + backtrack
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        dfs(root, new ArrayList<>());
        int sum = 0;
        for(List<Integer> path: res){
            int result = 0;
            for(int p: path){
                result = result * 10 + p;
            }
            sum += result;
        }
        return sum;
    }

    private void dfs(TreeNode node, List<Integer> path){
        if(node == null){
            return;
        }
        path.add(node.val);
        // 加入结果集的时机应该是遍历到叶子结点的时候而不是空的时候
        if(node.left == null && node.right == null){
            res.add(new ArrayList<>(path));
        }
        if(node.left != null){
            dfs(node.left, path);
        }
        if(node.right != null){
            dfs(node.right, path);
        }
        path.remove(path.size()-1);
    }
}
