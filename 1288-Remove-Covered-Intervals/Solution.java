/// Source : https://leetcode-cn.com/problems/remove-covered-intervals/
/// Author : chenlin
/// Time   : 2020-09-25
/// Updated: 2020-09-25

// intervals
// Time Complexity: O(nlogn)
// Space Complexity: O(1)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 对所有区间按起点升序排序，起点相同按终点降序排序（若为升序会误判为相交）
        Arrays.sort(intervals, (a,b)->{
            if(a[0] == b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });

        int res = 0;    // 记录被覆盖区间的个数

        // 当前比较区间
        int left = intervals[0][0];
        int right = intervals[0][1];

        // 遍历查看被比较区间是否被比较区间覆盖
        // 分三种情况讨论，因为区间的左端点已经排好序了，只需考虑右端点
        for(int i = 1;i<intervals.length;i++){
            // -----
            //  ---
            if(right >= intervals[i][1]){
                // 找到一个被覆盖的区间
                res++;
            }
            // -----
            //   -----
            if(right < intervals[i][1] && right >= intervals[i][0]){
                // 合并区间形成更大的比较区间
                right = intervals[i][1];
            }
            // -----
            //        -----
            if(right < intervals[i][0]){
                // 更新比较区间为当前区间
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length-res;
    }
}
