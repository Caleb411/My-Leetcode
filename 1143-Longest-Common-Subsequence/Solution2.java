/// Source : https://leetcode-cn.com/problems/longest-common-subsequence/
/// Author : chenlin
/// Time   : 2020-10-28
/// Updated: 2020-10-28

// iterative dp
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        // 初试状态：dp[0][...] = dp[...][0] = 0 代表两个字符串至少有一个是空的情况
        // dp[i][j]代表text1[0...i-1]和text2[0...j-1]的最长公共子序列的长度
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
