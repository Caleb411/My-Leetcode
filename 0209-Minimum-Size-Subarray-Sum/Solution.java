/// Source : https://leetcode-cn.com/problems/minimum-size-subarray-sum/
/// Author : chenlin
/// Time   : 2020-09-08
/// Updated: 2020-09-08

// sliding window
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1; // nums[l...r]为滑动窗口
        int sum = 0; // 滑动窗口初始和为0
        int res = nums.length+1; // 结果初始化一个最大的不可能取到的值
        while(l < nums.length){
            if(r+1 < nums.length && sum < s){
                r++;
                sum +=nums[r];
            }else{
                sum -= nums[l];
                l++;
            }
            // 每次循环获得一个新的窗口
            if(sum >= s){
                res = Math.min(res, r-l+1);
            }
        }
        if(res == nums.length+1){
            return 0;
        }
        return res;
    }
}
