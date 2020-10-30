/// Source : https://leetcode-cn.com/problems/island-perimeter/
/// Author : chenlin
/// Time   : 2020-10-30
/// Updated: 2020-10-30

// floodfill
// Time Complexity: O(nm)
// Space Complexity: O(nm)
class Solution {

    private int R;
    private int C;
    private int grid[][];
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        if(grid == null) return 0;
        R = grid.length;
        if(R == 0) return 0;
        C = grid[0].length;
        if(C == 0) return 0;
        this.grid = grid;
        int ans = 0;
        for(int i = 0;i < R;i++){
            for(int j = 0;j < C;j++){
                if(grid[i][j] == 1){
                    ans += dfs(i,j);
                }
            }
        }
        return ans;
    }

    private int dfs(int x, int y){
        // 从岛屿跨越到海域或边界外则递归到底，并且算作周长的一条边
        if(x<0||x>=R||y<0||y>=C||grid[x][y]==0) return 1;
        // 值为2则递归到底，避免重复遍历，并且不算作周长的一条边
        if(grid[x][y] == 2) return 0;
        // 遍历过的位置对应值记为2
        grid[x][y] = 2;
        int res = 0;
        for(int d = 0;d < 4;d++){
            int nx = x + dirs[d][0];
            int ny = y + dirs[d][1];
            res += dfs(nx, ny);
        }
        return res;
    }
}
