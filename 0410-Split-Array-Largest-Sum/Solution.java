/// Source : https://leetcode-cn.com/problems/split-array-largest-sum/
/// Author : chenlin
/// Time   : 2020-10-15
/// Updated: 2020-10-15

// greedy + binary search
// Time Complexity: O(nlogs)
// Space Complexity: O(1)
class Solution {
    public int splitArray(int[] nums, int m) {
        int left = getMax(nums);
        int right = getSum(nums);
        while(left < right){
            int mid = left+(right-left)/2;
            int n = split(nums, mid);
            if(n <= m){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    // 子数组和最大不超过max的前提下至少可以分割成几个子数组
    private int split(int[] nums, int max){
        int count = 1;
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            if(sum + nums[i] > max){
                count++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
        }
        return count;
    }

    private int getMax(int[] nums){
        int res = 0;
        for(int num: nums){
            res = Math.max(res, num);
        }
        return res;
    }

    private int getSum(int[] nums){
        int res = 0;
        for(int num: nums){
            res += num;
        }
        return res;
    }
}
