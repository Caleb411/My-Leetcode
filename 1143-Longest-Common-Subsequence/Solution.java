/// Source : https://leetcode-cn.com/problems/longest-common-subsequence/
/// Author : chenlin
/// Time   : 2020-10-28
/// Updated: 2020-10-28

// recursive dp
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
class Solution {
    
    int[][] memo;

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        // 值全部初始化为-1代表都没有计算过
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return dp(s1, 0, s2, 0);
    }

    // 定义：计算s1[i...]和s2[j...]的最长公共子序列长度
    private int dp(String s1, int i, String s2, int j){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = 1+dp(s1, i+1, s2, j+1);
        }else{
            memo[i][j] = Math.max(dp(s1, i+1, s2,j),dp(s1, i, s2, j+1));
        }
        return memo[i][j];
    }
}
