/// Source : https://leetcode-cn.com/problems/word-ladder/
/// Author : chenlin
/// Time   : 2020-11-05
/// Updated: 2020-11-05

// shortest path
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);  // 可以快速判断某个枚举字符串的合法性
        if(wordSet.size() == 0 || !wordSet.contains(endWord)){
            return 0;
        }
        // 图的广度优先遍历求无向图的最短路径（边遍历边进行状态转移）
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                String cur = queue.poll();
                if(nextIsEnd(cur, endWord, queue, visited, wordSet)){
                    return step+1;
                }
            }
            step++;
        }
        return 0;
    }

    //判断队列中的某个元素的下一个元素是不是目标字符串（使用逐个枚举的方法可以在O(1)时间复杂度内完成）
    private boolean nextIsEnd(String cur, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet){
        char[] charArray = cur.toCharArray();
        for(int i = 0;i < charArray.length;i++){
            char originChar = charArray[i];
            for(char c = 'a';c <= 'z';c++){
                if(c == originChar) continue;
                charArray[i] = c;
                String nextWord = String.valueOf(charArray);
                if(wordSet.contains(nextWord) && !visited.contains(nextWord)){
                    if(nextWord.equals(endWord)){
                        return true;
                    }
                    queue.add(nextWord);
                    visited.add(nextWord);  // 加入队列意味着一定会被访问
                }
            }
            charArray[i] = originChar;
        }
        return false;
    }
}
