/// Source : https://leetcode-cn.com/problems/group-anagrams/
/// Author : chenlin
/// Time   : 2020-12-14
/// Updated: 2020-12-14

// hashmap
// Time Complexity: O(nklogk)
// Space Complexity: O(nk)
// 对字母异位词分组可以使用它们共同的表达作为键在map中进行收集（共同的表达即它们排序后的结构）
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
