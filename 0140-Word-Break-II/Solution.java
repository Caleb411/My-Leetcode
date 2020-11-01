/// Source : https://leetcode-cn.com/problems/word-break-ii/
/// Author : chenlin
/// Time   : 2020-11-01
/// Updated: 2020-11-01

// dp + backtrack
// Time Complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        // dp[i] 表示「长度」为 i 的 s 前缀子串是否可以拆分成 wordDict 中的单词
        dp[0] = true;
        for(int i = 1;i < dp.length;i++){
            // 如果单词集合中的单词长度都不长，从后向前遍历是更快的
            for(int j = i-1;j >= 0;j--){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if(dp[len]){
            Deque<String> path = new LinkedList<>();
            dfs(s, len, wordSet, dp, path, res);
        }
        return res;
    }

    private void dfs(String s, int len, Set<String> wordSet, boolean[] dp, Deque<String> path, List<String> res){
        if(len == 0){
            res.add(String.join(" ", path));
            return;
        }
        // 从后往前看 因为分割点右边部分是可以确定的 左边部分需要拆分
        for(int i = len - 1;i >= 0;i--){
            String suffix = s.substring(i, len);
            if(dp[i] && wordSet.contains(suffix)){
                path.addFirst(suffix);
                dfs(s, i, wordSet, dp, path, res);
                path.removeFirst();
            }
        }
    }
}
