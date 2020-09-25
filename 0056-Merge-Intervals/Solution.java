/// Source : https://leetcode-cn.com/problems/merge-intervals/
/// Author : chenlin
/// Time   : 2020-09-25
/// Updated: 2020-09-25

// intervals
// Time Complexity: O(nlogn)
// Space Complexity: O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        // 对于返回数组预先不知道开多大空间的情况，可以先开最大空间，再用尾指针指向数组有元素部分的末尾
        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int index = 0;  // 作为数组中的尾指针
        for(int i = 1;i<intervals.length;i++){
            int[] cur = intervals[i]; // 获取当前遍历到的区间
            int[] last = res[index];  // 获取当前合并区间
            if(last[1] >= cur[0]){
                // 当前合并区间可能可以扩大
                last[1] = Math.max(last[1], cur[1]);
            }else{
                // 当前合并区间不可能扩大，加入新的合并区间
                res[++index] = cur;
            }
        }
        return Arrays.copyOf(res, index+1);
    }
}
