/// Source : https://leetcode-cn.com/problems/two-sum/
/// Author : chenlin
/// Time   : 2020-10-11
/// Updated: 2020-10-11

// hashmap
// Time Complexity: O(n)
// Space Complexity: O(n)
// 一遍哈希
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int rest = target - nums[i];
            if(map.containsKey(rest)){
                return new int[]{map.get(rest), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
