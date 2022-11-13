/* 1249. Minimum Remove to Make Valid Parentheses

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')'', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 */
class Solution 
{
    public String minRemoveToMakeValid(String s) 
    {
        StringBuilder sb = new StringBuilder();    
        Stack<Character> S = new Stack<Character>();
    
        for (int i = 0; i < s.length(); ++i)
        {
            char ch = s.charAt(i);
            
            if (ch == '(')
                S.push(ch);
            else if (ch == ')')
            {
                if (S.isEmpty())
                    continue;
                S.pop();
            }
            sb.append(ch);
        }

        if (!S.isEmpty())
        {
            S.clear();
            for (int i = sb.length() - 1; i >= 0; --i)
            {
                char ch = sb.charAt(i);

                if (ch == ')')
                    S.push(ch);
                else if (ch == '(')
                {
                    if (S.isEmpty())
                    {
                        sb.deleteCharAt(i);
                        continue;
                    }
                    S.pop();
                }
            }
            if (!S.isEmpty())
                throw new NullPointerException();
        }
        return new String(sb);
    }
}
