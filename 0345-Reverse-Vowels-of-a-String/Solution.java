/// Source : https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
/// Author : chenlin
/// Time   : 2020-09-06
/// Updated: 2020-09-06

// Collision pointers
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        char[] ch = s.toCharArray();
        String str = "aeiouAEIOU";
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            while(start<end && !str.contains(ch[start]+"")) start++;
            while(start<end && !str.contains(ch[end]+"")) end--;
            swap(ch, start, end);
            start++;
            end--;            
        }
        return new String(ch);
    }

    private void swap(char[] arr, int i, int j){
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
