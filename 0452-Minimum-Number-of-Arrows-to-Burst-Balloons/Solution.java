/// Source : https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
/// Author : chenlin
/// Time   : 2020-11-23
/// Updated: 2020-11-23

// intervals + greedy
// Time Complexity: O(nlogn)
// Space Complexity: O(logn)
// 排序后重叠区间肯定连续，再一次遍历找两两重叠的区间组
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->a[1]>b[1]?1:-1); // 传入的比较器使用这种写法防止结果越界
        int count = 0;
        int i = 0;
        while(i<points.length){
            // 以当前区间的右端为基准点，比较接下来区间的左端点
            int right = points[i][1];
            i++;
            while(i<points.length&&right>=points[i][0]){
                i++;
            }
            count++;
        }
        return count;
    }
}
