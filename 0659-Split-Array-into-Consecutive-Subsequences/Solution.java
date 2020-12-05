/// Source : https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
/// Author : chenlin
/// Time   : 2020-12-05
/// Updated: 2020-12-05

// greedy
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> nc = new HashMap<>();
        Map<Integer, Integer> tail = new HashMap<>();
        for(int num: nums){
            nc.put(num, nc.getOrDefault(num, 0)+1);
        }
        for(int num: nums){
            if(nc.get(num) <= 0) continue;
            if(tail.getOrDefault(num-1,0) > 0){ // 当前元素尽量合并到前面的子序列，因为后面可能不够
                nc.put(num, nc.get(num)-1);
                tail.put(num-1, tail.get(num-1)-1);
                tail.put(num, tail.getOrDefault(num, 0)+1);
            }else if(nc.getOrDefault(num+1,0)>0 && nc.getOrDefault(num+2,0)>0){
                nc.put(num, nc.get(num)-1);
                nc.put(num+1, nc.get(num+1)-1);
                nc.put(num+2, nc.get(num+2)-1);
                tail.put(num+2, tail.getOrDefault(num+2, 0)+1);
            }else{
                return false;
            }
        }
        return true;
    }
}
