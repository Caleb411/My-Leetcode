/// Source : https://leetcode-cn.com/problems/trapping-rain-water/
/// Author : chenlin
/// Time   : 2020-10-23
/// Updated: 2020-10-23

// violence
// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        // 两端边界不能接雨水
        for(int i = 1;i < n-1;i++){
            int max_l = 0;
            int max_r = 0;
            // 自身的高度在计算两边最大高度的时候都要考虑到
            // 找出[0..i]的最大值
            for(int j = 0;j <= i;j++){
                max_l = Math.max(max_l, height[j]);
            }
            // 找出[i...n-1]的最大值
            for(int j = i;j < n;j++){
                max_r = Math.max(max_r, height[j]);
            }
            res += Math.min(max_l, max_r) - height[i];
        }
        return res;
    }
}
