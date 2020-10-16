/// Source : https://leetcode-cn.com/problems/n-queens/
/// Author : chenlin
/// Time   : 2020-10-16
/// Updated: 2020-10-16

// backtrack
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        char[] ch = new char[n];
        for(int i = 0;i<n;i++){
            ch[i] = '.';
        }
        for(int i = 0;i<n;i++){
            board.add(new String(ch));
        }
        dfs(board, 0);
        return res;
    }

    private void dfs(List<String> board, int row){
        if(row == board.size()){
            res.add(new ArrayList(board));
            return;
        }
        int n = board.get(row).length();
        for(int col = 0;col < n;col++){
            if(!isValid(board, row, col)) continue;
            char[] ch = board.get(row).toCharArray();
            ch[col] = 'Q';
            board.set(row, new String(ch));
            dfs(board, row+1);
            ch[col] = '.';
            board.set(row, new String(ch));
        }
    }

    private boolean isValid(List<String> board, int row, int col){
        int n = board.size();
        for(int i = 0;i < n;i++){
            if(board.get(i).charAt(col) == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
}
