/* 1048. Longest String Chain

You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.
 */
class Solution 
{
    public int longestStrChain(String[] words) 
    {
        Map<String, Integer> map = new HashMap<>();
        int maxLen = 0;
        Arrays.sort(words, (a, b)->a.length() - b.length());

        for (String s : words)
        {
            int curlen = 0;
            for (int i = 0; i < s.length(); ++i)
            {
                String p = s.substring(0, i) + s.substring(i + 1, s.length());
                curlen = Math.max(curlen, 1 + map.getOrDefault(p, 0));
            }
            map.put(s, curlen);
            maxLen = Math.max(maxLen, curlen);
        }
        return maxLen;
    }
}
