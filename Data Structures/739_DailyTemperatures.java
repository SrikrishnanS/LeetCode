/* 739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
class Solution 
{
    public int[] dailyTemperatures(int[] temperatures) 
    {
        int[] stack = new int[temperatures.length];
        int   top = -1;
        int[] ret = new int[temperatures.length];
    
        for (int i = 0; i < temperatures.length; i++) 
        {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) 
            {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ret;
    }
}
