/*
895. Maximum Frequency Stack

Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

*/

class FreqStack
{
    // number -> frequency
    Map<Integer, Integer> frequency;

    // frequency -> stack of numbers (order of insertion)
    Map<Integer, Stack<Integer>> stackMap;

    // current max. frequency
    int                   maxFrequency;


    public FreqStack()
    {
        frequency = new HashMap<Integer, Integer>();
        stackMap  = new HashMap<Integer, Stack<Integer>>();
        maxFrequency = 0;
    }

    public void push(int val)
    {
        int newCount = 1 + frequency.getOrDefault(val, 0);

        frequency.put(val, newCount);

        if (newCount > maxFrequency)
            maxFrequency = newCount;

        stackMap.putIfAbsent(newCount, new Stack<Integer>());
        stackMap.get(newCount).push(val);
    }

    public int pop()
    {
        int val = stackMap.get(maxFrequency).pop();

        frequency.put(val, maxFrequency - 1);

        if (stackMap.get(maxFrequency).isEmpty())
            --maxFrequency;

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
