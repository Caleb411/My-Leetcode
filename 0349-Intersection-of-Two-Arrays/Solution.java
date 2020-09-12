/// Source : https://leetcode-cn.com/problems/intersection-of-two-arrays/
/// Author : chenlin
/// Time   : 2020-09-12
/// Updated: 2020-09-12

// set
// Time Complexity: O(m+n)
// Space Complexity: O(m+n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for(int num: nums1){
            set.add(num);
        }
        for(int num: nums2){
            if(set.contains(num)){
                resSet.add(num);
            }
        }
        int[] res = new int[resSet.size()];
        int i = 0;
        for(int num: resSet){
            res[i++] = num;
        }
        return res;
    }
}
