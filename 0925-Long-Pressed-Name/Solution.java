/// Source : https://leetcode-cn.com/problems/long-pressed-name/
/// Author : chenlin
/// Time   : 2020-10-21
/// Updated: 2020-10-21

// two pointers
// Time Complexity: O(n+m)
// Space Complexity: O(1)
// 看typed是否遵循name这个模式
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while(j < typed.length()){
            if(i < name.length() && name.charAt(i)==typed.charAt(j)){ // 逐个匹配
                i++;
                j++;
            }else if(j > 0 && typed.charAt(j) == typed.charAt(j-1)){ // 多余匹配
                j++;
            }else{
                return false; // 其他情况
            }
        }
        return i == name.length();  // name中所有元素是否都被匹配
    }
}
