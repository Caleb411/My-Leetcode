/// Source : https://leetcode-cn.com/problems/longest-common-prefix/
/// Author : chenlin
/// Time   : 2020-09-24
/// Updated: 2020-09-24

// greedy
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String res = strs[0];
        for(int i = 1;i<strs.length;i++){
            int j = 0;
            for(;j<res.length()&&j<strs[i].length();j++){
                if(strs[i].charAt(j)!=res.charAt(j)){
                    break;
                }
            }
            res = res.substring(0,j);
            if(res.equals("")) return "";
        }
        return res;
    }
}
