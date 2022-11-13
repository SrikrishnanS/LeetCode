/*
1209. Remove All Adjacent Duplicates in String II

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

*/

class Solution 
{
    public String removeDuplicates(String s, int k) 
    {
        StringBuilder sb = new StringBuilder(s);
        int  [] count  = new int[s.length()];
                
        for (int i = 0; i < sb.length(); ++i)
        {
            if (i == 0 || sb.charAt(i)  !=  sb.charAt(i-1)) // different character
                count[i] = 1;
            else // same character as previous
            {
                count[i] = count[i-1] + 1;
                if (count[i] == k)
                {
                    sb.delete(i - k + 1, i + 1); // remove duplicate chars
                    i -= k;
                }
            }
        }
        return sb.toString();
    }
}
