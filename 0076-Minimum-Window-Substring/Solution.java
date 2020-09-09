/// Source : https://leetcode-cn.com/problems/minimum-window-substring/
/// Author : chenlin
/// Time   : 2020-09-09
/// Updated: 2020-09-09

// sliding window
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c: t.toCharArray()) need.put(c, need.getOrDefault(c, 0)+1);
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0, len = s.length()+1;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).equals(need.get(c))){ // map里存的是Integer对象，用equals不用==
                    valid++;
                }
            }

            while(valid == need.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){ // [-128,127)这个范围的数字是同一个Integer对象可以用==
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }

        if(len == s.length()+1){
            return "";
        }else{
            return s.substring(start, start+len);
        }
    }
}
