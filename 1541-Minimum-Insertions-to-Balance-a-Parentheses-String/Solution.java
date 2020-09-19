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
                // 因为一个左括号必须对应两个连续的右括号，当前左括号前右括号的需求必须是偶数
                // 如果是奇数说明当前左括号之前缺一个右括号
                // 接下来的右括号不能作为当前左括号之前的匹配
                if(need % 2 == 1){
                    // 需要插入一个右括号
                    // 这里需要插入的右括号不能在接下来的右括号中取了，所以need要--，插入的个数1加到res中
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
