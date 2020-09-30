/// Source : https://leetcode-cn.com/problems/random-pick-with-blacklist/
/// Author : chenlin
/// Time   : 2020-09-30
/// Updated: 2020-09-30

// random read
// Time Complexity: O(1)
// Space Complexity: O(n)
// 将区间看成一个数组，将黑名单中的数字移到数组末尾
// 注意两种特殊情况：
// 情况1：需要映射到其他元素的黑名单元素在[size,n)中
// 情况2：需要映射到其他元素的黑名单元素不在[size,n)中，但映射到的元素是黑名单元素
class Solution {

    int size;
    Map<Integer, Integer> map;
    Random random = new Random();

    // 相当于使用map将所有不在黑名单中的数字放在了[0,size)中，让数组在逻辑上是紧凑的，方便随机取元素
    public Solution(int N, int[] blacklist) {
        map = new HashMap<>();
        size = N - blacklist.length;
        // 情况2处理办法：利用map作为blacklist的查找表
        for(int b: blacklist){
            map.put(b, 666);
        }
        int last = N-1;
        for(int b: blacklist){
            if(b >= size) continue; // 情况1处理办法：已经在[size,n)中的黑名单元素不能为其添加映射
            while(map.containsKey(last)){ // 情况2处理办法：确保last不是黑名单元素
                last--;
            }
            map.put(b, last);
            last--;
        }
    }
    
    // 随机生成一个索引，如果索引在黑名单中需要映射到其他位置，不在直接返回
    public int pick() {
        int index = random.nextInt(size);
        if(map.containsKey(index)){
            return map.get(index);
        }
        return index;
    }
}
