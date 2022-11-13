/*
680. Valid Palindrome II

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

*/

class Solution 
{
    private boolean isPalindrome(String s, int i, int j)
    {
        while (i < j)
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        return true;
    }
    public boolean validPalindrome(String s) 
    {
        int i, j;
        
        for (i = 0, j = s.length() - 1; i < j; ++i, --j)
            if (s.charAt(i)  != s.charAt(j))
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        return true;
    }
}
