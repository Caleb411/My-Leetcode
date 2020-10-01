/// Source : https://leetcode-cn.com/problems/corporate-flight-bookings/
/// Author : chenlin
/// Time   : 2020-10-01
/// Updated: 2020-10-01

// diff array
// Time Complexity: O(n)
// Space Complexity: build -> O(n) increment -> O(1) result -> O(n)
// 差分数组每个元素存储的是原数组相邻元素的差
// 由于差分数组的性质，其中一个元素的改变，在反推原始数组的时候会使后面所有元素进行相同的改变
// 差分数组的主要适用场景是频繁对原始数组的某个区间的元素进行增减
class Solution {

    private class Difference{
    
        private int[] diff; // 差分数组
        
        public Difference(int[] nums){
            assert nums.length > 0;
            // 构造差分数组
            diff = new int[nums.length];
            diff[0] = nums[0];
            for(int i = 1;i<diff.length;i++){
                diff[i] = nums[i] - nums[i-1];
            }
        }

        // 给闭区间[i...j]每个元素增加val（可以是负数）
        public void increment(int i, int j, int val){
            diff[i] += val; // [i...]所有元素加val 
            if(j + 1 < diff.length){  // 注意数组越界问题
                diff[j+1] -= val; // [j+1...]所有元素减val
            }
        }

        public int[] result(){
            // 根据差分数组构造结果数组
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for(int i = 1;i<res.length;i++){
                res[i] = diff[i] + res[i-1];
            }
            return res;
        }
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        // nums初始化为全0
        int[] nums = new int[n];
        // 根据原始数组构造差分解法
        Difference df = new Difference(nums);
        // 频繁对原始数组的某个区间的元素进行增减
        for(int[] booking: bookings){
            int i = booking[0]-1;
            int j = booking[1]-1;
            int val = booking[2];
            df.increment(i, j, val);
        }
        return df.result();
    }
}
