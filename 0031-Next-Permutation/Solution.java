/// Source : https://leetcode-cn.com/problems/next-permutation/
/// Author : chenlin
/// Time   : 2020-11-10
/// Updated: 2020-11-10

// greedy
// Time Complexity: O(n)
// Space Complexity: O(1)
// 我们需要将一个左边的「较小数」与一个右边的「较大数」交换
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        // 首先要从右往左找到一个降序序列（贪婪匹配）紧挨的左边元素作为左边的「较小数」
        int i = len-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        // 如果找的到的话，否则整个序列都是降序序列
        if(i>=0){
            int j = len-1;
            // 在降序序列中找到第一个大于左边的「较小数」的「较大数」
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(nums, i, j);        
        }
        // 降序序列变升序（双指针翻转）
        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length-1;
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
