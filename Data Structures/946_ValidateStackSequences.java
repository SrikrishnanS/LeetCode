/*
946. Validate Stack Sequences

Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

*/

class Solution
{
    public boolean validateStackSequences(int[] pushed, int[] popped)
    {
        Stack<Integer> S = new Stack<Integer>();

        int i = 0;
        for (int n : pushed)
        {
            S.push(n);

            while (!S.isEmpty() && S.peek() == popped[i])
            {
                S.pop();
                ++i;
            }
        }
        return (i == pushed.length);
    }
}
