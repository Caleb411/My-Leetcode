/// Source : https://leetcode-cn.com/problems/keys-and-rooms/
/// Author : chenlin
/// Time   : 2020-08-31
/// Updated: 2020-08-31

// string search
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();    // 首尾有空格不作考虑
        for(int i = 0;i < str.length;i++){
            if(str[i] >= '0' && str[i] <= '9'){
                numSeen = true;
            }else if(str[i] == '.'){
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                if(eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false;    // 如果e或E后面没有数字则应该是false
            }else if(str[i] == '+' || str[i] == '-'){
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return numSeen;
    }
}
