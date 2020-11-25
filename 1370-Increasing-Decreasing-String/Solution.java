/// Source : https://leetcode-cn.com/problems/increasing-decreasing-string/submissions/
/// Author : chenlin
/// Time   : 2020-11-25
/// Updated: 2020-11-25

// bucket count
// Time Complexity: O(n)
// Space Complexity: O(1)
// 这里只涉及小写字母，用数组代替map还能利用其索引有序性
class Solution {
    public String sortString(String s) {
        int[] nums = new int[26];
        for(int i = 0;i<s.length();i++){
            nums[s.charAt(i)-'a']++;
        }
        StringBuilder res = new StringBuilder();
        while(res.length() < s.length()){
            for(int i = 0;i<26;i++){
                if(nums[i]>0){
                    res.append((char)(i+'a'));  // 注意索引向字符的转换
                    nums[i]--;
                }   
            }
            for(int i = 25;i>=0;i--){
                if(nums[i]>0){
                    res.append((char)(i+'a'));  // 注意索引向字符的转换
                    nums[i]--;
                }   
            }
        }
        return res.toString();
    }
}
