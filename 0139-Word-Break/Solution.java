/// Source : https://leetcode-cn.com/problems/word-break/
/// Author : chenlin
/// Time   : 2020-11-01
/// Updated: 2020-11-01

// dp
// Time Complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        // dp[i] 表示「长度」为 i 的 s 前缀子串是否可以拆分成 wordDict 中的单词
        dp[0] = true;
        // 状态转移方程：dp[i] = dp[j] && check(s[j..i−1])
        for(int i = 1;i < dp.length;i++){
            // j代表分割点，j==0代表分割点前面的字符串为空
            // j最大为i-1为了确保分割点右边的字符串长度至少为1，这样它才有可能出现在wordDict中
            for(int j = 0;j < i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
