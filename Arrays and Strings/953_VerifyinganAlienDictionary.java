/*
953. Verifying an Alien Dictionary

In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

*/

class Solution 
{
    public boolean isAlienSorted(String[] words, String order) 
    {
        for (int i = 0; i < words.length - 1; ++i)
            if (!isAlienSorted(words[i], words[i+1], order))
                return false;  // compare ith and (i+1)th strings
        return true;
    }
    
    // checks if s < t
    private boolean isAlienSorted(String s, String t, String order)
    {
        int  i = 0;
        char a, b;
        int  m, n;
        do
        {
            a = s.charAt(i);
            b = t.charAt(i);
            if (a != b)
            {
                m = order.indexOf(a);   
                n = order.indexOf(b);
                return (m < n);
            }            
            ++i;            
        } while (a == b && i < s.length() && i < t.length());
        
        // if we're here it means strings were not of same length
        // but first few chars of shorter length were the same
        return  (s.length() <= t.length()); 
    }    
}
