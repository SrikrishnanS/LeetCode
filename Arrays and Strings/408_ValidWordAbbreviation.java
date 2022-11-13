/*
408. Valid Word Abbreviation

A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.

For example, a string such as "substitution" could be abbreviated as (but not limited to):

"s10n" ("s ubstitutio n")
"sub4u4" ("sub stit u tion")
"12" ("substitution")
"su3i1u2on" ("su bst i t u ti on")
"substitution" (no substrings replaced)
The following are not valid abbreviations:

"s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
"s010n" (has leading zeros)
"s0ubstitution" (replaces an empty substring)
Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.

A substring is a contiguous non-empty sequence of characters within a string.

*/

class Solution 
{
    public boolean validWordAbbreviation(String word, String abbr) 
    {
        int idx = 0, offset = 0;
        int times = 0;
        
        while (idx < abbr.length() && offset < word.length())
        {
            char ch = abbr.charAt(idx);
            
            if (ch >= '0' && ch <= '9') // digit character
            {
                while (ch >= '0' && ch <= '9')
                {
                    if (times == 0 && ch == '0')
                        return false; // error case
            
                    times = (times * 10) + Character.getNumericValue(ch);
                    if (idx + 1 < abbr.length())
                        ch = abbr.charAt(idx + 1);
                    else
                        ch = '\0';
                    ++idx;
                }
                offset += times;
                times = 0;
            }
            else
            {
                if (ch != word.charAt(offset)) // lower case character
                    return false;
                ++idx;
                ++offset;
            }
        }
        return (word.length() == offset && abbr.length() == idx);
    }
}
