import java.util.*;

class MyStack {

    Queue<Integer> saveQ;
    Queue<Integer> inputQ;
    
    /** Initialize your data structure here. */
    public MyStack() {
        saveQ = new LinkedList<Integer>();
        inputQ = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        inputQ.offer(x);
        while(!saveQ.isEmpty()){
            inputQ.offer(saveQ.poll());
        }
        while(!inputQ.isEmpty()){
            saveQ.offer(inputQ.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return saveQ.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return saveQ.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return saveQ.isEmpty();
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
