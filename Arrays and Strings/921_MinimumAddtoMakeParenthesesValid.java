/*
921. Minimum Add to Make Parentheses Valid

A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

*/

class Solution 
{
    public int minAddToMakeValid(String s) 
    {
        int moves = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); ++i)
        {
            char  ch  = s.charAt(i);
        
            if (ch == '(')
                ++moves;
            else if (ch == ')')
            {
                --moves;
                if (moves < 0)
                {
                    ++start;
                    ++moves;
                }
            }
        }
        return start + moves;
    }
}
