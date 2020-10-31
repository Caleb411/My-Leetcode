/// Source : https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
/// Author : chenlin
/// Time   : 2020-10-31
/// Updated: 2020-10-31

// random read
// Time Complexity: O(1)
// Space Complexity: O(n)
class RandomizedCollection {

    Map<Integer, Set<Integer>> idx; // 数值到索引列表的映射（因为元素可重复）
    List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        idx = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<>());
        set.add(nums.size()-1);
        idx.put(val, set);
        return set.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!idx.containsKey(val)){
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator();
        int i = it.next();
        int lastNum = nums.get(nums.size()-1);
        // 把最后一个元素保存到待删除元素的位置
        nums.set(i, lastNum);
        // 维护idx（如果val和lastNum相同，以下四步操作顺序不同结果会出错）
        idx.get(lastNum).remove(nums.size() - 1);
        idx.get(val).remove(i);
        // 如果要删除的就是最后一个元素，则不需要添加lastNum的新位置
        if (i != nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        // 删除最后一个元素
        nums.remove(nums.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
