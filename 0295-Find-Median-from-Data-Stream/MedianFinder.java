/// Source : https://leetcode-cn.com/problems/find-median-from-data-stream/
/// Author : chenlin
/// Time   : 2020-09-17
/// Updated: 2020-09-17

// two heaps
// Time Complexity: addNum->O(logn) findMedian->O(1)
// Space Complexity: O(n)
class MedianFinder {

    private PriorityQueue<Integer> large; // 存储较大元素的小顶堆
    private PriorityQueue<Integer> small; // 存储较小元素的大顶堆

    /** initialize your data structure here. */
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a,b)->b-a);  // 传入比较器将小顶堆变成大顶堆
    }
    
    // 既要维护两个堆的元素个数之差不能超过1，也要保证small堆顶的元素要小于等于large堆顶的元素
    public void addNum(int num) {
        if(small.size() < large.size()){
            large.offer(num);
            small.offer(large.poll());
        }else{
            small.offer(num);
            large.offer(small.poll());
        }
    }
    
    // 如果总元素个数是奇数则返回元素个数较大的堆的堆顶元素，如果总元素个数是偶数则返回两个堆顶元素的平均值
    public double findMedian() {
        if(large.size() > small.size()){
            return large.peek();
        }else if(large.size() < small.size()){
            return small.peek();
        }else{
            return (large.peek() + small.peek()) / 2.0;
        }
    }
}
