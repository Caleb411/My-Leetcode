/// Source : https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
/// Author : chenlin
/// Time   : 2020-09-12
/// Updated: 2020-09-12

// map
// Time Complexity: O(m+n)
// Space Complexity: O(m+n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums2.length];
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int index = 0;
        for(int num: nums2){
            if(map.getOrDefault(num, 0)>0){
                res[index++] = num;
                map.put(num, map.get(num)-1);
            }
        }
        return Arrays.copyOf(res, index);
    }
}
