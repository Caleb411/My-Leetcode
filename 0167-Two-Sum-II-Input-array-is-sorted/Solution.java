/// Source : https://leetcode-cn.com/problems/sort-colors/
/// Author : chenlin
/// Time   : 2020-09-05
/// Updated: 2020-09-05

// binary search
// Time Complexity: O(nlogn)
// Space Complexity: O(1)
class Solution {
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
