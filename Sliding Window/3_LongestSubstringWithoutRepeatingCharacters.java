/* 3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.
 */

class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        Set<Character> seen = new HashSet<Character>();
        int l = 0, r = 0;
        int maxLen  = 0;
    
        while (r < s.length())
        {
            while (seen.contains(s.charAt(r)))
                seen.remove(s.charAt(l++));
            
            seen.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
            ++r;
        }
        return maxLen;
    }
}
