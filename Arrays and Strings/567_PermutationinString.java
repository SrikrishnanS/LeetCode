/*
567. Permutation in String

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1''s permutations is the substring of s2.

*/

class Solution
{
    public boolean checkInclusion(String s1, String s2)
    {
        int[] s1map;
        int s1len = s1.length();
        int s2len = s2.length();
        
        if (s1len > s2len)
            return false;

        // get mappings for s1
        s1map = getMap(s1);
    
        for (int i = 0 ; i <= s2len - s1len ; ++i)
        {
            String subs2;
            int[] s2map;
            subs2 = s2.substring(i, i + s1len);
            // get mapping for substring of s2 of length s1len
            s2map = getMap(subs2);
            if (equalsMap(s1map, s2map))
                return true;
        }
        return false;        
    }
    private int[] getMap(String s)
    {
        int[] map = new int[26];
        for (int i = 0 ; i < s.length(); ++i)
            ++map[s.charAt(i) - 'a'];
        return map;
    }
    private boolean equalsMap(int[]map1, int[] map2)
    {        
        if (map1.length != map2.length)
            return false;
        for (int i = 0 ; i < map1.length ; ++i)
        {
            if (map1[i] != map2[i])
                return false;
        }
        return true;
    }
}
