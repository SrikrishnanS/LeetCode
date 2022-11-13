/* 394. Decode String

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 */
class Solution 
{
    public String decodeString(String s) 
    {
        Stack<Integer> N = new Stack<Integer>();
        Stack<String>  S = new Stack<String>();
        int num = 0;
        
        S.push("");
        for (int i = 0; i < s.length(); ++i)
        {
            char c = s.charAt(i);
            
            if (c >= '0' && c <= '9')
            {
                num = (num * 10) + Character.getNumericValue(c);
            }
            else if (c == '[')
            {
                N.push(num);
                num = 0;
                S.push(""); // ready to parse chars now
            }
            else if (c == ']')
            {
                int    n   = N.pop();
                String str = S.pop();
          
                str = buildString(n, str);
                S.push(S.pop() + str);
            }
            else // other ascii characters
            {
                String top = S.pop();
                top += c;
                S.push(top);
            }
        }
    
        // top element in the stack has the result
        return S.pop();
    }
    
    private String buildString(int n, String s)
    {
        String str = "";
        for (int i = 1; i <= n; ++i)
            str += s;
        return str;
    }
    
}
