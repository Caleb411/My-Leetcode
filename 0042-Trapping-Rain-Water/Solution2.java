/// Source : https://leetcode-cn.com/problems/trapping-rain-water/
/// Author : chenlin
/// Time   : 2020-10-23
/// Updated: 2020-10-23

// memo
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int n = height.length;
        // 使用备忘录避免重复计算
        int[] max_l = new int[n];
        int[] max_r = new int[n];
        // 初始化basecase
        max_l[0] = height[0];
        max_r[n-1] = height[n-1];
        // 从左向右计算max_l
        for(int i = 1;i < n-1;i++){
            max_l[i] = Math.max(height[i], max_l[i-1]);
        }
        // 从右向左计算max_r
        for(int i = n-2;i >= 1;i--){
            max_r[i] = Math.max(height[i], max_r[i+1]);
        }
        int res = 0;
        for(int i = 1;i < n-1;i++){
            res += Math.min(max_l[i], max_r[i])-height[i];
        }
        return res;
    }
}
