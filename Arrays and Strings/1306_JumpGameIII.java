/*
1306. Jump Game III

Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

*/

class Solution
{
    public boolean canReach(int[] arr, int start)
    {
        return canReach(arr, start, 0);
    }
    
    private boolean canReach(int [] arr, int index, int target)
    {
        int val;
        if (index < 0 || index >= arr.length)
            return false; // out of bounds

        val = arr[index];    
        if (val < 0)
            return false; // already visited
        else if (val == target)
            return true;
    
        arr[index] = -1; // mark the index as visited
        if (canReach(arr, index + val, target) ||
            canReach(arr, index - val, target))
            return true;
        return false;
    }
}
