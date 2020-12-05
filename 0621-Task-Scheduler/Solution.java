/// Source : https://leetcode-cn.com/problems/task-scheduler/
/// Author : chenlin
/// Time   : 2020-12-05
/// Updated: 2020-12-05

// greedy
// Time Complexity: O(nlogn)
// Space Complexity: O(1)
// 完成所有任务的最短时间取决于出现次数最多的任务数量，应该首先按照冷却时间安排它们
// 待命位置如果够填充其余任务则当前位置数即为最短时间，如果不够则扩容
// 发现扩容后最短时间是任务的个数，所以两者取最小值即可
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] buckets = new int[26];
        for(int i = 0;i<tasks.length;i++){
            buckets[tasks[i]-'A']++;
        }
        Arrays.sort(buckets);
        int max = buckets[25]; // 各个字母出现次数的最大值
        int maxCount = 1;   // 出现次数为最大值的字母个数
        for(int i = 24;i>=0;i--){
            if(buckets[i] == buckets[i+1]) maxCount++;
            else break;
        }
        return Math.max((max-1)*(n+1)+maxCount, tasks.length);
    }
}
