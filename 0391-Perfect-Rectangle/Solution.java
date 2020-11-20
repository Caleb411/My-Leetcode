/// Source : https://leetcode-cn.com/problems/perfect-rectangle/
/// Author : chenlin
/// Time   : 2020-11-20
/// Updated: 2020-11-20

// rectangle
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int X1 = Integer.MAX_VALUE;
        int Y1 = Integer.MAX_VALUE;
        int X2 = Integer.MIN_VALUE;
        int Y2 = Integer.MIN_VALUE;
        int actual_area = 0;
        
        Set<Integer> points = new HashSet<>();  //使用哈希表是因为涉及查找操作
        for(int i = 0;i < rectangles.length;i++){
            X1 = Math.min(X1, rectangles[i][0]);
            Y1 = Math.min(Y1, rectangles[i][1]);
            X2 = Math.max(X2, rectangles[i][2]);
            Y2 = Math.max(Y2, rectangles[i][3]);

            actual_area += (rectangles[i][2]-rectangles[i][0])*(rectangles[i][3]-rectangles[i][1]);
            // 求出当前矩形的四个顶点
            int[][] ps = new int[4][2];
            ps[0] = new int[]{rectangles[i][0], rectangles[i][1]};
            ps[1] = new int[]{rectangles[i][0], rectangles[i][3]};
            ps[2] = new int[]{rectangles[i][2], rectangles[i][1]};
            ps[3] = new int[]{rectangles[i][2], rectangles[i][3]};
            // 出现偶数次的顶点全删，出现奇数次的顶点保留一个
            for(int[] p: ps){
                int x = p[0]*10+p[1];
                if(points.contains(x)){
                    points.remove(x);
                }else{
                    points.add(x);
                }
            }
        }

        int expected_area = (X2-X1)*(Y2-Y1);
        if(actual_area!=expected_area) return false;
        if(points.size()!=4) return false;
        if(!points.contains(X1*10+Y1)) return false;
        if(!points.contains(X1*10+Y2)) return false;
        if(!points.contains(X2*10+Y1)) return false;
        if(!points.contains(X2*10+Y2)) return false;
        return true;
    }
}
