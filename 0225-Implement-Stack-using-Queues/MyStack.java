/// Source : https://leetcode-cn.com/problems/implement-stack-using-queues/
/// Author : chenlin
/// Time   : 2020-09-10
/// Updated: 2020-09-10

// stack and queue
// Time Complexity: O(n)
// Space Complexity: O(n)
class MyStack {

    Queue<Integer> queueA;
    Queue<Integer> queueB;

    /** Initialize your data structure here. */
    public MyStack() {
        queueA = new LinkedList<>();
        queueB = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(!queueA.isEmpty()){
            queueA.add(x);
        }else if(!queueB.isEmpty()){
            queueB.add(x);
        }else{
            queueA.add(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queueA.isEmpty() && queueB.isEmpty()){
            return -1;
        }
        if(!queueA.isEmpty()){
            while(queueA.size()!=1){
                queueB.add(queueA.poll());
            }
            return queueA.poll();
        }else{
            while(queueB.size()!=1){
                queueA.add(queueB.poll());
            }
            return queueB.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        if(queueA.isEmpty() && queueB.isEmpty()){
            return -1;
        }
        int res;
        if(!queueA.isEmpty()){
            while(queueA.size()!=1){
                queueB.add(queueA.poll());
            }
            res = queueA.poll();
            queueB.add(res);
        }else{
            while(queueB.size()!=1){
                queueA.add(queueB.poll());
            }
            res = queueB.poll();
            queueA.add(res);
        }
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueA.isEmpty() && queueB.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
