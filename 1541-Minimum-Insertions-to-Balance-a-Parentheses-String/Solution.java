/// Source : https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string/
/// Author : chenlin
/// Time   : 2020-09-19
/// Updated: 2020-09-19

// match
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int minInsertions(String s) {
        int res = 0; // 插入的括号数
        int need = 0; // 记录右括号的需求量
        for(int i = 0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur == '('){
                need+=2;
                // 因为一个左括号需要两个右括号，右括号的需求必须是偶数
                if(need % 2 == 1){
                    // 需要插入一个右括号
                    res++;
                    need--;
                }
            }else{
                need--;
                if(need == -1){
                    // 需要插入一个左括号
                    res++;
                    need = 1;
                }
            }
        }
        return res+need;
    }
}
