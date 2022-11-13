/* 340. Longest Substring with At Most K Distinct Characters

Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
 */

class Solution 
{
    public int lengthOfLongestSubstringKDistinct(String s, int k) 
    {
        Map <Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int maxLen = 1;
        
        if (s.length() * k == 0)
            return 0;
        
        while (end < s.length())
        {
            char c = s.charAt(end);
            
            map.put(c, map.getOrDefault(c, 0) + 1);
            // shrink the size if condition not met
            if (map.size() > k)
            {
                c = s.charAt(start);
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) == 0)
                    map.remove(c);
                ++start;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            ++end;
        }
        return maxLen;
    }
}
