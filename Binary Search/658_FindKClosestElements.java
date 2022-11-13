/*
658. Find K Closest Elements

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

*/

class Solution 
{
    private int getClosestIndex(int [] arr, int x)
    {
        int l = 0, r = arr.length - 1;
        
        while (l < r)
        {
            int  m = l + (r - l)/2;
        
            if (arr[m] >= x)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int l, r;
        
        r = getClosestIndex(arr, x);
        l = r - 1;
    
        while (r - l - 1 < k)
        {
            if (l == -1)
            {
                ++r;
                continue;
            }
            else if (r == n)
            {
                --l;
                continue;
            }
            if (Math.abs(x - arr[l]) <= Math.abs(arr[r] - x))
                --l;
            else
                ++r;
        }
        for (int i = l + 1; i < r; ++i)
            result.add(arr[i]);
 
        return result;
    }
}
