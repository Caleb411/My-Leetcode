/// Source : https://leetcode-cn.com/problems/queue-reconstruction-by-height/
/// Author : chenlin
/// Time   : 2020-11-16
/// Updated: 2020-11-16

// greedy
// Time Complexity: O(n^2)
// Space Complexity: O(logn)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 按身高降序排列，身高相同的按前面有多少个比它高的人升序排列
        Arrays.sort(people,(a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        List<int[]> list = new ArrayList<>();
        // 先排大的再排小的，小的排到前面不会影响已经排好的大的
        for(int[] i: people){
            list.add(i[1],i);
        }
        return list.toArray(people);
    }
}
