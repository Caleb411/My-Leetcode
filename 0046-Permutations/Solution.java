/// Source : https://leetcode-cn.com/problems/permutations/
/// Author : chenlin
/// Time   : 2020-10-15
/// Updated: 2020-10-15

// backtrack
// Time Complexity: O(n!)
// Space Complexity: O(n)
// 回溯算法三要素：路径、选择列表、结束条件
class Solution {
    
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        dfs(nums, track);
        return res;
    }

    private void dfs(int[] nums, LinkedList<Integer> track){
        if(track.size() == nums.length){
            res.add(new LinkedList(track));
        }
        for(int i = 0;i < nums.length;i++){
            // 当前的选择列表是nums中不在trace中的元素
            if(track.contains(nums[i])) continue;
            track.add(nums[i]);
            dfs(nums, track);
            track.removeLast();
        }
    }
}
