/* 1218. Longest Arithmetic Subsequence of Given Difference

Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.
 */
class Solution 
{
    public int longestSubsequence(int[] arr, int diff) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        
        for  (int i = 0; i < arr.length; ++i)
        {
            int val = arr[i];
            
            if (map.containsKey(val - diff))
                map.put(val, 1 + map.get(val - diff));
            else
                map.put(val, 1);
            maxLen = Math.max(maxLen, map.get(val));
        }
        return maxLen;
    }
}
