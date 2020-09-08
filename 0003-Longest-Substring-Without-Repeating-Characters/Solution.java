/// Source : https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
/// Author : chenlin
/// Time   : 2020-09-08
/// Updated: 2020-09-08

// sliding window
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];  // 记录每个字符在滑动窗口中的出现的次数
        int l = 0;
        int r = -1; // 初始滑动窗口[l...r]不包含任何字符
        int res = 0;

        while(l < s.length()){
            if(r+1 < s.length() && freq[s.charAt(r+1)] == 0){
                r++;
                freq[s.charAt(r)]++;
            }else{
                freq[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r-l+1);
        }

        return res;
    }
}
