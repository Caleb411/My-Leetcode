/// Source : https://leetcode-cn.com/problems/permutation-in-string/
/// Author : chenlin
/// Time   : 2020-09-09
/// Updated: 2020-09-09

// sliding window
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c: s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while(right<s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            while(right-left==s1.length()){
                if(valid == need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return false;
    }
}
