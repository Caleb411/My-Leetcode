/// Source : https://leetcode-cn.com/problems/keys-and-rooms/
/// Author : chenlin
/// Time   : 2020-08-31
/// Updated: 2020-08-31

// dfs
// Time Complexity: O(n+m)
// Space Complexity: O(n)
class Solution {

    boolean[] visited;
    int count;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        count = 0;
        dfs(rooms, 0);
        return n == count;
    }

    private void dfs(List<List<Integer>> rooms, int v){
        visited[v] = true;
        count++;
        for(int w: rooms.get(x)){
            if(!visited[w]){
                dfs(rooms, w);
            }
        }
    }
}
