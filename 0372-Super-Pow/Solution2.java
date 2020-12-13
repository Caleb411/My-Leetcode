/// Source : https://leetcode-cn.com/problems/super-pow/
/// Author : chenlin
/// Time   : 2020-12-13
/// Updated: 2020-12-13

// mod + pow + binary
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution2 {

    int base = 1337;

    // (a*b)%base=(a%base)(b%base)%base
    private int mypow(int a, int k){
        if(k == 0) return 1;
        a %= base;

        if(k % 2 == 1){
            return (a*mypow(a,k-1)) % base;
        }else{
            int sub = mypow(a, k/2);
            return (sub*sub) % base;
        }
    }

    public int superPow(int a, int[] b){
        return superPow(a, b, b.length);
    }

    // a^[1,2,3,4]=a^4*a^[1,2,3,0]=a^4*(a^[1,2,3])^10
    private int superPow(int a, int[] b, int n) {
        if(n == 0) return 1;
        int last = b[n-1];
        int part1 = mypow(a, last);
        int part2 = mypow(superPow(a, b, n-1), 10);
        return (part1*part2)%base;
    }
}
