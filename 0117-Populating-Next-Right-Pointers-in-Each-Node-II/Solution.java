/// Source : https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
/// Author : chenlin
/// Time   : 2020-09-28
/// Updated: 2020-09-28

// bfs
// Time Complexity: O(n)
// Space Complexity: O(n)
// 遍历每层结点的时候逐个连接起来
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            for(int i = 0;i<size;i++){
                Node cur = queue.poll();
                if(pre != null){
                    pre.next = cur;
                }
                pre = cur;
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return root;
    }
}
