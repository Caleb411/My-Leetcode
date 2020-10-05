/// Source : https://leetcode-cn.com/problems/remove-duplicate-letters/
/// Author : chenlin
/// Time   : 2020-10-05
/// Updated: 2020-10-05

// monotonous stack
// Time Complexity: O(n)
// Space Complexity: O(n)
// 本题需要满足三个条件：
// 条件1：去重
// 条件2：保证相对顺序不变
// 条件3：取字典序最小的结果
class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();  // 使用栈保证了元素的顺序性，也允许我们立即操作刚插入的字符
        int[] count = new int[256]; // 记录每个元素出现的次数
        for(int i = 0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
        boolean[] inStack = new boolean[256]; // 记录元素是否在栈中
        for(char c: s.toCharArray()){
            count[c]--; // 因为看的是当前元素的后面有没有栈顶元素，所以每遍历一个元素需要减少它的个数
            if(inStack[c]) continue;  // 如果当前元素在栈中直接继续操作下一个元素，实现去重
            // 入栈之前先进行单调栈的维护操作
            while(!stack.isEmpty() && stack.peek()>c){
                if(count[stack.peek()] == 0) break; // 如果当前元素后面没有栈顶元素，单调栈维护操作直接结束
                inStack[stack.pop()] = false; // 出栈并维护inStack
            }
            // 入栈并维护inStack
            stack.push(c);
            inStack[c] = true;
        }
        // 出栈顺序和结果顺序相反
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
