/// Source : https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
/// Author : chenlin
/// Time   : 2020-09-29
/// Updated: 2020-09-29

// non-recursive
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode last = null;   // 记录上一次遍历的结点
        TreeNode cur = root;    // 记录当前遍历的结点
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                // 此时是第二次访问当前结点
                TreeNode temp = stack.peek();   // 取当前栈顶结点而非弹出，因为还有第三次访问
                if(temp.right != null && temp.right != last){    
                    cur = temp.right;
                }else{
                    // 此时是第三次访问当前结点
                    res.add(temp.val);
                    last = temp;    // 记录当前结点是上一次遍历的结点
                    stack.pop();    // 此时才能真正弹出当前结点
                }
            }
        }
        return res;
    }
}
