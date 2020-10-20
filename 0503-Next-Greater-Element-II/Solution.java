/// Source : https://leetcode-cn.com/problems/next-greater-element-ii/
/// Author : chenlin
/// Time   : 2020-10-20
/// Updated: 2020-10-20

// monotonous stack
// Time Complexity: O(n)
// Space Complexity: O(n)
// 这里计算的是距离，所以单调栈里存的是索引，比较的时候要根据索引取出值比较
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = T.length-1;i >= 0;i--){
            while(!stack.isEmpty() && T[stack.peek()] <= T[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0: stack.peek()-i;
            stack.push(i);
        }
        return res;
    }
}
