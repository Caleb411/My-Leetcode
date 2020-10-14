/// Source : https://leetcode-cn.com/problems/find-common-characters/
/// Author : chenlin
/// Time   : 2020-10-14
/// Updated: 2020-10-14

// count
// Time Complexity: O(nm)
// Space Complexity: O(1)
// 对每个字符串计算各个字符的频率并更新最小频率数组
class Solution {
    public List<String> commonChars(String[] A) {
        int[] minFreq = new int[26];
        for(int i = 0;i < minFreq.length;i++){
            minFreq[i] = Integer.MAX_VALUE;
        }
        for(int i = 0;i < A.length;i++){
            String str = A[i];
            int[] freq = new int[26];
            for(int j = 0;j < str.length();j++){
                char ch = str.charAt(j);
                freq[ch-'a']++;
            }
            for(int j = 0;j < freq.length;j++){
                minFreq[j] = Math.min(freq[j], minFreq[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0;i < minFreq.length;i++){
            // if(minFreq[i] == Integer.MAX_VALUE) continue;
            for(int j = 0;j < minFreq[i];j++){
                res.add(String.valueOf((char)('a'+i)));
            }
        }
        return res;
    }
}
