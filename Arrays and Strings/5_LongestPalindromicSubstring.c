/*
5. Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

*/

int getMaxPalindromeLength(char *s, int left, int right, int *off, int slen)
{    
    if (left < 0 || right >= slen)
       return 0;

    while (left >= 0 && right < slen)
    {
        if (s[left] != s[right])
            break;
        --left;
        ++right;
    }  
    *off = left+1;
    return right - *off;
}

char * longestPalindrome(char * s)
{
    char *p;
    int  maxlen = 0;
    int  i;
    int  maxoffset;
    int  slen = strlen(s);
    
    for (i = 0; i < slen; ++i)
    {
        int  offset;
        int oddlen  = getMaxPalindromeLength(s, i, i, &offset, slen);
        if (oddlen > maxlen)
        {
            maxlen = oddlen;
            maxoffset = offset;
        }

        int evenlen = getMaxPalindromeLength(s, i, i+1, &offset, slen);
        if (evenlen > maxlen)
        {
            maxlen = evenlen;
            maxoffset = offset;
        }
    }
    p = &s[maxoffset];
    p[maxlen] = '\0';
    return p;
}
