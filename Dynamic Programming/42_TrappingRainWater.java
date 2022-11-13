/* 42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
class Solution 
{
    public int trap(int[] height) 
    {
        int [] left   = new int[height.length];    
        int [] right  = new int[height.length];
        int    result = 0;

        left[0] = height[0];
        right[height.length - 1] = height[height.length -  1];
        
        for (int i = 1; i < height.length; ++i)
            left[i] = Math.max(height[i], left[i-1]);
        
        for (int i = height.length - 2; i >= 0; --i)
            right[i] = Math.max(height[i], right[i+1]);
    
        for (int i = 1; i < height.length - 1; ++i)
            result += Math.min(left[i], right[i]) - height[i];
    
        return result;
    }
}
