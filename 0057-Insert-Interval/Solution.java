/// Source : https://leetcode-cn.com/problems/insert-interval/
/// Author : chenlin
/// Time   : 2020-11-04
/// Updated: 2020-11-04

// intervals
// Time Complexity: O(n)
// Space Complexity: O(1)
// 从左到右遍历区间列表，根据每个区间和新区间的位置关系分三种情况讨论
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int i = 0;
        // 新区间         [...]
        // 区间列表 [...]
        while(i < len && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        // 新区间      [...]
        // 区间列表 [...] 
        // 新区间      [...]
        // 区间列表       [...]
        while(i < len && newInterval[1] >= intervals[i][0]){  // 循环条件不好确定，可以通过排除第一种情况和第二种情况的排除法确定
            if(intervals[i][0] < newInterval[0]){
                newInterval[0] = intervals[i][0];
            }
            if(intervals[i][1] > newInterval[1]){
                newInterval[1] = intervals[i][1];
            }          
            i++;
        }
        res.add(newInterval); // 对于第二种情况，区间之间存在交集，需要合并，只需要扩大newInterval的边界，在循环外将newInterval加入一次结果集即可
        // 新区间 [...]
        // 区间列表     [...]
        while(i < len){
            res.add(intervals[i]);
            i++;
        }
        // 传入的二维数组对象的大小小于等于list.size()即可
        return res.toArray(new int[0][]);
    }
}
