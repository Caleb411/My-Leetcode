/// Source : https://leetcode-cn.com/problems/sort-colors/
/// Author : chenlin
/// Time   : 2020-09-05
/// Updated: 2020-09-05

// counting sort
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    // 扫描数组两遍
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0;i<nums.length;i++){
            // 注意索引越界
            if(nums[i] < 0 || nums[i] > 2){
                throw new IllegalArgumentException("out of bound");
            }
            count[nums[i]]++;
        }
        int index = 0;
        for(int i = 0;i < count.length;i++){
            for(int j = 0;j < count[i];j++){
                nums[index] = i;
                index++;
            }
        }
    }
}
