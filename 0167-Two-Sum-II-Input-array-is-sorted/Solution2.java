/// Source : https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
/// Author : chenlin
/// Time   : 2020-09-06
/// Updated: 2020-09-06

// Collision pointers
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1, right+1};
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return null;
    }
}
