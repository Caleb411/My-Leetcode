/// Source : https://leetcode-cn.com/problems/reorganize-string/
/// Author : chenlin
/// Time   : 2020-11-30
/// Updated: 2020-11-30

// greedy + count sort
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String reorganizeString(String S) {
        char[] arr = S.toCharArray();
        int[] map = new int[26];
        for(int i = 0;i < arr.length;i++){
            map[arr[i]-'a']++;
        }
        int maxKey = 0;
        int maxValue = 0;
        for(int i = 0;i < map.length;i++){
            if(map[i]>maxValue){
                maxKey = i;
                maxValue = map[i];
            }
        }
        if(maxValue>((arr.length+1)>>1)){   // 贪心算法认为要使得两相邻的字符不同，先要能够让出现次数最多的数能够间隔存放
            return "";
        }
        char[] res = new char[arr.length];
        int index = 0;  // 先填出现次数最多的数再填其余的数，先把偶数位置填满再把奇数位置填满
        while(map[maxKey]-->0){
            res[index] = (char)(maxKey+'a');
            index += 2;
        }
        // 剩余的数字按计数排序的顺序继续进行间隔插入，确保相同数字不相邻
        for(int i = 0;i < map.length;i++){
            while(map[i]-->0){
                if(index>=res.length){
                    index = 1;
                }
                res[index] = (char)(i+'a');
                index += 2;
            }
        }
        return new String(res);
    }
}
