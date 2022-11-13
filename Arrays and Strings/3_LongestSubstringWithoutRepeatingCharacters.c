/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

*/
#define max(a,b) \
    (a > b ? a : b)

int lengthOfLongestSubstring(char *s) 
{
    int  i;
    int  curlen = 0;
    int  maxlen = 0;
    int  past[255];
    int  start   = 0;

    for (i = 0; i < 255; ++i)
        past[i] = -1; //to be used as a map

    for (i = 0; i < strlen(s); ++i)
    {
        int       pos;
        char      c = s[i];

        pos = past[(int)c];
        if (pos != -1) // already exists
        {
            start = (start > pos) ? start : pos + 1;
            curlen = i - start + 1;
        }
        else // wasn't in the past
        {
            ++curlen;
        }
        maxlen = max(maxlen, curlen);
        past[(int)c] = i;
    }
    return maxlen;
}
