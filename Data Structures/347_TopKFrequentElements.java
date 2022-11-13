/* 347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
class Solution
{
    public int[] topKFrequent(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();    
    
        Set<Integer>[] list = new HashSet[nums.length + 1]; // index by count
        int[] results = new int[k];

        for (int n : nums)
        {
            Set<Integer> l;
            int count = map.getOrDefault(n, 0);
            
            map.put(n, count + 1);
        
            l = list[count];
            if (l != null)
                l.remove(n);
            
            l = list[count + 1];
            if (l == null)
                list[count + 1] = l = new HashSet<Integer>();
            l.add(n);
        }
        
        int j = 0;
        for (int n = nums.length; n >= 1; --n)
        {
            Set<Integer> l = list[n];
            
            if (l != null)
                for (int i : l)
                {
                    results[j++] = i;
                    if (j == k)
                        return results;
                }
        }
        return null;
    }
}