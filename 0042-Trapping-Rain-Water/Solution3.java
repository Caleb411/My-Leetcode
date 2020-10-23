/// Source : https://leetcode-cn.com/problems/trapping-rain-water/
/// Author : chenlin
/// Time   : 2020-10-23
/// Updated: 2020-10-23

// collision pointers
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution3 {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int n = height.length;
        int left = 0;
        int right = n-1;
        int res = 0;
        int l_max = height[0];
        int r_max = height[n-1];
        // 左右指针相向而行直到遍历完所有元素
        while(left <= right){
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            if(l_max < r_max){ // left左边最大的比left右边其中一个小就代表比右边最大的小
                res += l_max - height[left];
                left++;
            }else{ // right右边最大的比right左边其中一个小就代表比左边最大的小
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }
}
