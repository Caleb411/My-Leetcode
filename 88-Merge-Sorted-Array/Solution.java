/// Source : https://leetcode-cn.com/problems/merge-sorted-array/
/// Author : chenlin
/// Time   : 2020-09-06
/// Updated: 2020-09-06

// merge
// Time Complexity: O(m+n)
// Space Complexity: O(m)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0 , nums1_copy, 0, m);

        int p1 = 0;
        int p2 = 0;
        int p = 0;

        while((p1<m)&&(p2<n)){
            if(nums1_copy[p1]<nums2[p2]){
                nums1[p] = nums1_copy[p1];
                p1++;
            }else{
                nums1[p] = nums2[p2];
                p2++;
            }
            p++;
        }

        if(p1<m){
            System.arraycopy(nums1_copy, p1, nums1, p1+p2, m+n-p1-p2);
        }
        if(p2<n){
            System.arraycopy(nums2, p2, nums1, p1+p2, m+n-p1-p2);
        }
    }
}
