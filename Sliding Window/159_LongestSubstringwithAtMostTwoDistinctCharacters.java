/*
159. Longest Substring with At Most Two Distinct Characters

Given a string s, return the length of the longest substring that contains at most two distinct characters.

*/

class Solution 
{
    public int lengthOfLongestSubstringTwoDistinct(String s) 
    {
        Map <Character, Integer> map = new HashMap<>(); // character -> count
        int start = 0, end = 0;
        int maxLen = 0;
    
        while (end < s.length())
        {
            char ch = s.charAt(end);
            
            map.put(ch, 1 + map.getOrDefault(ch, 0));
        
            // shrink the size if window size > 2
            if (map.size() > 2)
            {
                ch = s.charAt(start);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            
                if (map.get(ch) == 0)
                    map.remove(ch);
                ++start;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            ++end;
        }
        return maxLen;
    }
}
