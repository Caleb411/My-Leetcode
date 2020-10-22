/// Source : https://leetcode-cn.com/problems/partition-labels/
/// Author : chenlin
/// Time   : 2020-10-22
/// Updated: 2020-10-22

// greedy algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int n = S.length();
        for(int i = 0;i < n;i++){
            last[S.charAt(i)-'a'] = i;
        }
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < n;i++){
            end = Math.max(end, last[S.charAt(i)-'a']);
            if(i == end){
                res.add(end-start+1);
                start = end+1;
            }
        }
        return res;
    }
}
