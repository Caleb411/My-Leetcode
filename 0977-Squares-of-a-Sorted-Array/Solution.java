/// Source : https://leetcode-cn.com/problems/squares-of-a-sorted-array/
/// Author : chenlin
/// Time   : 2020-10-16
/// Updated: 2020-10-16

// two pointers
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int left = 0;
        int right = n-1;
        int index = n-1;
        int[] res = new int[n];
        while(res >= 0){
            // 相加小于零说明A[left]的绝对值在当前[left...right]中最大
            // 相加大于零说明A[right]的绝对值在当前[left...right]中最大
            if(A[left] + A[right] < 0){
                res[index--] = A[left]*A[left];
                left++;
            }else{
                res[index--] = A[right]*A[right];
                right--;
            }
        }
        return res;
    }
}
