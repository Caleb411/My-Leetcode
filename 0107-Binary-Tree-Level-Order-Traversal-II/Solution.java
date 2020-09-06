/// Source : https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
/// Author : chenlin
/// Time   : 2020-09-06
/// Updated: 2020-09-06

// bfs
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();    // 计算size必须放在循环外
            for(int i = 0;i < size;i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(0, list);   // 使用链表在头部插入
        }
        return res;
    }
}
