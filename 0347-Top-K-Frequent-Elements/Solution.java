/// Source : https://leetcode-cn.com/problems/top-k-frequent-elements/
/// Author : chenlin
/// Time   : 2020-09-07
/// Updated: 2020-09-07

// minheap
// Time Complexity: O(nlogk)
// Space Complexity: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> map.get(a) - map.get(b)
        );
        for(int key: map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }else if(map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        int[] res = new int[pq.size()];
        for(int i = 0;i<res.length;i++){
            res[i] = pq.remove();
        }
        return res;
    }
}
