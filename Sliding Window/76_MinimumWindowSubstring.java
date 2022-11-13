/* 76. Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.
 */
class Solution
{
    public String minWindow(String s, String t) 
    {
        Map<Character, Integer> reference = new HashMap<Character, Integer>();
        Map<Character, Integer> window    = new HashMap<Character, Integer>();
        int                     l = 0, r = 0;
        int                     curLen = 0; 
        int                     minL = -1, minR = -1;
        int                     minLen = -1;

        // reference map, for string t
        for (char ch : t.toCharArray())
            reference.put(ch, reference.getOrDefault(ch, 0) + 1); 

        while (r < s.length()) 
        {
            char ch = s.charAt(r);
          
            // update the character count for ch
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // is the new character desirable? 
            if (reference.containsKey(ch) && 
                window.get(ch) == (int)reference.get(ch))
                curLen++;

            // slide l as long has the window has desirable chars
            while (l <= r && curLen == reference.size())
            {
                // r - l + 1 is the size of the current window
                if (minLen == -1 || r - l + 1 < minLen)
                {
                    minLen = r - l + 1;
                    minL = l;
                    minR = r;
                }
                // we're about to slide l, so update l's char count
                ch = s.charAt(l);
                window.put(ch, window.get(ch) - 1);
                // if current window char count doesn't match, update curLen
                if (reference.containsKey(ch) && 
                    window.get(ch) < reference.get(ch))
                    --curLen;

                ++l;
            }
            ++r;
        }
        return minLen == -1 ? "" : s.substring(minL, minR + 1);
    }
}
