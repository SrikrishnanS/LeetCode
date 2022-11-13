/*
1358. Number of Substrings Containing All Three Characters

Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.
*/

class Solution 
{
    public int numberOfSubstrings(String s) 
    {
        int start =  0, end = 0;
        int [] map = new int[3];
        int count = 0;
        
        while (end < s.length())
        {
            char ch = s.charAt(end);
            
            ++map[ch - 'a'];

            while (start <= end && map[0] > 0 && map[1] > 0 && map[2] > 0)
            {
                ch = s.charAt(start);
                --map[ch - 'a'];
                ++start;
            }
            count += start;
            ++end;            
        }
        return count;
    }
}