/// Source : https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
/// Author : chenlin
/// Time   : 2020-10-26
/// Updated: 2020-10-26

// counting sort
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int n = nums.length;
        for(int i = 0;i < n;i++){
            count[nums[i]]++;
        }
        // 求前缀和：注意边界条件
        for(int i = 1;i <= 100;i++){
            count[i] += count[i-1];
        }
        int[] res = new int[n];
        for(int i = 0;i < n;i++){
            // 注意边界
            res[i] = nums[i] == 0 ? 0 : count[nums[i]-1];
        }
        return res;
    }
}
