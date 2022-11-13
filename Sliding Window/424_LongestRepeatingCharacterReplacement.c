/* 424. Longest Repeating Character Replacement

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
#define max(a,b) ((a > b) ? a : b)

int maxCount (int *c, int n)
{
    int mc = c[0];
    for (int i = 1; i < n; ++i)
        if (c[i] > mc)
            mc = c[i];
    return mc;
}

int characterReplacement(char * s, int k)
{
    int count[26] = {0}; // maps char to its count
    int l = 0, r;
    int maxsz = 0;
    
    for (r = 0; r < strlen(s); ++r)
    {
        ++count[s[r] - 'A'];
        
        if ((r - l + 1) - maxCount(count, 26) > k) 
                         // more chars need replacement than allowed
        {
            --count[s[l] - 'A'];
            ++l;
        }
        maxsz = max(maxsz, r-l+1);
    }
    return maxsz;
}
