/// Source : https://leetcode-cn.com/problems/find-duplicate-subtrees/
/// Author : chenlin
/// Time   : 2020-10-13
/// Updated: 2020-10-13

// postorder
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {

    HashMap<String, Integer> memo = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode node){
        if(node == null){
            return "#";
        }
        String left = traverse(node.left);
        String right = traverse(node.right);
        String subTree = left+","+right+","+node.val;

        int freq = memo.getOrDefault(subTree, 0);
        if(freq == 1){
            res.add(node);
        }
        memo.put(subTree, freq+1);

        return subTree;
    }
}
