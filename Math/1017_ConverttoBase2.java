/*
1017. Convert to Base -2

Given an integer n, return a binary string representing its representation in base -2.

Note that the returned string should not have leading zeros unless the string is "0".

*/

class Solution
{
    public String baseNeg2(int n)
    {
        StringBuilder result = new StringBuilder();

        if (n == 0)
            return "0";

        while (n != 0)
        {
            result.append("" + (n & 0x1));
            n = -(n >> 1);
        }
        return result.reverse().toString();
    }
}
