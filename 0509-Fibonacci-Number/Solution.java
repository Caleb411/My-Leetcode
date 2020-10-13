/// Source : https://leetcode-cn.com/problems/fibonacci-number/
/// Author : chenlin
/// Time   : 2020-10-13
/// Updated: 2020-10-13

// dynamic programming
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int pre = 0;
        int cur = 1;
        for(int i = 2;i <= n;i++){
            int sum = (pre + cur)%1000000007;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}
