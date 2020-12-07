/// Source : https://leetcode-cn.com/problems/score-after-flipping-matrix/
/// Author : chenlin
/// Time   : 2020-12-07
/// Updated: 2020-12-07

// greedy
// Time Complexity: O(mn)
// Space Complexity: O(1)
// 首先要保证第一列都是1 通过行翻转可以保证
// 其次保证其余每一列的1都要比0多 通过列翻转可以保证
class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int res = m * (1<<n-1);
        for(int j = 1;j<n;j++){
            int ones = 0;
            for(int i = 0;i<m;i++){
                if(A[i][0] == 1){
                    ones += A[i][j];
                }else{
                    ones += (1-A[i][j]);
                }
            }
            int max = Math.max(ones, m-ones);
            res += max * (1<<n-1-j);
        }
        return res;
    }
}
