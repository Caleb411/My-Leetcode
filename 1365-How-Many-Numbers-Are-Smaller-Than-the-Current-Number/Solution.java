/// Source : https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
/// Author : chenlin
/// Time   : 2020-10-26
/// Updated: 2020-10-26

// sort
// Time Complexity: O(nlogn)
// Space Complexity: O(n)
class Solution {
    // 需要找到排序后元素对应在原数组中的索引
    // 在计数的时候要考虑重复元素的情况
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] data = new int[n][2];
        for(int i = 0;i < n;i++){
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, (a,b)->a[0]-b[0]);
        int[] res = new int[n];
        int pre = 0;
        for(int i = 1;i < n;i++){
            if(data[i][0] != data[i-1][0]){
                pre = i;
            }
            res[data[i][1]] = pre;
        }
        return res;
    }
}
