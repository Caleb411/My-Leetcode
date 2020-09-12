/// Source : https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
/// Author : chenlin
/// Time   : 2020-09-12
/// Updated: 2020-09-12

// sort + two pointers
// Time Complexity: O(mlog(m)+nlog(n))
// Space Complexity: O(min(m,n))
class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int[] res = new int[Math.min(len1, len2)];
        while(index1 < len1 && index2 < len2){
            if(nums1[index1] == nums2[index2]){
                res[index++] = nums1[index1];
                index1++;
                index2++;
            }else if(nums1[index1]<nums2[index2]){
                index1++;
            }else{
                index2++;
            }
        }
        return Arrays.copyOf(res, index);
    }
}
