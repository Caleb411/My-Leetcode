/// Source : https://leetcode-cn.com/problems/implement-queue-using-stacks/
/// Author : chenlin
/// Time   : 2020-09-10
/// Updated: 2020-09-10

// stack and queue
// Time Complexity: O(n)
// Space Complexity: O(n)
class MyQueue {

    Stack<Integer> stackA;
    Stack<Integer> stackB;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackA.isEmpty() && stackB.isEmpty()){
            return -1;
        }
        if(stackB.isEmpty()){
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stackA.isEmpty() && stackB.isEmpty()){
            return -1;
        }
        if(stackB.isEmpty()){
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
