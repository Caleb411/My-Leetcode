/// Source : https://leetcode-cn.com/problems/next-greater-element-ii/
/// Author : chenlin
/// Time   : 2020-10-20
/// Updated: 2020-10-20

// monotonous stack
// Time Complexity: O(n)
// Space Complexity: O(n)
// 将数组长度翻倍：可以不用构造新数组，而是利用循环数组的技巧来模拟数组长度翻倍的效果
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        // 假装这个数组长度翻倍了，索引要求模
        for(int i = nums.length*2-1;i >= 0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%n]){
                stack.pop();
            }
            res[i%n] = stack.isEmpty() ? -1: stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}
