/// Source : https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
/// Author : chenlin
/// Time   : 2020-09-06
/// Updated: 2020-09-06

// binary search
// Time Complexity: O(nlogn)
// Space Complexity: O(1)
class Solution {
    // 遍历数组的同时对遍历位置右边的区间做二分搜索
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i = 0;i < n;i++){
            int left = i+1;
            int right = n-1;
            while(left <= right){
                int mid = left+(right-left)/2;
                int rest = target - numbers[i];
                if(numbers[mid] == rest){
                    return new int[]{i+1, mid+1};
                }
                if(numbers[mid] < rest){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return null;
    }
}
