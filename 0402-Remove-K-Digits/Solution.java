/// Source : https://leetcode-cn.com/problems/remove-k-digits/
/// Author : chenlin
/// Time   : 2020-11-15
/// Updated: 2020-11-15

// monotonous stack
// Time Complexity: O(n)
// Space Complexity: O(n)
// 从左到右遍历维护一个单调双端队列存放当前的答案序列，同时注意删除元素个数的上限，从后往前删
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();  // 保持双端队列中的数据单调不减
        int n = num.length();
        for(int i = 0;i < num.length();i++){
            char c = num.charAt(i);
            while(!deque.isEmpty() && k>0 && deque.peekLast()>c){ // 注意删除的元素个数不能超过k
                deque.pollLast();
                k--;  // 每删除一个元素，需要删除的元素个数减一
            }
            deque.offerLast(c);
        }
        // 通过单调栈维护后删除元素不足k的话继续从后往前删除元素
        for(int i = 0;i < k;i++){
            deque.pollLast();
        }
        StringBuilder res = new StringBuilder();
        boolean leadingZero = true; // 标记遍历到零的时候是否是前导零
        while(!deque.isEmpty()){
            char c = deque.pollFirst();
            if(leadingZero && c == '0') continue;
            leadingZero = false;  // 第一次遇到不是零的元素开始再遇到零就不是前导零了
            res.append(c);
        }
        return res.length() == 0? "0": res.toString();
    }
}
