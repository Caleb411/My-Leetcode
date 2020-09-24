/// Source : https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
/// Author : chenlin
/// Time   : 2020-09-24
/// Updated: 2020-09-24

// inorder
// Time Complexity: O(n)
// Space Complexity: O(n) 不考虑递归栈和结果集的空间即为O(1)
class Solution {

    int base, count, maxCount;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        for(int i = 0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }

    // 中序遍历得到有序数列，相同的数字连续
    private void dfs(TreeNode node){
        if(node != null){
            dfs(node.left);
            update(node.val);
            dfs(node.right);
        }
    }

    // 针对每个元素维护相应变量
    private void update(int x){
        if(x == base){
            count++;
        }else{
            base = x;
            count = 1;
        }
        if(count == maxCount){
            list.add(x);
        }
        if(count > maxCount){
            list.clear();
            maxCount = count;
            list.add(x);
        }
    }
}
