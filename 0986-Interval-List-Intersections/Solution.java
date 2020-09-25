/// Source : https://leetcode-cn.com/problems/interval-list-intersections/
/// Author : chenlin
/// Time   : 2020-09-25
/// Updated: 2020-09-25

// intervals
// two pointers
// Time Complexity: O(m+n)
// Space Complexity: O(m+n)
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A.length == 0 || B.length == 0) return new int[0][];
        int a = 0;
        int b = 0;
        int[][] res = new int[A.length+B.length][2];
        int index = 0;  // 指向当前待插入元素的位置
        while(a < A.length && b < B.length){
            int al = A[a][0];
            int ar = A[a][1];
            int bl = B[b][0];
            int br = B[b][1];
            // 考虑什么时候有交集：正难则反
            // 什么时候没有交集：ar < bl || br < al
            // 什么时候有交集就是其否命题
            if(ar >= bl && br >= al){
                // 交集就是尽量往短了取，即左边界的最大值和右边界的最小值
                res[index][0] = Math.max(al, bl);
                res[index][1] = Math.min(ar, br);
                index++;
            }
            // 是否更新看的是右边界
            if(ar < br){
                a++;
            }else{
                b++;
            }
        }
        return Arrays.copyOf(res, index);
    }
}
