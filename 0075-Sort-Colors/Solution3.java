/// Source : https://leetcode-cn.com/problems/sort-colors/
/// Author : chenlin
/// Time   : 2020-09-05
/// Updated: 2020-09-05

// partition
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution2 {
    public void sortColors(int[] nums) {
        int zero = -1;  // nums[0...zero] == 0
        int two = nums.length;  // nums[two...n-1] == 2
        for(int i = 0;i < two;){
            if(nums[i] == 1){
                i++;
            }else if(nums[i] == 2){
                two--;
                swap(nums, i, two);
            }else{  // nums[i] == 0
                zero++;
                swap(nums, i, zero);
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
