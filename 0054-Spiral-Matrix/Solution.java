/// Source : https://leetcode-cn.com/problems/spiral-matrix/
/// Author : chenlin
/// Time   : 2020-09-21
/// Updated: 2020-09-21

// array
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0;i<(Math.min(m,n)+1)/2;i++){
            // 上部
            for(int j = i;j<n-i;j++){
                res.add(matrix[i][j]);
            }
            // 右部
            for(int j = i+1;j<m-i;j++){
                res.add(matrix[j][n-i-1]);
            }
            // 下部
            for(int j = n-i-2;j>=i && i!=m-i-1;j--){
                res.add(matrix[m-i-1][j]);
            }
            // 左部
            for(int j = m-i-2;j>=i+1 && n-i-1!=i;j--){
                res.add(matrix[j][i]);
            }
        }
        return res;
    }
}
