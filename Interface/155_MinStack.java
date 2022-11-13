/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.

*/

class MinStack 
{
    private Stack<int[]> S; // [0] : val [1] : min so far
    
    public MinStack() 
    {
        S = new Stack<int[]>();
    }
    
    public void push(int val) 
    {
        int min = S.empty() ? val : Math.min(val, S.peek()[1]);
    
        S.push(new int[]{val, min});
    }

    public void pop() 
    {
        S.pop();        
    }
    
    public int top() 
    {
        return S.peek()[0];
    }
    
    public int getMin() 
    {
        return S.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */