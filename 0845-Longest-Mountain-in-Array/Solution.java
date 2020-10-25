/// Source : https://leetcode-cn.com/problems/longest-mountain-in-array/
/// Author : chenlin
/// Time   : 2020-10-25
/// Updated: 2020-10-25

// dp
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int longestMountain(int[] A) {
        int n = A.length;
        if(n == 0) return 0;
        // left[i]表示A[i]向左侧最多可以扩展的元素数目
        int[] left = new int[n];
        for(int i = 1;i < n;i++){
            left[i] = A[i] > A[i-1] ? left[i-1]+1 : 0;
        }
        // right[i]表示A[i]向右侧最多可以扩展的元素数目
        int[] right = new int[n];
        for(int i = n-2;i>=0;i--){
            right[i] = A[i] > A[i+1] ? right[i+1]+1 : 0;
        }
        int res = 0;
        // 枚举山顶
        for(int i = 0;i < n;i++){
            if(left[i] > 0 && right[i] > 0){
                res = Math.max(res, left[i]+right[i]+1);
            }
        }
        return res;
    }
}
