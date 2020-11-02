/// Source : https://leetcode-cn.com/problems/sliding-window-maximum/
/// Author : chenlin
/// Time   : 2020-11-02
/// Updated: 2020-11-02

// monotonic queue
// Time Complexity: O(n)
// Space Complexity: O(k) k -> window size
class Solution {
    // 单调队列实现
    private class MonotonicQueue{
        // 双链表，支持头部和尾部增删元素
        LinkedList<Integer> queue = new LinkedList<>();
        
        public void push(int val){
            // 将前面小于自己的元素都删除
            // 让队列中元素始终是单调递减的顺序
            while(!queue.isEmpty() && queue.getLast() < val){
                queue.removeLast();
            }
            queue.addLast(val);
        }

        // 移除队头元素的时候要传入滑动窗口的第一个元素，队头是这个元素就移除，不是就不作任何操作
        public void pop(int val){
            if(queue.getFirst() == val){
                queue.removeFirst();
            }
        }

        public int max(){
            return queue.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(i < k){  // 先在窗口中放满元素
                window.push(nums[i]);
            }else{  // 元素放满后开始取最大值并滑动
                list.add(window.max());
                window.push(nums[i]); // 窗口中移入下一个值
                window.pop(nums[i-k]);  // 移除窗口的最后一个值
            }
        }
        // 将最后一个窗口中的最大值加入结果集
        list.add(window.max());
        int[] res = new int[list.size()];
        for(int i = 0;i < res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
