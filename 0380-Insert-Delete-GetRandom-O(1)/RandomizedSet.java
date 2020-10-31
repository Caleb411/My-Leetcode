/// Source : https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
/// Author : chenlin
/// Time   : 2020-09-30
/// Updated: 2020-09-30

// random read
// Time Complexity: O(1)
// Space Complexity: O(n)
class RandomizedSet {

    List<Integer> list; // 存储元素
    Map<Integer, Integer> map;  // 存储元素到索引的映射
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    // 对数组尾部进行插入和删除操作不会涉及数据搬移，时间复杂度是 O(1)
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());  // 插入元素需要更新map
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    // 如果我们想在O(1)的时间删除数组中的某一个元素val，可以先把这个元素交换到数组的尾部，然后再pop掉
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        // 把最后一个元素移动到当前要删除元素的位置
        int index = map.get(val);
        int last = list.get(list.size()-1);
        list.set(index, last);
        map.put(last, index); // 注意更新原来最后一个元素在map中的索引
        // 删除最后一个元素
        list.remove(list.size()-1);
        map.remove(val);  // 在map中移除要删除的元素
        return true;
    }
    
    /** Get a random element from the set. */
    // 要想随机读取，底层必须用数组实现，且数组必须是紧凑的
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
