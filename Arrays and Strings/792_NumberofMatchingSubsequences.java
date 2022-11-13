/*
792. Number of Matching Subsequences

Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".

*/

class Solution 
{
    public int numMatchingSubseq(String S, String[] words) 
    {
        int count = 0;
        List<Node>[] buckets = new List[26];

        for (int i = 0; i < 26; ++i)
            buckets[i] = new ArrayList<Node>();

        for (String word: words)
            buckets[word.charAt(0) - 'a'].add(new Node(word, 0));


        for (char ch : S.toCharArray())
        {
            List<Node> nodeList = buckets[ch - 'a'];
            buckets[ch - 'a'] = new ArrayList<Node>();
            
            for (Node node: nodeList)
            {
                node.index++;                
                if (node.index < node.word.length())
                    buckets[node.word.charAt(node.index) - 'a'].add(node);
                else
                    ++count;
            }   
        }
        return count;
    }

}

class Node
{
    String word;
    int index;
    public Node(String w, int i) 
    {
        word = w;
        index = i;
    }
}
