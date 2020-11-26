/// Source : https://leetcode-cn.com/problems/maximum-gap/
/// Author : chenlin
/// Time   : 2020-11-26
/// Updated: 2020-11-26

// bucket sort
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1,(max - min)/(n - 1));// 每个桶的长度取平均间距，这样桶内部元素之间无需求间距，因为一定小于最大间距
        int bucketSize = (max - min)/d+1; // 桶都是左闭右开的，加一的目的是让最大值也能放入桶

        int[][] bucket = new int[bucketSize][2];  // 每个桶只需要放两个值，一个是桶内的最小值，一个是桶内的最大值
        for(int i = 0;i < bucketSize;i++){
            Arrays.fill(bucket[i], -1); // 初始化为-1代表桶内没有元素
        }
        // 边遍历边维护桶内的最大值和最小值
        for(int i = 0;i < n;i++){
            int idx = (nums[i] - min)/d;
            if(bucket[idx][0] == -1){
                bucket[idx][0] = bucket[idx][1] = nums[i];
            }else{
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }
        // 桶内部元素的间距最大是平均间距，一定小于最大间距，所以内部不考虑
        // 只考虑相邻有元素桶（取前一个桶中的最大值， 后一个桶中的最小值）
        int res = 0;
        int pre = -1;
        for(int i = 0;i < bucketSize;i++){
            if(bucket[i][0] == -1) continue;
            if(pre != -1) res = Math.max(res, bucket[i][0]-bucket[pre][1]);
            pre = i;
        }
        return res;
    }
}
