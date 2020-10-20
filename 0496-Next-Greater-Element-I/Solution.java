/// Source : https://leetcode-cn.com/problems/next-greater-element-i/
/// Author : chenlin
/// Time   : 2020-10-20
/// Updated: 2020-10-20

// monotonous stack
// Time Complexity: O(n)
// Space Complexity: O(n)
// 先忽略数组nums1，对nums2中的每一个元素求出其下一个更大的元素
// 将这些答案放入map中，再遍历数组nums1，并直接找出答案
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for(int i = nums2.length-1;i >= 0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1: stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int i = 0;i < res.length;i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
