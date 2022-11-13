/*
1207. Unique Number of Occurrences

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.

*/

class Solution 
{
    public boolean uniqueOccurrences(int[] arr) 
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        for (int a : arr)
            map.put(a, map.getOrDefault(a, 0) + 1);
        
        for (int n : map.values())
            if (!set.add(n))
                return false;
        
        return true;
    }
}
