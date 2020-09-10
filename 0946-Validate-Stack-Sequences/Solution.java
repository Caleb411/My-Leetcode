/// Source : https://leetcode-cn.com/problems/validate-stack-sequences/
/// Author : chenlin
/// Time   : 2020-09-10
/// Updated: 2020-09-10

// stack
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    // 按照数组给出的顺序进行入栈和出栈
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        for(int pushIndex = 0, popIndex = 0;pushIndex < pushed.length;pushIndex++){
            stack.push(pushed[pushIndex]);
            while(popIndex < popped.length && !stack.isEmpty() && popped[popIndex] == stack.peek()){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
