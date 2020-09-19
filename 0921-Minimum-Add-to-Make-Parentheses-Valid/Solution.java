/// Source : https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/
/// Author : chenlin
/// Time   : 2020-09-19
/// Updated: 2020-09-19

// match
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    // 以左括号为基准维护对右括号的需求数need
    public int minAddToMakeValid(String S) {
        int res = 0; // 记录左括号的插入次数
        int need = 0; // 记录右括号的需求量
        for(int i = 0;i<S.length();i++){
            char cur = S.charAt(i);
            if(cur == '('){
                need++;
            }else{
                need--;
                if(need == -1){
                    res++;
                    need = 0;
                }
            }
        }
        // 返回左括号的插入次数和还需要的右括号数的和
        return res + need;
    }
}
