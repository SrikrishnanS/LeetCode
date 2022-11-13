/*
791. Custom Sort String

You are given two strings order and s. All the words of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.

*/

class Solution 
{
    public String customSortString(String order, String s) 
    {
        StringBuilder sb    = new StringBuilder();
        int[]  count  = new int[26];

        // get count of each char in s
        for (int i = 0; i < s.length(); ++i)
        {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        // using order append chars
        for (int i = 0 ; i < order.length(); ++i)
        {
            char c = order.charAt(i);
            for (int j = 0; j < count[c - 'a']; ++j)
                sb.append(c);
            count[c - 'a'] = 0;
        }
        // append remaining chars
        for (int i = 0; i < s.length(); ++i)
        {
            char c = s.charAt(i);
            if (count[c - 'a'] > 0)
                sb.append(c);
        }
        return new String(sb);
    }
}
