/// Source : https://leetcode-cn.com/problems/video-stitching/
/// Author : chenlin
/// Time   : 2020-10-24
/// Updated: 2020-10-24

// greedy
// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int videoStitching(int[][] clips, int T) {
        int start = 0;
        int count = 0;
        // 最多寻找T+1个区间
        for(int i = 0;i <= T;i++){
            // 寻找对于当前start来说最大的end
            int end = 0;
            for(int j = 0;j < clips.length;j++){
                // 只考虑满足左边界小于等于start的区间
                if(clips[j][0] <= start){
                    end = Math.max(end, clips[j][1]);
                }  
            }
            count++;
            if(end >= T){
                return count;
            }
            // 更新start寻找下一个区间
            start = end;
        }
        return -1;
    }
}
