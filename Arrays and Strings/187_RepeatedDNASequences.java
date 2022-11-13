/*
187. Repeated DNA Sequences

The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

*/

class Solution 
{
    public List<String> findRepeatedDnaSequences(String s) 
    {
        Set<String> result = new HashSet<String>();
        Set<String> patterns = new HashSet<String>();
     
        int start = 0;
        int end = 10; // 10-letter long sequence
        while (end <= s.length())
        {
            String p = s.substring(start++, end++); // [start, end)
            if (!patterns.add(p))
                result.add(p);
        }
        return new ArrayList<String>(result);
    }
}
