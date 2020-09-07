/// Source : https://leetcode-cn.com/problems/top-k-frequent-elements/
/// Author : chenlin
/// Time   : 2020-09-07
/// Updated: 2020-09-07

// bucket sort
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        
        // 将频率作为数组的下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key: map.keySet()){
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = list.length-1;i>=0&&index<res.length;i--){
            if(list[i] != null){
                for(int j: list[i]){
                    res[index++] = j;
                }
            }
        }
        return res;
    }
}
