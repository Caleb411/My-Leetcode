/// Source : https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
/// Author : chenlin
/// Time   : 2020-08-30
/// Updated: 2020-08-30

// Remove redundant duplicates
// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int n = nums.length;
        int count = 1;
        while(i < n){
            if(nums[i] == nums[i-1]){
                count++;
                if(count > 2){
                    remove(nums, i);
                    i--;
                    n--;
                }
            }else{
                count = 1;
            }
            i++;
        }
        return n;
    }

    private void remove(int[] nums, int index){
        for(int i = index + 1; i < nums.length; i++){
            nums[i-1] = nums[i];
        }
    }
}
