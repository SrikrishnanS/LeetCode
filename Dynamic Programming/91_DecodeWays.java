/* 91. Decode Ways

A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.
 */
class Solution 
{
    public int numDecodings(String s) 
    {
        char [] str = s.toCharArray();
        int     len = str.length;
        int []  dp  = new int[len];
        
        dp[0] = str[0] == '0' ? 0 : 1;
        
        for (int i = 1; i < len; ++i)
        {
            if (str[i] != '0')
                dp[i] = dp[i-1];

            int val = Integer.valueOf(
                        new String(new char[]{str[i-1], str[i]}));    
            
            if (val >= 10 && val <= 26)
            {
                if (i >= 2)
                    dp[i] += dp[i-2];
                else
                    dp[i] += 1;
            }
            
        }
        return dp[len-1];
    }
}
